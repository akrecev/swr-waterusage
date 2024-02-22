package ru.rosniivh.swr.rest;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.rosniivh.swr.filter.AsvImportLegalSubjectFilter;
import ru.rosniivh.swr.service.AsvImportLegalSubjectService;

@RequiredArgsConstructor
@RestController
@RequestMapping("/asv_import_legal_subject")
public class AsvImportLegalSubjectController {

    private final AsvImportLegalSubjectService service;

    @GetMapping("/legalSubjectCheck")
    public ResponseEntity<?> legalSubjectCheck(
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "inn") String inn,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "ogrn", required = false) String ogrn,
            @RequestParam(value = "okpo", required = false) String okpo,
            @RequestParam(value = "okopf", required = false) String okopf,
            @RequestParam(value = "okfs", required = false) String okfs,
            @RequestParam(value = "okved", required = false) String okved,
            @RequestParam(value = "okonh", required = false) String okonh,
            @RequestParam(value = "postAddress", required = false) String postAddress,
            @RequestParam(value = "legalAddress", required = false) String legalAddress,
            @RequestParam(value = "okato", required = false) String okato) {
        AsvImportLegalSubjectFilter filter = new AsvImportLegalSubjectFilter();
        if (type.equals(1)) {
            filter.setInn(inn)
                    .setFullName(name)
                    .setOgrn(ogrn)
                    .setOkpo(okpo)
                    .setPlaceAddress(postAddress)
                    .setLegalAddress(legalAddress)
                    .setOkato(okato);
        } else {
            filter.setInn(inn).setFullName(name);
        }
        return ResponseEntity.ok().body(service.getByFilter(filter));
    }

    @GetMapping("/legalSubjectCheckJPQL")
    public ResponseEntity<?> legalSubjectCheckJPQL(
            @RequestParam(value = "type") Integer type,
            @RequestParam(value = "inn") String inn,
            @RequestParam(value = "name") String name,
            @RequestParam(value = "ogrn", required = false) String ogrn,
            @RequestParam(value = "okpo", required = false) String okpo,
            @RequestParam(value = "okopf", required = false) String okopf,
            @RequestParam(value = "okfs", required = false) String okfs,
            @RequestParam(value = "okved", required = false) String okved,
            @RequestParam(value = "okonh", required = false) String okonh,
            @RequestParam(value = "postAddress", required = false) String postAddress,
            @RequestParam(value = "legalAddress", required = false) String legalAddress,
            @RequestParam(value = "okato", required = false) String okato) {

        return ResponseEntity.ok()
                .body(service.getByType(type, name, ogrn, okpo, postAddress, legalAddress, okato, inn));
    }
}
