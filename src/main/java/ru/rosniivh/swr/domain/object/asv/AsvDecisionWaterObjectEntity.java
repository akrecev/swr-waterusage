package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvIzvEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvUkizvIEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvUkizvKEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_decision_water_object", schema = "dbo")
public class AsvDecisionWaterObjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_id")
    private AsvDecisionEntity decision;

    @Column(name = "water_object_id")
    private Integer waterObjectId;

    @Column(name = "water_object_name")
    private String waterObjectName;

    @Column(name = "morf_length")
    private Double morfLength;

    @Column(name = "morf_distance")
    private Double morfDistance;

    @Column(name = "morf_square")
    private Double morfSquare;

    @Column(name = "morf_volume")
    private Double morfVolume;

    @Column(name = "morf_depth_min")
    private Double morfDepthMin;

    @Column(name = "morf_depth_avg")
    private Double morfDepthAvg;

    @Column(name = "morf_depth_max")
    private Double morfDepthMax;

    @Column(name = "morf_other")
    private String morfOther;

    @Column(name = "hydr_cons")
    private Double hydrCons;

    @Column(name = "hydr_speed_min")
    private Double hydrSpeedMin;

    @Column(name = "hydr_speed_max")
    private Double hydrSpeedMax;

    @Column(name = "hydr_level_amplitude")
    private Double hydrLevelAmplitude;

    @Column(name = "hydr_adverse_period")
    private String hydrAdversePeriod;

    @Column(name = "hydr_t_year")
    private Double hydrTYear;

    @Column(name = "hydr_t_winter")
    private Double hydrTWinter;

    @Column(name = "hydr_t_spring")
    private Double hydrTSpring;

    @Column(name = "hydr_t_summer")
    private Double hydrTSummer;

    @Column(name = "hydr_t_autumn")
    private Double hydrTAutumn;

    @Column(name = "hydr_other")
    private String hydrOther;

    @Column(name = "qual_date")
    private LocalDate qualDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "izv_id")
    private AsvIzvEntity izv;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ukizv_i_id")
    private AsvUkizvIEntity ukizvI;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ukizv_k_id")
    private AsvUkizvKEntity ukizvK;

    @Column(name = "qual_other")
    private String qualOther;

    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "is2054")
    private Boolean is2054;

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
        AsvDecisionWaterObjectEntity that = (AsvDecisionWaterObjectEntity) o;
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
