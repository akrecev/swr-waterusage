package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_import_legal_subject", schema = "dbo")
public class AsvImportLegalSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @MapsId
    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "uid", nullable = false)
    private AsvImportLegalSubjectEntity oAsvImportLegalSubject;

    @Column(name = "deleted")
    private String deleted;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "fullname", length = Integer.MAX_VALUE)
    private String fullName;

    @Column(name = "inn", length = Integer.MAX_VALUE)
    private String inn;

    @Column(name = "kpp", length = Integer.MAX_VALUE)
    private String kpp;

    @Column(name = "ogrn", length = Integer.MAX_VALUE)
    private String ogrn;

    @Column(name = "okpo", length = Integer.MAX_VALUE)
    private String okpo;

    @Column(name = "industry_code", length = Integer.MAX_VALUE)
    private String industryCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "industry_id")
    private AsvImportIndustryEntity industry;

    @Column(name = "old_industry_code", length = Integer.MAX_VALUE)
    private String oldIndustryCode;

    @Column(name = "territ_value", length = Integer.MAX_VALUE)
    private String territValue;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "location_id")
    private AsvImportTerritoryEntity location;

    @Column(name = "old_location_id", length = Integer.MAX_VALUE)
    private String oldLocationId;

    @Column(name = "minist", length = Integer.MAX_VALUE)
    private String minist;

    @Column(name = "okved2001_id")
    private Integer okved2001Id;

    @Column(name = "old_okved2001_id", length = Integer.MAX_VALUE)
    private String oldOkved2001Id;

    @Column(name = "requisites", length = Integer.MAX_VALUE)
    private String requisites;

    @Column(name = "legal_address", length = Integer.MAX_VALUE)
    private String legalAddress;

    @Column(name = "place_address", length = Integer.MAX_VALUE)
    private String placeAddress;

    @Column(name = "phone", length = Integer.MAX_VALUE)
    private String phone;

    @Column(name = "fax", length = Integer.MAX_VALUE)
    private String fax;

    @Column(name = "ls_executor_post", length = Integer.MAX_VALUE)
    private String lsExecutorPost;

    @Column(name = "ls_executor_name", length = Integer.MAX_VALUE)
    private String lsExecutorName;

    @Column(name = "ls_executor_type_doc", length = Integer.MAX_VALUE)
    private String lsExecutorTypeDoc;

    @Column(name = "ls_executor_serie_doc", length = Integer.MAX_VALUE)
    private String lsExecutorSerieDoc;

    @Column(name = "ls_executor_num_doc", length = Integer.MAX_VALUE)
    private String lsExecutorNumDoc;

    @Column(name = "ls_executor_date_doc")
    private String lsExecutorDateDoc;

    @Column(name = "ls_executor_org_doc", length = Integer.MAX_VALUE)
    private String lsExecutorOrgDoc;

    @Column(name = "ls_executor_org_code_doc", length = Integer.MAX_VALUE)
    private String lsExecutorOrgCodeDoc;

    @Column(name = "ls_executor_org_type_doc", length = Integer.MAX_VALUE)
    private String lsExecutorOrgTypeDoc;

    @Column(name = "destroy")
    private String destroy;

    @Column(name = "ls_contact_name", length = Integer.MAX_VALUE)
    private String lsContactName;

    @Column(name = "ls_contact_post", length = Integer.MAX_VALUE)
    private String lsContactPost;

    @Column(name = "gup", length = Integer.MAX_VALUE)
    private String gup;

    @Column(name = "okato", length = Integer.MAX_VALUE)
    private String okato;

    @Column(name = "bank_id")
    private Integer bankId;

    @Column(name = "old_bank_id", length = Integer.MAX_VALUE)
    private String oldBankId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bank_account_id")
    private AsvImportBankAccountEntity bankAccount;

    @Column(name = "ls_type", length = Integer.MAX_VALUE)
    private String lsType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "okopf99_id")
    private AsvImportOkopf99Entity okopf99;

    @Column(name = "old_okopf99_id", length = Integer.MAX_VALUE)
    private String oldOkopf99Id;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "ls_executor_reason", length = Integer.MAX_VALUE)
    private String lsExecutorReason;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "okved2007_id")
    private AsvImportOkved1Entity okved2007;

    @Column(name = "old_okved2007_id", length = Integer.MAX_VALUE)
    private String oldOkved2007Id;

    @Column(name = "guiv", length = Integer.MAX_VALUE)
    private String guiv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "okopf2012_id")
    private AsvImportOkopf2012Entity okopf2012;

    @Column(name = "old_okopf2012_id", length = Integer.MAX_VALUE)
    private String oldOkopf2012Id;

    @Column(name = "snils", length = Integer.MAX_VALUE)
    private String snils;

    @Column(name = "oktmo", length = Integer.MAX_VALUE)
    private String oktmo;

    @Column(name = "eip", length = Integer.MAX_VALUE)
    private String eip;

    @Column(name = "aeip", length = Integer.MAX_VALUE)
    private String aeip;

    @Column(name = "resident")
    private String resident;

    @Column(name = "kio", length = Integer.MAX_VALUE)
    private String kio;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "okved2016_id")
    private AsvImportOkved22016Entity okved2016;

    @Column(name = "old_okved2016_id", length = Integer.MAX_VALUE)
    private String oldOkved2016Id;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Column(name = "old_bank_account_id", length = Integer.MAX_VALUE)
    private String oldBankAccountId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subject_type")
    private AsvLegalSubjectTypeEntity subjectType;

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
        AsvImportLegalSubjectEntity that = (AsvImportLegalSubjectEntity) o;
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
