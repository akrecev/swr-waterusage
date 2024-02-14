package ru.rosniivh.swr.domain.catalog.asv;

import jakarta.persistence.*;
import lombok.*;
import ru.rosniivh.swr.domain.auth.UserEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Getter
@Setter
@Builder
@Table(name = "cat_asv_acceptor", schema = "dbo")
public class AsvAcceptorEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "fio", length = Integer.MAX_VALUE)
    private String fio;

    @Column(name = "firstname", length = Integer.MAX_VALUE)
    private String firstname;

    @Column(name = "middlename", length = Integer.MAX_VALUE)
    private String middlename;

    @Column(name = "lastname", length = Integer.MAX_VALUE)
    private String lastname;

    @Column(name = "\"position\"", length = Integer.MAX_VALUE)
    private String position;

    @Column(name = "basis", length = Integer.MAX_VALUE)
    private String basis;

    @Column(name = "notes", length = Integer.MAX_VALUE)
    private String notes;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.PERSIST)
    @JoinColumn(name = "auth_id")
    private AsvImportAuthOrgContractEntity auth;

    @Column(name = "auth_code", length = Integer.MAX_VALUE)
    private String authCode;

    @Column(name = "user_code", length = Integer.MAX_VALUE)
    private String userCode;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private UserEntity user;

}