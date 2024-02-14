package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_import_bank_account", schema = "dbo")
public class AsvImportBankAccountEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "deleted")
    private Integer deleted;

    @Column(name = "old_owner_id", length = Integer.MAX_VALUE)
    private String oldOwnerId;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "old_bank_id", length = Integer.MAX_VALUE)
    private String oldBankId;

    @Column(name = "account_number", length = Integer.MAX_VALUE)
    private String accountNumber;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

}