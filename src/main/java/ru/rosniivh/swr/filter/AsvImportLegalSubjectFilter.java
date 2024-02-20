package ru.rosniivh.swr.filter;

import static ru.rosniivh.swr.specification.AsvImportLegalSubjectSpec.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;

@Getter
@Setter
public class AsvImportLegalSubjectFilter {

    private Integer id;
    private Integer type;
    private String inn;
    private String kpp;
    private String fullName;
    private String ogrn;
    private String okpo;
    private String placeAddress;
    private String legalAddress;
    private String okato;
    //    private Boolean distinct;

    public Specification<AsvImportLegalSubjectEntity> toSpecification() {
        return Specification.where(hasId(id))
                .and(hasType(type))
                .and(hasInn(inn))
                .and(hasKpp(kpp))
                .and(hasFullName(fullName))
                .and(hasOgrn(ogrn))
                .and(hasOkpo(okpo))
                .and(hasPlaceAddress(placeAddress))
                .and(hasLegalAddress(legalAddress))
                .and(hasOkato(okato));
    }
}
