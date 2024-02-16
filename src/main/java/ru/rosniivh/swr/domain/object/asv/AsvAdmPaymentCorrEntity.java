package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvWuAimPaymentEntity;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_adm_payment_corr", schema = "dbo")
public class AsvAdmPaymentCorrEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oper_id")
    private AsvAdmOperationEntity oper;

    @Column(name = "npp")
    private Integer npp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "aim_id")
    private AsvWuAimPaymentEntity aim;

    @Column(name = "summ_plan")
    private Double summPlan;

    @Column(name = "summ_fact")
    private Double summFact;

    @Column(name = "summ_corr")
    private Double summCorr;

    @Column(name = "calc_summ")
    private Double calcSumm;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvAdmPaymentCorrEntity that = (AsvAdmPaymentCorrEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}