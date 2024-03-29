package ru.rosniivh.swr.specification;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.rosniivh.swr.domain.object.asv.AsvImportLegalSubjectEntity;

@UtilityClass
public class AsvImportLegalSubjectSpec {

    public static Specification<AsvImportLegalSubjectEntity> hasId(Integer id) {
        return id == null ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("id"), id);
    }

    public static Specification<AsvImportLegalSubjectEntity> hasType(Integer type) {
        return type == null ? null : (root, query, criteriaBuilder) -> criteriaBuilder.equal(root.get("type"), type);
    }

    public static Specification<AsvImportLegalSubjectEntity> hasInn(String inn) {
        return inn == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("inn"), "%" + inn + "%");
    }

    public static Specification<AsvImportLegalSubjectEntity> hasKpp(String kpp) {
        return kpp == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("kpp"), "%" + kpp + "%");
    }

    public static Specification<AsvImportLegalSubjectEntity> hasFullName(String fullName) {
        return fullName == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("fullName"), "%" + fullName + "%");
    }

    public static Specification<AsvImportLegalSubjectEntity> hasOgrn(String ogrn) {
        return ogrn == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("ogrn"), "%" + ogrn + "%");
    }

    public static Specification<AsvImportLegalSubjectEntity> hasOkpo(String okpo) {
        return okpo == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("okpo"), "%" + okpo + "%");
    }

    public static Specification<AsvImportLegalSubjectEntity> hasPlaceAddress(String placeAddress) {
        return placeAddress == null
                ? null
                : (root, query, criteriaBuilder) ->
                        criteriaBuilder.like(root.get("placeAddress"), "%" + placeAddress + "%");
    }

    public static Specification<AsvImportLegalSubjectEntity> hasLegalAddress(String legalAddress) {
        return legalAddress == null
                ? null
                : (root, query, criteriaBuilder) ->
                        criteriaBuilder.like(root.get("legalAddress"), "%" + legalAddress + "%");
    }

    public static Specification<AsvImportLegalSubjectEntity> hasOkato(String okato) {
        return okato == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(root.get("okato"), "%" + okato + "%");
    }

    //    public static Specification<AsvImportLegalSubjectEntity> distinct(Boolean distinct) {
    //        return !distinct
    //                ? null
    //                : (root, query, criteriaBuilder) -> {
    //            query.distinct(true);
    //            return null;
    //        };
    //    }
}
