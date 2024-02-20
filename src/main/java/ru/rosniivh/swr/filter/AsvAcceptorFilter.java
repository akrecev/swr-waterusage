package ru.rosniivh.swr.filter;

import static ru.rosniivh.swr.specification.AsvAcceptorSpec.*;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.jpa.domain.Specification;
import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorEntity;

@Getter
@Setter
public class AsvAcceptorFilter {
    private String searchFieldValue; // NOT A USERNAME part, JUST A PLACEHOLDER for multiple search  fields!
    // private Integer limit;
    public Specification<AsvAcceptorEntity> toSpecification() {
        // System.out.println(searchFieldValue);
        return Specification.where(findOccurrencesInFio(searchFieldValue))
                .or(findOccurrencesInBasis(searchFieldValue))
                .or(findOccurrencesInPosition(searchFieldValue))
                .or(findOccurrencesInNotes(searchFieldValue))
                .or(findOccurrencesInDescription(searchFieldValue));
    }
}
