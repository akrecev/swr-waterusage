package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_adm_fin_calc", schema = "dbo")
public class AsvAdmFinCalcEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "oper_id")
    private AsvAdmOperationEntity oper;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "oper_doc_id")
    private Integer operDocId;

    @Column(name = "oper_doc_code")
    private String operDocCode;

    @Column(name = "payment_date")
    private LocalDate paymentDate;

    @Column(name = "accrual_summ")
    private Double accrualSumm;

    @Column(name = "transfer_doc_num")
    private String transferDocNum;

    @Column(name = "transfer_doc_date")
    private LocalDate transferDocDate;

    @Column(name = "income_date")
    private LocalDate incomeDate;

    @Column(name = "transfer_summ")
    private Double transferSumm;

    @Column(name = "arrear")
    private Double arrear;

    @Column(name = "debt_summ")
    private Double debtSumm;

    @Column(name = "delay_days")
    private Integer delayDays;

    @Column(name = "payment_rate")
    private Double paymentRate;

    @Column(name = "fin_summ")
    private Double finSumm;

    @Column(name = "calc_summ")
    private Double calcSumm;

    @Column(name = "notes")
    private String notes;

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
        AsvAdmFinCalcEntity that = (AsvAdmFinCalcEntity) o;
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
