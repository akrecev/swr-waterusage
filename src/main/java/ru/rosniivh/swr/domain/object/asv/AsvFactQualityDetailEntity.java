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
import ru.rosniivh.swr.domain.catalog.asv.AsvPollutantEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_fact_quality_detail", schema = "dbo")
public class AsvFactQualityDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quality_id")
    private AsvFactQualityEntity quality;

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

    @Column(name = "disposal_num")
    private String disposalNum;

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
    @JoinColumn(name = "pollutant_id")
    private AsvPollutantEntity pollutant;

    @Column(name = "pollutant_code")
    private String pollutantCode;

    @Column(name = "pollutant_name")
    private String pollutantName;

    @Column(name = "fact_mg_dm")
    private Double factMgDm;

    @Column(name = "fact_g_m")
    private Double factGM;

    @Column(name = "fact_kg")
    private Double factKg;

    @Column(name = "fact_t")
    private Double factT;

    @Column(name = "norm_mg_dm")
    private Double normMgDm;

    @Column(name = "norm_g_m")
    private Double normGM;

    @Column(name = "norm_kg")
    private Double normKg;

    @Column(name = "norm_t")
    private Double normT;

    @Column(name = "lim_mg_dm")
    private Double limMgDm;

    @Column(name = "lim_g_m")
    private Double limGM;

    @Column(name = "lim_kg")
    private Double limKg;

    @Column(name = "lim_t")
    private Double limT;

    @Column(name = "fact_mg_dm_text")
    private String factMgDmText;

    @Column(name = "fact_g_m_text")
    private String factGMText;

    @Column(name = "fact_kg_text")
    private String factKgText;

    @Column(name = "fact_t_text")
    private String factTText;

    @Column(name = "norm_mg_dm_text")
    private String normMgDmText;

    @Column(name = "norm_g_m_text")
    private String normGMText;

    @Column(name = "norm_kg_text")
    private String normKgText;

    @Column(name = "norm_t_text")
    private String normTText;

    @Column(name = "lim_mg_dm_text")
    private String limMgDmText;

    @Column(name = "lim_g_m_text")
    private String limGMText;

    @Column(name = "lim_kg_text")
    private String limKgText;

    @Column(name = "lim_t_text")
    private String limTText;

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
        AsvFactQualityDetailEntity that = (AsvFactQualityDetailEntity) o;
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
