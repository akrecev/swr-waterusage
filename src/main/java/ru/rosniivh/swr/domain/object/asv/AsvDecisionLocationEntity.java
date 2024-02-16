package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_decision_location", schema = "dbo")
public class AsvDecisionLocationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_wo_id")
    private AsvDecisionWaterObjectEntity decisionWo;

    @Column(name = "location", length = Integer.MAX_VALUE)
    private String location;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "water_area")
    private Double waterArea;

    @Column(name = "v1_loc_description", length = Integer.MAX_VALUE)
    private String v1LocDescription;

    @Column(name = "v1_shore_distance", length = Integer.MAX_VALUE)
    private String v1ShoreDistance;

    @Column(name = "v1_loc_level", length = Integer.MAX_VALUE)
    private String v1LocLevel;

    @Column(name = "v1_facilities_type", length = Integer.MAX_VALUE)
    private String v1FacilitiesType;

    @Column(name = "v1_facilities_project_perf", length = Integer.MAX_VALUE)
    private String v1FacilitiesProjectPerf;

    @Column(name = "v1_facilities_fact_perf", length = Integer.MAX_VALUE)
    private String v1FacilitiesFactPerf;

    @Column(name = "v1_water_purification_degree", length = Integer.MAX_VALUE)
    private String v1WaterPurificationDegree;

    @Column(name = "v1_discharge_volume")
    private Double v1DischargeVolume;

    @Column(name = "v1_volume_instrumentation", length = Integer.MAX_VALUE)
    private String v1VolumeInstrumentation;

    @Column(name = "v1_quality_instrumentation", length = Integer.MAX_VALUE)
    private String v1QualityInstrumentation;

    @Column(name = "v1_other", length = Integer.MAX_VALUE)
    private String v1Other;

    @Column(name = "v2_structure_kind", length = Integer.MAX_VALUE)
    private String v2StructureKind;

    @Column(name = "v2_overall_parameters", length = Integer.MAX_VALUE)
    private String v2OverallParameters;

    @Column(name = "v2_structure_parameters", length = Integer.MAX_VALUE)
    private String v2StructureParameters;

    @Column(name = "v2_environmental_measures", length = Integer.MAX_VALUE)
    private String v2EnvironmentalMeasures;

    @Column(name = "v3_structure_kind", length = Integer.MAX_VALUE)
    private String v3StructureKind;

    @Column(name = "v3_overall_parameters", length = Integer.MAX_VALUE)
    private String v3OverallParameters;

    @Column(name = "v4_locality_name", length = Integer.MAX_VALUE)
    private String v4LocalityName;

    @Column(name = "v4_locality_distance")
    private Double v4LocalityDistance;

    @Column(name = "v4_structure_name", length = Integer.MAX_VALUE)
    private String v4StructureName;

    @Column(name = "v4_overall_parameters", length = Integer.MAX_VALUE)
    private String v4OverallParameters;

    @Column(name = "v5_subsoil_usage_kind", length = Integer.MAX_VALUE)
    private String v5SubsoilUsageKind;

    @Column(name = "v5_subsoil_usage_license", length = Integer.MAX_VALUE)
    private String v5SubsoilUsageLicense;

    @Column(name = "v6_extraction_volume")
    private Double v6ExtractionVolume;

    @Column(name = "v6_storage_place_method", length = Integer.MAX_VALUE)
    private String v6StoragePlaceMethod;

    @Column(name = "v6_other", length = Integer.MAX_VALUE)
    private String v6Other;

    @Column(name = "v7_watercrafts", length = Integer.MAX_VALUE)
    private String v7Watercrafts;

    @Column(name = "v8_wood_volume")
    private Double v8WoodVolume;

    @Column(name = "v8_wood_rafting_length")
    private Double v8WoodRaftingLength;

    @Column(name = "v9_volume_year")
    private Double v9VolumeYear;

    @Column(name = "v9_volume_month_all")
    private Double v9VolumeMonthAll;

    @Column(name = "v9_irrigation_square")
    private Double v9IrrigationSquare;

    @Column(name = "v9_withdrawal_performance")
    private Double v9WithdrawalPerformance;

    @Column(name = "v10_wpz_square")
    private Double v10WpzSquare;

    @Column(name = "v10_population_category", length = Integer.MAX_VALUE)
    private String v10PopulationCategory;

    @Column(name = "v10_peak_count")
    private Double v10PeakCount;

    @Column(name = "v10_pollutant_distance")
    private Double v10PollutantDistance;

    @Column(name = "v10_hazard_protection", length = Integer.MAX_VALUE)
    private String v10HazardProtection;

    @Column(name = "v10_bottom_shore_char", length = Integer.MAX_VALUE)
    private String v10BottomShoreChar;

    @Column(name = "v10_access_to_water", length = Integer.MAX_VALUE)
    private String v10AccessToWater;

    @Column(name = "v10_access_road", length = Integer.MAX_VALUE)
    private String v10AccessRoad;

    @Column(name = "v10_other", length = Integer.MAX_VALUE)
    private String v10Other;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvDecisionLocationEntity that = (AsvDecisionLocationEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}