package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvWaterObject65Entity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_granting_right_detail", schema = "dbo")
public class AsvGrantingRightDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "right_id")
    private AsvGrantingRightEntity right;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "water_object_id")
    private Integer waterObjectId;

    @Column(name = "wo_old_code")
    private String woOldCode;

    @Column(name = "count_wu_all")
    private Integer countWuAll;

    @Column(name = "count_wu_2tp")
    private Integer countWu2tp;

    @Column(name = "count_wu_license")
    private Integer countWuLicense;

    @Column(name = "count_license")
    private Integer countLicense;

    @Column(name = "count_docs")
    private Integer countDocs;

    @Column(name = "intake")
    private Double intake;

    @Column(name = "discharge")
    private Double discharge;

    @Column(name = "intake_discharge")
    private Double intakeDischarge;

    @Column(name = "without_withdrawal")
    private Double withoutWithdrawal;

    @Column(name = "limit_intake")
    private Double limitIntake;

    @Column(name = "limit_discharge")
    private Double limitDischarge;

    @Column(name = "square_aqua")
    private Double squareAqua;

    @Column(name = "volume_hpp")
    private Double volumeHpp;

    @Column(name = "volume_wood")
    private Double volumeWood;

    @Column(name = "result_rewiev_issued")
    private Integer resultRewievIssued;

    @Column(name = "result_rewiev_changed")
    private Integer resultRewievChanged;

    @Column(name = "result_rewiev_extended")
    private Integer resultRewievExtended;

    @Column(name = "result_rewiev_denied")
    private Integer resultRewievDenied;

    @Column(name = "result_rewiev_stoped")
    private Integer resultRewievStoped;

    @Column(name = "result_rewiev_canceled")
    private Integer resultRewievCanceled;

    @Column(name = "ref_old_code")
    private String refOldCode;

    @Column(name = "wo_old_name")
    private String woOldName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "water_object65_id")
    private AsvWaterObject65Entity waterObject65;

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
        AsvGrantingRightDetailEntity that = (AsvGrantingRightDetailEntity) o;
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
