package ru.rosniivh.swr.config;

import lombok.RequiredArgsConstructor;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ru.rosniivh.swr.filter.UserInfoFilter;
import ru.rosniivh.swr.repository.BasinWaterManagementBoardRepository;
import ru.rosniivh.swr.repository.UserRepository;
import ru.rosniivh.swr.repository.WaterResourcesDivisionRepository;

@Configuration
@RequiredArgsConstructor
public class FilterConfig {
    private final UserRepository userRepository;
    private final BasinWaterManagementBoardRepository basinWaterManagementBoardRepository;
    private final WaterResourcesDivisionRepository waterResourcesDivisionRepository;

    @Bean
    public FilterRegistrationBean<UserInfoFilter> userInfoFilterRegistration() {
        final var filterBean = new FilterRegistrationBean<>(userInfoFilter());
        filterBean.setEnabled(false); // TODO
        return filterBean;
    }

    @Bean
    public UserInfoFilter userInfoFilter() {
        return new UserInfoFilter(userRepository, basinWaterManagementBoardRepository, waterResourcesDivisionRepository);
    }
}
