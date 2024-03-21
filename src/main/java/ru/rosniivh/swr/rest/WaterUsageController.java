package ru.rosniivh.swr.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.WaterUsageService;

@RestController
@RequestMapping("/water-usage")
@RequiredArgsConstructor
@Slf4j
public class WaterUsageController {
    private final WaterUsageService waterUsageService;

    @Value("${swr.token.header}")
    private String tokenHeader;

    @GetMapping("/getYear2TP")
    public List<Short> getYear2TP() {
        String header = tokenHeader;
        return waterUsageService.getYear2TP();
    }
}
