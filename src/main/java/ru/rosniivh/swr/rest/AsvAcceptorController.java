package ru.rosniivh.swr.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.rosniivh.swr.filter.AsvAcceptorFilter;
import ru.rosniivh.swr.service.AsvAcceptorService;

@RestController
@RequestMapping("/acceptor")
public class AsvAcceptorController {
    @Autowired
    private AsvAcceptorService service;

    @GetMapping("/search")
    public ResponseEntity<?> legalSubjectCheck(
            @RequestParam(value = "top", required = false) Integer top, // number of results
            @RequestParam(value = "name", required = false) String value) { //  value search by multiple fields

        AsvAcceptorFilter filter = new AsvAcceptorFilter();
        Integer limit = 100; // 100 first elements
        if (top != null) {
            limit = top;
        }
        filter.setSearchFieldValue(value);
        return ResponseEntity.ok().body(service.getByFilter(filter, limit));
    }

    @GetMapping("/test")
    public ResponseEntity<?> getAll() {
        return ResponseEntity.ok(service.getById());
    }
}
