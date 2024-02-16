package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvContractTermGroupEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvExecutionStateEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvWoSourceTypeEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_contract_term", schema = "dbo")
public class AsvContractTermEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "contract_id")
    private AsvContractEntity contract;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "term_id")
    private AsvContractTermGroupEntity term;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "source_id")
    private AsvWoSourceTypeEntity source;

    @Column(name = "npp")
    private Integer npp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "add_agr_id")
    private AsvAdditionalAgreementEntity addAgr;

    @Column(name = "summ", length = Integer.MAX_VALUE)
    private String summ;

    @Column(name = "fin_source", length = Integer.MAX_VALUE)
    private String finSource;

    @Column(name = "period", length = Integer.MAX_VALUE)
    private String period;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "exec_state_id")
    private AsvExecutionStateEntity execState;

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
        AsvContractTermEntity that = (AsvContractTermEntity) o;
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
