package ru.rosniivh.swr.domain.object.asv;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "o_asv_import_legal_subject", schema = "dbo")
public class AsvImportLegalSubjectEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "deleted")
    private String deleted;

    @Lob
    @Column(name = "code")
    private String code;

    @Lob
    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "fullname")
    private String fullName;

    @Lob
    @Column(name = "inn")
    private String inn;

    @Lob
    @Column(name = "kpp")
    private String kpp;

    @Lob
    @Column(name = "ogrn")
    private String ogrn;

    @Lob
    @Column(name = "okpo")
    private String okpo;

    @Lob
    @Column(name = "industry_code")
    private String industryCode;

    @Column(name = "industry_id")
    private Integer industryId;

    @Lob
    @Column(name = "old_industry_code")
    private String oldIndustryCode;

    @Lob
    @Column(name = "territ_value")
    private String territValue;

    @Column(name = "location_id")
    private Integer locationId;

    @Lob
    @Column(name = "old_location_id")
    private String oldLocationId;

    @Lob
    @Column(name = "minist")
    private String minist;

    @Column(name = "okved2001_id")
    private Integer okved2001Id;

    @Lob
    @Column(name = "old_okved2001_id")
    private String oldOkved2001Id;

    @Lob
    @Column(name = "requisites")
    private String requisites;

    @Lob
    @Column(name = "legal_address")
    private String legalAddress;

    @Lob
    @Column(name = "place_address")
    private String placeAddress;

    @Lob
    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "fax")
    private String fax;

    @Lob
    @Column(name = "ls_executor_post")
    private String lsExecutorPost;

    @Lob
    @Column(name = "ls_executor_name")
    private String lsExecutorName;

    @Lob
    @Column(name = "ls_executor_type_doc")
    private String lsExecutorTypeDoc;

    @Lob
    @Column(name = "ls_executor_serie_doc")
    private String lsExecutorSerieDoc;

    @Lob
    @Column(name = "ls_executor_num_doc")
    private String lsExecutorNumDoc;

    @Lob
    @Column(name = "ls_executor_date_doc")
    private String lsExecutorDateDoc;

    @Lob
    @Column(name = "ls_executor_org_doc")
    private String lsExecutorOrgDoc;

    @Lob
    @Column(name = "ls_executor_org_code_doc")
    private String lsExecutorOrgCodeDoc;

    @Lob
    @Column(name = "ls_executor_org_type_doc")
    private String lsExecutorOrgTypeDoc;

    @Lob
    @Column(name = "destroy")
    private String destroy;

    @Lob
    @Column(name = "ls_contact_name")
    private String lsContactName;

    @Lob
    @Column(name = "ls_contact_post")
    private String lsContactPost;

    @Lob
    @Column(name = "gup")
    private String gup;

    @Lob
    @Column(name = "okato")
    private String okato;

    @Column(name = "bank_id")
    private Integer bankId;

    @Lob
    @Column(name = "old_bank_id")
    private String oldBankId;

    @Column(name = "bank_account_id")
    private Integer bankAccountId;

    @Lob
    @Column(name = "ls_type")
    private String lsType;

    @Column(name = "okopf99_id")
    private Integer okopf99Id;

    @Lob
    @Column(name = "old_okopf99_id")
    private String oldOkopf99Id;

    @Lob
    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "ls_executor_reason")
    private String lsExecutorReason;

    @Column(name = "okved2007_id")
    private Integer okved2007Id;

    @Lob
    @Column(name = "old_okved2007_id")
    private String oldOkved2007Id;

    @Lob
    @Column(name = "guiv")
    private String guiv;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "okopf2012_id")
    private AsvImportOkopf2012Entity okopf2012;

    @Lob
    @Column(name = "old_okopf2012_id")
    private String oldOkopf2012Id;

    @Lob
    @Column(name = "snils")
    private String snils;

    @Lob
    @Column(name = "oktmo")
    private String oktmo;

    @Lob
    @Column(name = "eip")
    private String eip;

    @Lob
    @Column(name = "aeip")
    private String aeip;

    @Lob
    @Column(name = "resident")
    private String resident;

    @Lob
    @Column(name = "kio")
    private String kio;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "okved2016_id")
    private AsvImportOkved22016Entity okved2016;

    @Lob
    @Column(name = "old_okved2016_id")
    private String oldOkved2016Id;

    @Lob
    @Column(name = "old_code")
    private String oldCode;

    @Lob
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