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
@Table(name = "o_asv_contract_payment_card_operation", schema = "dbo")
public class AsvContractPaymentCardOperationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "card_id")
    private AsvContractPaymentCardEntity card;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "op_date")
    private LocalDate opDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "op_id")
    private AsvAdmOperationEntity op;

    @Column(name = "op_old_code", length = Integer.MAX_VALUE)
    private String opOldCode;

    @Column(name = "op_name", length = Integer.MAX_VALUE)
    private String opName;

    @Column(name = "payment_period")
    private LocalDate paymentPeriod;

    @Column(name = "payment_sum")
    private Double paymentSum;

    @Column(name = "doc_number", length = Integer.MAX_VALUE)
    private String docNumber;

    @Column(name = "doc_date")
    private LocalDate docDate;

    @Column(name = "receipt_date")
    private LocalDate receiptDate;

    @Column(name = "receipt_sum")
    private Double receiptSum;

    @Column(name = "arrear")
    private Double arrear;

    @Column(name = "overpayment")
    private Double overpayment;

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
        AsvContractPaymentCardOperationEntity that = (AsvContractPaymentCardOperationEntity) o;
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
