package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvPaymentRateEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvWuAimPaymentEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_contract_parameter", schema = "dbo")
public class AsvContractParameterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aim_id")
    private AsvWuAimPaymentEntity aim;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "payment_rate_id")
    private AsvPaymentRateEntity paymentRate;

    @Column(name = "year")
    private Integer year;

    @Column(name = "q1_plan")
    private Double q1Plan;

    @Column(name = "q2_plan")
    private Double q2Plan;

    @Column(name = "q3_plan")
    private Double q3Plan;

    @Column(name = "q4_plan")
    private Double q4Plan;

    @Column(name = "year_plan")
    private Double yearPlan;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_loc_id")
    private AsvContractLocationEntity contractLoc;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "add_agr_id")
    private AsvAdditionalAgreementEntity addAgr;

    @Column(name = "q1_fact")
    private Double q1Fact;

    @Column(name = "q2_fact")
    private Double q2Fact;

    @Column(name = "q3_fact")
    private Double q3Fact;

    @Column(name = "q4_fact")
    private Double q4Fact;

    @Column(name = "year_fact")
    private Double yearFact;

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
        AsvContractParameterEntity that = (AsvContractParameterEntity) o;
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
