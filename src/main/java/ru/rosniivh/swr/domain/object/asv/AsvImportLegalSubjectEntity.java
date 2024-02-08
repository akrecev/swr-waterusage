package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportOkopf2012Entity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportOkved22016Entity;

import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "o_asv_import_legal_subject", schema = "dbo")
public class AsvImportLegalSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "deleted")
    private String deleted;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "fullname")
    private String fullName;

    @Column(name = "inn")
    private String inn;

    @Column(name = "kpp")
    private String kpp;

    @Column(name = "ogrn")
    private String ogrn;

    @Column(name = "okpo")
    private String okpo;

    @Column(name = "industry_code")
    private String industryCode;

    @Column(name = "industry_id")
    private Integer industryId;

    @Column(name = "old_industry_code")
    private String oldIndustryCode;

    @Column(name = "territ_value")
    private String territValue;

    @Column(name = "location_id")
    private Integer locationId;

    @Column(name = "old_location_id")
    private String oldLocationId;

    @Column(name = "minist")
    private String minist;

    @Column(name = "okved2001_id")
    private Integer okved2001Id;

    @Column(name = "old_okved2001_id")
    private String oldOkved2001Id;

    @Column(name = "requisites")
    private String requisites;

    @Column(name = "legal_address")
    private String legalAddress;

    @Column(name = "place_address")
    private String placeAddress;

    @Column(name = "phone")
    private String phone;

    @Column(name = "fax")
    private String fax;

    @Column(name = "ls_executor_post")
    private String lsExecutorPost;

    @Column(name = "ls_executor_name")
    private String lsExecutorName;

    @Column(name = "ls_executor_type_doc")
    private String lsExecutorTypeDoc;

    @Column(name = "ls_executor_serie_doc")
    private String lsExecutorSerieDoc;

    @Column(name = "ls_executor_num_doc")
    private String lsExecutorNumDoc;

    @Column(name = "ls_executor_date_doc")
    private String lsExecutorDateDoc;

    @Column(name = "ls_executor_org_doc")
    private String lsExecutorOrgDoc;

    @Column(name = "ls_executor_org_code_doc")
    private String lsExecutorOrgCodeDoc;

    @Column(name = "ls_executor_org_type_doc")
    private String lsExecutorOrgTypeDoc;

    @Column(name = "destroy")
    private String destroy;

    @Column(name = "ls_contact_name")
    private String lsContactName;

    @Column(name = "ls_contact_post")
    private String lsContactPost;

    @Column(name = "gup")
    private String gup;

    @Column(name = "okato")
    private String okato;

    @Column(name = "bank_id")
    private Integer bankId;

    @Column(name = "old_bank_id")
    private String oldBankId;

    @Column(name = "bank_account_id")
    private Integer bankAccountId;

    @Column(name = "ls_type")
    private String lsType;

    @Column(name = "okopf99_id")
    private Integer okopf99Id;

    @Column(name = "old_okopf99_id")
    private String oldOkopf99Id;

    @Column(name = "email")
    private String email;

    @Column(name = "ls_executor_reason")
    private String lsExecutorReason;

    @Column(name = "okved2007_id")
    private Integer okved2007Id;

    @Column(name = "old_okved2007_id")
    private String oldOkved2007Id;

    @Column(name = "guiv")
    private String guiv;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "okopf2012_id")
    private AsvImportOkopf2012Entity okopf2012;

    @Column(name = "old_okopf2012_id")
    private String oldOkopf2012Id;

    @Column(name = "snils")
    private String snils;

    @Column(name = "oktmo")
    private String oktmo;

    @Column(name = "eip")
    private String eip;

    @Column(name = "aeip")
    private String aeip;

    @Column(name = "resident")
    private String resident;

    @Column(name = "kio")
    private String kio;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "okved2016_id")
    private AsvImportOkved22016Entity okved2016;

    @Column(name = "old_okved2016_id")
    private String oldOkved2016Id;

    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "old_bank_account_id")
    private String oldBankAccountId;

    @OneToMany(mappedBy = "waterUser")
    private Set<AsvAdditionalAgreementEntity> asvAdditionalAgreementEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "waterUser")
    private Set<AsvContractEntity> asvContractEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "rightholder")
    private Set<AsvContractTransferEntity> asvContractTransferEntities = new LinkedHashSet<>();

    @OneToMany(mappedBy = "waterUser")
    private Set<AsvDecisionEntity> asvDecisionEntities = new LinkedHashSet<>();

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvImportLegalSubjectEntity that = (AsvImportLegalSubjectEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}