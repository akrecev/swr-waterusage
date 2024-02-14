package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvWuAimPaymentEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_additional_agreement_period", schema = "dbo")
public class AsvAdditionalAgreementPeriodEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "additional_agreement_id")
    private AsvAdditionalAgreementEntity additionalAgreement;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wu_aim_payment_id")
    private AsvWuAimPaymentEntity wuAimPayment;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "period")
    private LocalDate period;

    @Column(name = "quarter")
    private Integer quarter;

    @Column(name = "old_code_ad_agr", length = Integer.MAX_VALUE)
    private String oldCodeAdAgr;

    @Column(name = "old_code_targer", length = Integer.MAX_VALUE)
    private String oldCodeTarger;

    @Column(name = "quarter_string", length = Integer.MAX_VALUE)
    private String quarterString;

    @Column(name = "year")
    private Integer year;

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
        AsvAdditionalAgreementPeriodEntity that = (AsvAdditionalAgreementPeriodEntity) o;
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
