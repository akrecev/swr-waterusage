package ru.rosniivh.swr.domain.catalog.asv;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cat_asv_import_auth_org_contract", schema = "dbo")
public class AsvImportAuthOrgContractEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "deleted")
    private Boolean deleted;

        @Column(name = "code", nullable = false)
    private String code;

        @Column(name = "description", nullable = false)
    private String description;

        @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "parent_id")
    private Integer parentId;

        @Column(name = "old_parent_code")
    private String oldParentCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rf_subject")
    private AsvImportRfSubjectEntity rfSubject;

        @Column(name = "old_rf_subject_id")
    private String oldRfSubjectId;

    @Column(name = "org_type")
    private Integer orgType;

        @Column(name = "old_org_type_id")
    private String oldOrgTypeId;

        @Column(name = "prefix")
    private String prefix;

        @Column(name = "legal_address")
    private String legalAddress;

        @Column(name = "post_address")
    private String postAddress;

        @Column(name = "inn")
    private String inn;

        @Column(name = "kpp")
    private String kpp;

        @Column(name = "okato")
    private String okato;

        @Column(name = "okpo")
    private String okpo;

        @Column(name = "ogrn")
    private String ogrn;

        @Column(name = "fin_requisites_name")
    private String finRequisitesName;

        @Column(name = "fin_requisites_acct")
    private String finRequisitesAcct;

    @Column(name = "fin_requisites_bank_ls")
    private Integer finRequisitesBankLs;

        @Column(name = "fin_requisites_old_bank_id")
    private String finRequisitesOldBankId;

        @Column(name = "fin_requisites_bik")
    private String finRequisitesBik;

        @Column(name = "fin_requisites_rs")
    private String finRequisitesRs;

        @Column(name = "org_executor_post")
    private String orgExecutorPost;

        @Column(name = "org_executor_name")
    private String orgExecutorName;

        @Column(name = "org_executor_reason")
    private String orgExecutorReason;

        @Column(name = "org_executor_accountant_name")
    private String orgExecutorAccountantName;

        @Column(name = "phone")
    private String phone;

        @Column(name = "fax")
    private String fax;

        @Column(name = "email")
    private String email;

    @Column(name = "admin_id")
    private Integer adminId;

        @Column(name = "old_admin_id")
    private String oldAdminId;

    @Column(name = "org_document")
    private Integer orgDocument;

    @Column(name = "bwm_id")
    private Integer bwmId;

        @Column(name = "old_bwm_id")
    private String oldBwmId;

        @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "fd_id")
    private Integer fdId;

        @Column(name = "old_fd_id")
    private String oldFdId;

        @Column(name = "urn")
    private String urn;

        @Column(name = "code_gan")
    private String codeGan;

        @Column(name = "old_code")
    private String oldCode;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvImportAuthOrgContractEntity that = (AsvImportAuthOrgContractEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}