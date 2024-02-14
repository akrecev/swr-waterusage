package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rosniivh.swr.domain.auth.UserEntity;
import ru.rosniivh.swr.domain.catalog.LegalSubjectTypeEntity;

import java.time.Instant;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_legal_subject", schema = "dbo")
public class LegalSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subject_type", nullable = false)
    private LegalSubjectTypeEntity subjectType;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "inn", nullable = false, length = Integer.MAX_VALUE)
    private String inn;

    @Column(name = "kpp", length = Integer.MAX_VALUE)
    private String kpp;

    @Column(name = "okpo", length = Integer.MAX_VALUE)
    private String okpo;

    @Column(name = "okopf", length = Integer.MAX_VALUE)
    private String okopf;

    @Column(name = "okfs", length = Integer.MAX_VALUE)
    private String okfs;

    @Column(name = "okved", length = Integer.MAX_VALUE)
    private String okved;

    @Column(name = "okonh", length = Integer.MAX_VALUE)
    private String okonh;

    @Column(name = "ogrn", length = Integer.MAX_VALUE)
    private String ogrn;

    @Column(name = "okato", length = Integer.MAX_VALUE)
    private String okato;

    @Column(name = "oktmo", length = Integer.MAX_VALUE)
    private String oktmo;

    @Column(name = "post_address", length = Integer.MAX_VALUE)
    private String postAddress;

    @Column(name = "legal_address", length = Integer.MAX_VALUE)
    private String legalAddress;

    @Column(name = "inserted_on", nullable = false)
    private Instant insertedOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inserted_by", nullable = false)
    private UserEntity insertedBy;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

}