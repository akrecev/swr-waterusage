package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import java.time.Instant;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import ru.rosniivh.swr.domain.auth.UserEntity;
import ru.rosniivh.swr.domain.catalog.LegalSubjectTypeEntity;

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

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "inn", nullable = false)
    private String inn;

    @Column(name = "kpp")
    private String kpp;

    @Column(name = "okpo")
    private String okpo;

    @Column(name = "okopf")
    private String okopf;

    @Column(name = "okfs")
    private String okfs;

    @Column(name = "okved")
    private String okved;

    @Column(name = "okonh")
    private String okonh;

    @Column(name = "ogrn")
    private String ogrn;

    @Column(name = "okato")
    private String okato;

    @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "post_address")
    private String postAddress;

    @Column(name = "legal_address")
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
