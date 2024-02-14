package ru.rosniivh.swr.domain.catalog.asv;

import lombok.*;
import ru.rosniivh.swr.domain.auth.UserEntity;

import java.io.Serializable;

/**
 * DTO for {@link ru.rosniivh.swr.domain.object.asv.AsvAcceptorEntity}
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