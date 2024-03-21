package ru.rosniivh.swr.filter;

import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.transaction.Transactional;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.nio.charset.StandardCharsets;
import java.util.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.filter.OncePerRequestFilter;
import ru.rosniivh.swr.domain.auth.UserEntity;
import ru.rosniivh.swr.domain.catalog.BasinWaterManagementBoardEntity;
import ru.rosniivh.swr.domain.catalog.WaterResourcesDivisionEntity;
import ru.rosniivh.swr.repository.BasinWaterManagementBoardRepository;
import ru.rosniivh.swr.repository.UserRepository;
import ru.rosniivh.swr.repository.WaterResourcesDivisionRepository;

@Slf4j
@RequiredArgsConstructor
public class UserInfoFilter extends OncePerRequestFilter {
    private final UserRepository userRepository;
    private final BasinWaterManagementBoardRepository basinWaterManagementBoardRepository;
    private final WaterResourcesDivisionRepository waterResourcesDivisionRepository;

    @Value("${swr.token.header}")
    private String tokenHeader;

    @Value("${swr.cookie.name}")
    private String cookieName;

    @Value("${swr.identity.url}")
    private String identityUrl;

    @Value("${swr.invoke.url}")
    private String invokeUrl;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain)
            throws ServletException, IOException {
        String authToken = request.getHeader(tokenHeader);
        Cookie[] cookies = request.getCookies();
        if (cookies != null && cookies.length > 0) {
            List<Cookie> cookieList = Arrays.stream(cookies)
                    .filter(cookie -> cookie.getName().equals(cookieName))
                    .toList();
            if (!cookieList.isEmpty()) {
                String validCookie = checkCookie(cookieList.get(0));
                log.info(validCookie);
                if (Strings.isNotBlank(validCookie) && validCookie.split(":")[1].contains("true")) {
                    String gisUser = getGisUser(cookies, authToken);
                    if (gisUser.contains("userId")) {
                        String userId = "";
                        String userName = "";
                        for (String s : gisUser.split(",")) {
                            if (s.contains("userId")) {
                                userId = s.split(":")[1].replace("\"", "");
                            }
                            if (s.contains("emailAddress\":")) {
                                userName = s.split(":")[1].replace("\"", "");
                            }
                        }

                        String rolesString = getGisUserRoles(cookies, userId, authToken);
                        List<String> roles = new ArrayList<>();
                        for (String r : rolesString.split(",")) {
                            if (r.contains("name") && r.indexOf("name") <= 1) {
                                roles.add(r.split(":")[1].replace("\"", ""));
                            }
                        }

                        String organisation = getGisUserOrganisation(cookies, userId, authToken);
                        for (String o : organisation.split(",")) {
                            if (o.contains("organizationId") && o.indexOf("organizationId") <= 1) {
                                organisation = o.split(":")[1].replace("\"", "");
                            }
                        }

                        log.info(userId + ": " + userName);
                        log.info(String.join(",", roles));
                        log.info(organisation);

                        UserEntity user = userRepository.findByGisUserId(Integer.parseInt(userId));

                        if (user == null) {
                            createUserForGis(userId, userName, roles, organisation, response);
                        }
                    } else {
                        response.addHeader("Error", "gis-user" + gisUser);
                    }
                } else {
                    response.addHeader("Error", "cookie-token" + validCookie);
                }
            }
        }
        filterChain.doFilter(request, response);
    }

    @Transactional
    public void createUserForGis(
            String userId, String userName, List<String> roles, String org, HttpServletResponse httpResponse) {
        UserEntity user = new UserEntity();
        List<BasinWaterManagementBoardEntity> bwms =
                basinWaterManagementBoardRepository.findByGisOrgId("%," + org + ",%");
        List<WaterResourcesDivisionEntity> wrds = waterResourcesDivisionRepository.findByGisOrgId("%," + org + ",%");
        if (bwms.size() > 0 || wrds.size() > 0) {
            if (bwms.size() > 0) {
                user.setBwmb(bwms.get(0));
            } else {
                user.setWrd(wrds.get(0));
                user.setBwmb(wrds.get(0).getBwmb());
            }
            user.setUsername(userName);
            user.setEmail(userName);
            String md5Hex = DigestUtils.md5Hex(userName + userId).toUpperCase();
            user.setPassword(md5Hex);
            user.setGisUserId(Integer.parseInt(userId));
            user.setAuthorities(Strings.isBlank(roles.toString()) ? "ROLE_USER,ROLE_25" : String.join(",", roles));
            user.setLegacy(false);
            user.setDeleted(false);
            userRepository.save(user);
        } else {
            httpResponse.addHeader("Error", "new-user-no-org-mapping");
        }
    }

    private String checkCookie(Cookie cookie) {
        HttpURLConnection connection = null;
        String targetUrl = identityUrl + cookie.getValue();
        try {
            URL url = new URL(targetUrl);
            connection = (HttpURLConnection) url.openConnection();
            connection.setRequestMethod("GET");
            connection.setRequestProperty("Content-Type", "application/json");
            connection.setRequestProperty("Content-Language", "en-US");
            connection.setUseCaches(false);

            InputStream inputStream = connection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                response.append(line);
                response.append('\r');
            }
            bufferedReader.close();
            return response.toString();

        } catch (Exception e) {
            e.printStackTrace();
            return null;
        } finally {
            if (connection != null) {
                connection.disconnect();
            }
        }
    }

    private String getGisUser(Cookie[] cookies, String authToken) {
        String appendedCookies = appendCookies(cookies);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("cmd", "{\"/user/get-current-user\":{}}");
        paramMap.put("p_auth", authToken);
        return doPost(invokeUrl, paramMap, appendedCookies);
    }

    private String getGisUserRoles(Cookie[] cookies, String userId, String authToken) {
        String appendedCookies = appendCookies(cookies);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("cmd", "{\"/role/get-user-roles\":{\"userId\":\"" + userId + "\"}}");
        paramMap.put("p_auth", authToken);
        return doPost(invokeUrl, paramMap, appendedCookies);
    }

    private String getGisUserOrganisation(Cookie[] cookies, String userId, String authToken) {
        String appendedCookies = appendCookies(cookies);
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("cmd", "{\"/organization/get-user-organizations\":{\"userId\":\"" + userId + "\"}}");
        paramMap.put("p_auth", authToken);
        return doPost(invokeUrl, paramMap, appendedCookies);
    }

    private static String doPost(String url, Map<String, String> param, String cookie) {
        String resultString = "";
        HttpPost httpPost = new HttpPost(url);
        httpPost.setHeader("Cookie", cookie);
        if (param != null) {
            List<NameValuePair> paramList = new ArrayList<>();
            for (String key : param.keySet()) {
                paramList.add(new BasicNameValuePair(key, param.get(key)));
            }
            UrlEncodedFormEntity entity = new UrlEncodedFormEntity(paramList, StandardCharsets.UTF_8);
            httpPost.setEntity(entity);
        }
        try (CloseableHttpClient httpClient = HttpClients.createDefault();
                CloseableHttpResponse response = httpClient.execute(httpPost)) {
            resultString = EntityUtils.toString(response.getEntity(), StandardCharsets.UTF_8);
        } catch (Exception e) {
            e.printStackTrace();
        }

        return resultString;
    }

    private static String appendCookies(Cookie[] cookies) {
        StringBuilder appendedCookies = new StringBuilder();
        for (Cookie c : cookies) {
            appendedCookies.append(c.getName()).append("=").append(c.getValue()).append(";");
        }
        appendedCookies = new StringBuilder(appendedCookies.substring(0, appendedCookies.length() - 1));
        return appendedCookies.toString();
    }
}
