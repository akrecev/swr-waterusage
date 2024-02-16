package ru.rosniivh.swr.specification;

import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorEntity;


@UtilityClass
public class AsvAcceptorSpec {


    public static Specification<AsvAcceptorEntity> findOccurrencesInFio(String searchFieldValue) {
        return searchFieldValue == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("fio")), "%" + searchFieldValue.toUpperCase() + "%");
    }
    public static Specification<AsvAcceptorEntity> findOccurrencesInPosition(String searchFieldValue) {
        return searchFieldValue == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("position")), "%" + searchFieldValue.toUpperCase() + "%");
    }
    public static Specification<AsvAcceptorEntity> findOccurrencesInBasis(String searchFieldValue) {
        return searchFieldValue == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper(root.get("basis")), "%" + searchFieldValue.toUpperCase() + "%");
    }

    public static Specification<AsvAcceptorEntity> findOccurrencesInNotes(String searchFieldValue) {
        return searchFieldValue == null
                ? null
                : (root, query, criteriaBuilder) -> criteriaBuilder.like(criteriaBuilder.upper( root.get("notes")), "%" + searchFieldValue.toUpperCase() + "%");
    }

    public static Specification<AsvAcceptorEntity> findOccurrencesInDescription(String searchFieldValue) {

        return searchFieldValue == null
                ? null
                : (root, query, criteriaBuilder) -> {
            Join<AsvAcceptorEntity,AsvImportAuthOrgContractEntity> res = root.join("auth",JoinType.LEFT);
            return criteriaBuilder.like(criteriaBuilder.upper(res.get("description")), "%" + searchFieldValue.toUpperCase() + "%");
        };
      }
}
