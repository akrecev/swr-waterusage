package ru.rosniivh.swr.dto.catalog.asv;

import lombok.*;
import ru.rosniivh.swr.domain.auth.UserEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvAcceptorEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;

import java.io.Serializable;

/**
 * DTO for {@link AsvAcceptorEntity}
 */

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class AsvAcceptorDto implements Serializable {
    Integer id;
    String fio;
    String firstname;
    String middlename;
    String lastname;
    AsvImportAuthOrgContractEntity authOrgContract;
    String position;
    String basis;
    String notes;
    UserEntity user;
}