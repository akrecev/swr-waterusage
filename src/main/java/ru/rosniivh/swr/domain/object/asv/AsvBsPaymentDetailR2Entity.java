package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.math.BigDecimal;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_bs_payment_detail_r2", schema = "dbo")
public class AsvBsPaymentDetailR2Entity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "parent_id")
    private AsvBsPaymentDetailEntity parent;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "accrual_year")
    private BigDecimal accrualYear;

    @Column(name = "payment_year")
    private BigDecimal paymentYear;

    @Column(name = "accrual_q1")
    private BigDecimal accrualQ1;

    @Column(name = "payment_q1")
    private BigDecimal paymentQ1;

    @Column(name = "accrual_q2")
    private BigDecimal accrualQ2;

    @Column(name = "payment_q2")
    private BigDecimal paymentQ2;

    @Column(name = "accrual_q3")
    private BigDecimal accrualQ3;

    @Column(name = "payment_q3")
    private BigDecimal paymentQ3;

    @Column(name = "accrual_q4")
    private BigDecimal accrualQ4;

    @Column(name = "payment_q4")
    private BigDecimal paymentQ4;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvBsPaymentDetailR2Entity that = (AsvBsPaymentDetailR2Entity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}