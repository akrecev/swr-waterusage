package ru.rosniivh.swr.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.RfSubjectService;

@RestController
@RequestMapping("/rf_subject")
@RequiredArgsConstructor
public class RfSubjectController {

    private final RfSubjectService service;

    @GetMapping("/getBasinFilterForUser")
    public ResponseEntity<?> testBasinForUser() {
        return ResponseEntity.ok(service.getBasinFilterForUser());
    }
}
