package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.Instant;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.auth.UserEntity;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvInputKindEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvLegalSubjectTypeEntity;
import ru.rosniivh.swr.domain.object.BasinDistrictEntity;
import ru.rosniivh.swr.domain.object.HeParcelEntity;
import ru.rosniivh.swr.domain.object.SubbasinEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_fact_disposal", schema = "dbo")
public class AsvFactDisposalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "doc_num", length = Integer.MAX_VALUE)
    private String docNum;

    @Column(name = "doc_date")
    private LocalDate docDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "input_kind_id")
    private AsvInputKindEntity inputKind;

    @Column(name = "year")
    private Integer year;

    @Column(name = "quarter")
    private Integer quarter;

    @Column(name = "period_text", length = Integer.MAX_VALUE)
    private String periodText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ls_type_id")
    private AsvLegalSubjectTypeEntity lsType;

    @Column(name = "ls_type_text", length = Integer.MAX_VALUE)
    private String lsTypeText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ls_id")
    private AsvImportLegalSubjectEntity ls;

    @Column(name = "ls_name", length = Integer.MAX_VALUE)
    private String lsName;

    @Column(name = "ls_address", length = Integer.MAX_VALUE)
    private String lsAddress;

    @Column(name = "ls_okopf", length = Integer.MAX_VALUE)
    private String lsOkopf;

    @Column(name = "ls_inn", length = Integer.MAX_VALUE)
    private String lsInn;

    @Column(name = "ls_kpp", length = Integer.MAX_VALUE)
    private String lsKpp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "basin_district_id")
    private BasinDistrictEntity basinDistrict;

    @Column(name = "basin_district_text", length = Integer.MAX_VALUE)
    private String basinDistrictText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rf_subject_id")
    private RfSubjectEntity rfSubject;

    @Column(name = "rf_subject_text", length = Integer.MAX_VALUE)
    private String rfSubjectText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "subbasin_id")
    private SubbasinEntity subbasin;

    @Column(name = "subbasin_text", length = Integer.MAX_VALUE)
    private String subbasinText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "he_parcel_id")
    private HeParcelEntity heParcel;

    @Column(name = "he_parcel_text", length = Integer.MAX_VALUE)
    private String heParcelText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private AsvContractEntity contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_id")
    private AsvDecisionEntity decision;

    @Column(name = "contract_old_code", length = Integer.MAX_VALUE)
    private String contractOldCode;

    @Column(name = "contract_text", length = Integer.MAX_VALUE)
    private String contractText;

    @Column(name = "device_name", length = Integer.MAX_VALUE)
    private String deviceName;

    @Column(name = "device_last_check", length = Integer.MAX_VALUE)
    private String deviceLastCheck;

    @Column(name = "device_periodic", length = Integer.MAX_VALUE)
    private String devicePeriodic;

    @Column(name = "excess")
    private Integer excess;

    @Column(name = "executor", length = Integer.MAX_VALUE)
    private String executor;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_id")
    private AsvImportAuthOrgContractEntity auth;

    @Column(name = "mark_del")
    private Integer markDel;

    @Column(name = "posted")
    private Integer posted;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Column(name = "inserted_on")
    private Instant insertedOn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "inserted_by")
    private UserEntity insertedBy;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

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
        AsvFactDisposalEntity that = (AsvFactDisposalEntity) o;
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
