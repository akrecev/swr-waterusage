package ru.rosniivh.swr.rest;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.AsvContractService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/asv_contract")
public class AsvContractController {

    private final AsvContractService service;

    @PostMapping("/getRegNumsByUid")
    public ResponseEntity<?> getContractsByIds(@RequestBody List<Integer> ids) {
        return ResponseEntity.ok(service.getContractsByIds(ids));
    }
}
