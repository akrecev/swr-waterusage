package ru.rosniivh.swr.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.AsvStatusService;

@RestController
@RequestMapping("/asv_status")
@RequiredArgsConstructor
public class AsvStatusController {
    private final AsvStatusService service;

    @GetMapping("/")
    public ResponseEntity<?> findById(@RequestParam Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
