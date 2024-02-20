package ru.rosniivh.swr.rest;

import java.util.ArrayList;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rosniivh.swr.service.AsvAdmOperationService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/asv_adm_operation")
public class AsvAdmOperationController {

    private final AsvAdmOperationService service;

    //Не пашет
    @PostMapping("/getOpersByUid")
    public ResponseEntity<?> getOpersByUid() {
        List<Integer> test = new ArrayList<>();
        test.add(853361);
        test.add(853363);
        test.add(853367);
        return ResponseEntity.ok(service.getOpersByIds(test));
    }

    @GetMapping("/")
    public ResponseEntity<?> getById(@RequestParam Integer id) {
        return ResponseEntity.ok(service.getById(id));
    }
}
