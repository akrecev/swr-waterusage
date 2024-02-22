package ru.rosniivh.swr.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.AsvImportAuthOrgContractService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/asv_import_auth_org_contract")
public class AsvImportAuthOrgContractController {

    private final AsvImportAuthOrgContractService service;

    @GetMapping("/getRfSubjectsWithOrgsByBvu")
    public ResponseEntity<?> getRfSubjectsWithOrgsByBvu(@RequestParam(value = "bvuId") Integer bvuId) {
        return ResponseEntity.ok(service.getRfSubjectsWithOrgsByBvu(bvuId));
    }
}
