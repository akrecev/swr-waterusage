package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.CategoryQualityWaterEntity;
import ru.rosniivh.swr.domain.catalog.WaterObjectUseTypeEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvWuAimPaymentEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_fact_withdrawal_detail", schema = "dbo")
public class AsvFactWithdrawalDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "withdrawal_id")
    private AsvFactWithdrawalEntity withdrawal;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "water_object_id")
    private Integer waterObjectId;

    @Column(name = "water_object_name")
    private String waterObjectName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wo_type_id")
    private WaterObjectUseTypeEntity woType;

    @Column(name = "wo_type_code")
    private String woTypeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryQualityWaterEntity category;

    @Column(name = "category_code")
    private String categoryCode;

    @Column(name = "intake_num")
    private String intakeNum;

    @Column(name = "la_deg")
    private Integer laDeg;

    @Column(name = "la_min")
    private Integer laMin;

    @Column(name = "la_sec")
    private Double laSec;

    @Column(name = "lo_deg")
    private Integer loDeg;

    @Column(name = "lo_min")
    private Integer loMin;

    @Column(name = "lo_sec")
    private Double loSec;

    @Column(name = "la_deg_text")
    private String laDegText;

    @Column(name = "la_min_text")
    private String laMinText;

    @Column(name = "la_sec_text")
    private String laSecText;

    @Column(name = "lo_deg_text")
    private String loDegText;

    @Column(name = "lo_min_text")
    private String loMinText;

    @Column(name = "lo_sec_text")
    private String loSecText;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "usage_aim_id")
    private AsvWuAimPaymentEntity usageAim;

    @Column(name = "usage_aim_text")
    private String usageAimText;

    @Column(name = "volume_req")
    private Double volumeReq;

    @Column(name = "volume_fact")
    private Double volumeFact;

    @Column(name = "volume_fact_m1")
    private Double volumeFactM1;

    @Column(name = "volume_fact_m2")
    private Double volumeFactM2;

    @Column(name = "volume_fact_m3")
    private Double volumeFactM3;

    @Column(name = "volume_req_text")
    private String volumeReqText;

    @Column(name = "volume_fact_text")
    private String volumeFactText;

    @Column(name = "volume_fact_m1_text")
    private String volumeFactM1Text;

    @Column(name = "volume_fact_m2_text")
    private String volumeFactM2Text;

    @Column(name = "volume_fact_m3_text")
    private String volumeFactM3Text;

    @Column(name = "excess")
    private Integer excess;

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
        AsvFactWithdrawalDetailEntity that = (AsvFactWithdrawalDetailEntity) o;
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
