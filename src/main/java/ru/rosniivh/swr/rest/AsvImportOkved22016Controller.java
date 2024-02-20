package ru.rosniivh.swr.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.AsvImportOkved22016Service;

@RequiredArgsConstructor
@RestController
@RequestMapping("/cat_asv_import_okved2_2016")
public class AsvImportOkved22016Controller {

    private final AsvImportOkved22016Service service;

    @GetMapping("/getOkvedList")
    public ResponseEntity<?> getOkvedList(@RequestParam String term) {
        return ResponseEntity.ok(service.getOkvedList(term));
    }
}
