package ru.rosniivh.swr.rest;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.service.UserService;

@Slf4j
@RestController
@RequestMapping("/water-usage")
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user-rfsubjects")
    public ResponseEntity<?> getUserRfSubjects() {
        return ResponseEntity.ok(userService.getUserRfs());
    }
}
