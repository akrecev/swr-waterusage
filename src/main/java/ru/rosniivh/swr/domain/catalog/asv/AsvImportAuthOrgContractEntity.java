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

    @Lob
    @Column(name = "code", nullable = false)
    private String code;

    @Lob
    @Column(name = "description", nullable = false)
    private String description;

    @Lob
    @Column(name = "fullname", nullable = false)
    private String fullname;

    @Column(name = "parent_id")
    private Integer parentId;

    @Lob
    @Column(name = "old_parent_code")
    private String oldParentCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "rf_subject")
    private AsvImportRfSubjectEntity rfSubject;

    @Lob
    @Column(name = "old_rf_subject_id")
    private String oldRfSubjectId;

    @Column(name = "org_type")
    private Integer orgType;

    @Lob
    @Column(name = "old_org_type_id")
    private String oldOrgTypeId;

    @Lob
    @Column(name = "prefix")
    private String prefix;

    @Lob
    @Column(name = "legal_address")
    private String legalAddress;

    @Lob
    @Column(name = "post_address")
    private String postAddress;

    @Lob
    @Column(name = "inn")
    private String inn;

    @Lob
    @Column(name = "kpp")
    private String kpp;

    @Lob
    @Column(name = "okato")
    private String okato;

    @Lob
    @Column(name = "okpo")
    private String okpo;

    @Lob
    @Column(name = "ogrn")
    private String ogrn;

    @Lob
    @Column(name = "fin_requisites_name")
    private String finRequisitesName;

    @Lob
    @Column(name = "fin_requisites_acct")
    private String finRequisitesAcct;

    @Column(name = "fin_requisites_bank_ls")
    private Integer finRequisitesBankLs;

    @Lob
    @Column(name = "fin_requisites_old_bank_id")
    private String finRequisitesOldBankId;

    @Lob
    @Column(name = "fin_requisites_bik")
    private String finRequisitesBik;

    @Lob
    @Column(name = "fin_requisites_rs")
    private String finRequisitesRs;

    @Lob
    @Column(name = "org_executor_post")
    private String orgExecutorPost;

    @Lob
    @Column(name = "org_executor_name")
    private String orgExecutorName;

    @Lob
    @Column(name = "org_executor_reason")
    private String orgExecutorReason;

    @Lob
    @Column(name = "org_executor_accountant_name")
    private String orgExecutorAccountantName;

    @Lob
    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "fax")
    private String fax;

    @Lob
    @Column(name = "email")
    private String email;

    @Column(name = "admin_id")
    private Integer adminId;

    @Lob
    @Column(name = "old_admin_id")
    private String oldAdminId;

    @Column(name = "org_document")
    private Integer orgDocument;

    @Column(name = "bwm_id")
    private Integer bwmId;

    @Lob
    @Column(name = "old_bwm_id")
    private String oldBwmId;

    @Lob
    @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "fd_id")
    private Integer fdId;

    @Lob
    @Column(name = "old_fd_id")
    private String oldFdId;

    @Lob
    @Column(name = "urn")
    private String urn;

    @Lob
    @Column(name = "code_gan")
    private String codeGan;

    @Lob
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