package ru.rosniivh.swr.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.WaterUsageService;

import java.util.List;

@RestController
@RequestMapping("/water-usage")
@RequiredArgsConstructor
@Slf4j
public class WaterUsageController {
    private final WaterUsageService waterUsageService;

    @GetMapping("/getYear2TP")
    public List<Short> getYear2TP() {
        return waterUsageService.getYear2TP();
    }

}
