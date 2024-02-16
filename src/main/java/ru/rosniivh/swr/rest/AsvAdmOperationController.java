package ru.rosniivh.swr.rest;

import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rosniivh.swr.service.AsvAdmOperationService;

import java.util.ArrayList;
import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping("/asv_adm_operation")
public class AsvAdmOperationController {

    private final AsvAdmOperationService service;

    @PostMapping("/getOpersByUid")
    public ResponseEntity<?> getOpersByUid(@RequestBody List<Integer> ids) {
        return ResponseEntity.ok(service.getOpersByIds(ids));
    }
}
