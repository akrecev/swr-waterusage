package ru.rosniivh.swr.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.AsvDocumentService;

@AllArgsConstructor
@RestController
@RequestMapping("/asv_documents")
public class AsvDocumentController {

    private final AsvDocumentService service;

    @GetMapping("/getAsvDocuments")
    public ResponseEntity<?> getAsvDocuments(
            @RequestParam String inn,
            @RequestParam String kpp
    ) {
        return ResponseEntity.ok(service.getAsvDocuments(inn, kpp));
    }
}
