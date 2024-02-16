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

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_fact_disposal_detail", schema = "dbo")
public class AsvFactDisposalDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "disposal_id")
    private AsvFactDisposalEntity disposal;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "water_object_id")
    private Integer waterObjectId;

    @Column(name = "water_object_name", length = Integer.MAX_VALUE)
    private String waterObjectName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wo_type_id")
    private WaterObjectUseTypeEntity woType;

    @Column(name = "wo_type_code", length = Integer.MAX_VALUE)
    private String woTypeCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private CategoryQualityWaterEntity category;

    @Column(name = "category_code", length = Integer.MAX_VALUE)
    private String categoryCode;

    @Column(name = "disposal_num", length = Integer.MAX_VALUE)
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

    @Column(name = "la_deg_text", length = Integer.MAX_VALUE)
    private String laDegText;

    @Column(name = "la_min_text", length = Integer.MAX_VALUE)
    private String laMinText;

    @Column(name = "la_sec_text", length = Integer.MAX_VALUE)
    private String laSecText;

    @Column(name = "lo_deg_text", length = Integer.MAX_VALUE)
    private String loDegText;

    @Column(name = "lo_min_text", length = Integer.MAX_VALUE)
    private String loMinText;

    @Column(name = "lo_sec_text", length = Integer.MAX_VALUE)
    private String loSecText;

    @Column(name = "volume_req")
    private Double volumeReq;

    @Column(name = "volume_all")
    private Double volumeAll;

    @Column(name = "volume_without_purify")
    private Double volumeWithoutPurify;

    @Column(name = "volume_not_purified")
    private Double volumeNotPurified;

    @Column(name = "volume_clean")
    private Double volumeClean;

    @Column(name = "volume_purified_bio")
    private Double volumePurifiedBio;

    @Column(name = "volume_purified_fh")
    private Double volumePurifiedFh;

    @Column(name = "volume_purified_mech")
    private Double volumePurifiedMech;

    @Column(name = "volume_req_text", length = Integer.MAX_VALUE)
    private String volumeReqText;

    @Column(name = "volume_all_text", length = Integer.MAX_VALUE)
    private String volumeAllText;

    @Column(name = "volume_without_purify_text", length = Integer.MAX_VALUE)
    private String volumeWithoutPurifyText;

    @Column(name = "volume_not_purified_text", length = Integer.MAX_VALUE)
    private String volumeNotPurifiedText;

    @Column(name = "volume_clean_text", length = Integer.MAX_VALUE)
    private String volumeCleanText;

    @Column(name = "volume_purified_bio_text", length = Integer.MAX_VALUE)
    private String volumePurifiedBioText;

    @Column(name = "volume_purified_fh_text", length = Integer.MAX_VALUE)
    private String volumePurifiedFhText;

    @Column(name = "volume_purified_mech_text", length = Integer.MAX_VALUE)
    private String volumePurifiedMechText;

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
        AsvFactDisposalDetailEntity that = (AsvFactDisposalDetailEntity) o;
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
