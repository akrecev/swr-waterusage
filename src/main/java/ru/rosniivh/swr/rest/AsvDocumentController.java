package ru.rosniivh.swr.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.AsvDocumentService;

@RestController
@RequestMapping("/asv_documents")
@RequiredArgsConstructor
public class AsvDocumentController {
    private final AsvDocumentService service;

    @GetMapping("/getAsvDocuments")
    public ResponseEntity<?> getAsvDocuments(@RequestParam String inn, @RequestParam String kpp) {
        return ResponseEntity.ok(service.getAsvDocuments(inn, kpp));
    }

    @GetMapping("/getDocumentWuOkved")
    public ResponseEntity<?> getDocumentWuOkved(@RequestParam Integer uid) {
        return ResponseEntity.ok(service.getDocumentWuOkved(uid));
    }

    @GetMapping("/getCountDocFAWR")
    public ResponseEntity<?> getCountDocFAWR(@RequestParam Integer year, @RequestParam Integer quarter) {
        return ResponseEntity.ok(service.getCountDocFAWR(year, quarter));
    }
}
