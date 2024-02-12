package ru.rosniivh.swr.domain.catalog;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvAuthOrgTypeEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportRfSubjectEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cat_asv_import_auth_org_contract", schema = "dbo")
public class AsvImportAuthOrgContractEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uid", nullable = false)
    private AsvImportAuthOrgContractEntity asvImportAuthOrgContractEntity;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "code", nullable = false, length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "description", nullable = false, length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "fullname", nullable = false, length = Integer.MAX_VALUE)
    private String fullname;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "old_parent_code", length = Integer.MAX_VALUE)
    private String oldParentCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_subject")
    private AsvImportRfSubjectEntity rfSubject;

    @Column(name = "old_rf_subject_id", length = Integer.MAX_VALUE)
    private String oldRfSubjectId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "org_type")
    private AsvAuthOrgTypeEntity orgType;

    @Column(name = "old_org_type_id", length = Integer.MAX_VALUE)
    private String oldOrgTypeId;

    @Column(name = "prefix", length = Integer.MAX_VALUE)
    private String prefix;

    @Column(name = "legal_address", length = Integer.MAX_VALUE)
    private String legalAddress;

    @Column(name = "post_address", length = Integer.MAX_VALUE)
    private String postAddress;

    @Column(name = "inn", length = Integer.MAX_VALUE)
    private String inn;

    @Column(name = "kpp", length = Integer.MAX_VALUE)
    private String kpp;

    @Column(name = "okato", length = Integer.MAX_VALUE)
    private String okato;

    @Column(name = "okpo", length = Integer.MAX_VALUE)
    private String okpo;

    @Column(name = "ogrn", length = Integer.MAX_VALUE)
    private String ogrn;

    @Column(name = "fin_requisites_name", length = Integer.MAX_VALUE)
    private String finRequisitesName;

    @Column(name = "fin_requisites_acct", length = Integer.MAX_VALUE)
    private String finRequisitesAcct;

    @Column(name = "fin_requisites_bank_ls")
    private Integer finRequisitesBankLs;

    @Column(name = "fin_requisites_old_bank_id", length = Integer.MAX_VALUE)
    private String finRequisitesOldBankId;

    @Column(name = "fin_requisites_bik", length = Integer.MAX_VALUE)
    private String finRequisitesBik;

    @Column(name = "fin_requisites_rs", length = Integer.MAX_VALUE)
    private String finRequisitesRs;

    @Column(name = "org_executor_post", length = Integer.MAX_VALUE)
    private String orgExecutorPost;

    @Column(name = "org_executor_name", length = Integer.MAX_VALUE)
    private String orgExecutorName;

    @Column(name = "org_executor_reason", length = Integer.MAX_VALUE)
    private String orgExecutorReason;

    @Column(name = "org_executor_accountant_name", length = Integer.MAX_VALUE)
    private String orgExecutorAccountantName;

    @Column(name = "phone", length = Integer.MAX_VALUE)
    private String phone;

    @Column(name = "fax", length = Integer.MAX_VALUE)
    private String fax;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "admin_id")
    private Integer adminId;

    @Column(name = "old_admin_id", length = Integer.MAX_VALUE)
    private String oldAdminId;

    @Column(name = "org_document")
    private Integer orgDocument;

    @Column(name = "bwm_id")
    private Integer bwmId;

    @Column(name = "old_bwm_id", length = Integer.MAX_VALUE)
    private String oldBwmId;

    @Column(name = "oktmo", length = Integer.MAX_VALUE)
    private String oktmo;

    @Column(name = "fd_id")
    private Integer fdId;

    @Column(name = "old_fd_id", length = Integer.MAX_VALUE)
    private String oldFdId;

    @Column(name = "urn", length = Integer.MAX_VALUE)
    private String urn;

    @Column(name = "code_gan", length = Integer.MAX_VALUE)
    private String codeGan;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_subject_new")
    private RfSubjectEntity rfSubjectNew;

    @Column(name = "sort_cipher", length = Integer.MAX_VALUE)
    private String sortCipher;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy
                ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass()
                : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy
                ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass()
                : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvImportAuthOrgContractEntity that = (AsvImportAuthOrgContractEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy
                ? ((HibernateProxy) this)
                        .getHibernateLazyInitializer()
                        .getPersistentClass()
                        .hashCode()
                : getClass().hashCode();
    }
}
