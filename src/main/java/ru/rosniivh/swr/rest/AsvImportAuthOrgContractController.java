package ru.rosniivh.swr.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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

    @GetMapping("/paymentHierarchy")
    public ResponseEntity<?> paymentHierarchy(@RequestParam Integer uid) {
        return ResponseEntity.ok(service.paymentHierarchy(uid));
    }

    @PostMapping("/getRfSubjectsByOrg")
    public ResponseEntity<?> getRfSubjectsByOrg(@RequestBody List<Integer> ids) {
        return ResponseEntity.ok(service.getRfSubjectsByOrg(ids));
    }
}
