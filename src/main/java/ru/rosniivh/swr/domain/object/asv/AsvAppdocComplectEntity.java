package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_appdoc_complect", schema = "dbo")
public class AsvAppdocComplectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appdoc_id", nullable = false)
    private AsvAppdocEntity appdoc;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "material", length = Integer.MAX_VALUE)
    private String material;

    @Column(name = "notary_affirm")
    private Integer notaryAffirm;

    @Column(name = "other_affirm")
    private Integer otherAffirm;

    @Column(name = "original_cnt")
    private Integer originalCnt;

    @Column(name = "complect")
    private Integer complect;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvAppdocComplectEntity that = (AsvAppdocComplectEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}