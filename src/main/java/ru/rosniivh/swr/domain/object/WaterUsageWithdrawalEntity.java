package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;
import ru.rosniivh.swr.domain.catalog.WaterQualityCategoryEntity;
import ru.rosniivh.swr.domain.catalog.WaterSourceTypeEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_water_usage_withdrawal", schema = "dbo")
public class WaterUsageWithdrawalEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "year", nullable = false)
    private Short year;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rfs_id")
    private RfSubjectEntity rfs;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "hep_id")
    private HeParcelEntity hep;

    @Column(name = "hep_textual", length = Integer.MAX_VALUE)
    private String hepTextual;

    @Column(name = "hep_name", length = Integer.MAX_VALUE)
    private String hepName;

    @Column(name = "wo_name", length = Integer.MAX_VALUE)
    private String woName;

    @Column(name = "water_cadastre_code", length = Integer.MAX_VALUE)
    private String waterCadastreCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_type_id")
    private WaterSourceTypeEntity sourceType;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wq_category_id")
    private WaterQualityCategoryEntity wqCategory;

    @Column(name = "withdrawal_by_contract")
    private Double withdrawalByContract;

    @Column(name = "withdrawal_year")
    private Double withdrawalYear;

    @Column(name = "withdrawal_month_1")
    private Double withdrawalMonth1;

    @Column(name = "withdrawal_month_2")
    private Double withdrawalMonth2;

    @Column(name = "withdrawal_month_3")
    private Double withdrawalMonth3;

    @Column(name = "withdrawal_month_4")
    private Double withdrawalMonth4;

    @Column(name = "withdrawal_month_5")
    private Double withdrawalMonth5;

    @Column(name = "withdrawal_month_6")
    private Double withdrawalMonth6;

    @Column(name = "withdrawal_month_7")
    private Double withdrawalMonth7;

    @Column(name = "withdrawal_month_8")
    private Double withdrawalMonth8;

    @Column(name = "withdrawal_month_9")
    private Double withdrawalMonth9;

    @Column(name = "withdrawal_month_10")
    private Double withdrawalMonth10;

    @Column(name = "withdrawal_month_11")
    private Double withdrawalMonth11;

    @Column(name = "withdrawal_month_12")
    private Double withdrawalMonth12;

    @Column(name = "transportation_loss")
    private Double transportationLoss;

    @Column(name = "used_all")
    private Double usedAll;

    @Column(name = "used_household")
    private Double usedHousehold;

    @Column(name = "used_production")
    private Double usedProduction;

    @Column(name = "used_irrigation")
    private Double usedIrrigation;

    @Column(name = "used_agricultural")
    private Double usedAgricultural;

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
        WaterUsageWithdrawalEntity that = (WaterUsageWithdrawalEntity) o;
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
