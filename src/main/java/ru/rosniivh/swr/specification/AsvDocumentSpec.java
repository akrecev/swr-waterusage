package ru.rosniivh.swr.specification;

import lombok.experimental.UtilityClass;
import org.springframework.data.jpa.domain.Specification;
import ru.rosniivh.swr.domain.object.asv.AsvDocumentEntity;

@UtilityClass
public class AsvDocumentSpec {

    public static Specification<AsvDocumentEntity> hasYearAndQuarter(Integer year, Integer quarter) {
        return null;
    }
}
