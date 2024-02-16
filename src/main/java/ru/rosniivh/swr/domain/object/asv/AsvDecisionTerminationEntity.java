package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvDecisionStopBasisEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvStatusEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_decision_termination", schema = "dbo")
public class AsvDecisionTerminationEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "status")
    private AsvStatusEntity status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "decision_id")
    private AsvDecisionEntity decision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stop_basis_id")
    private AsvDecisionStopBasisEntity stopBasis;

    @Column(name = "end_date")
    private LocalDate endDate;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_number", length = Integer.MAX_VALUE)
    private String regNumber;

    @Column(name = "order_number", length = Integer.MAX_VALUE)
    private String orderNumber;

    @Column(name = "add_number", length = Integer.MAX_VALUE)
    private String addNumber;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    private AsvImportAuthOrgContractEntity organ;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

    @Column(name = "asv_document_id")
    private Integer asvDocumentId;

    @Column(name = "mark_del")
    private Integer markDel;

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
        AsvDecisionTerminationEntity that = (AsvDecisionTerminationEntity) o;
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
