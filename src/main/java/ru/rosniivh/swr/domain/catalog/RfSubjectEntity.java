package ru.rosniivh.swr.domain.catalog;

import jakarta.persistence.*;
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
@Table(name = "cat_rf_subject", schema = "dbo")
public class RfSubjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "const_number", nullable = false)
    private String constNumber;

    @Column(name = "okato_code", nullable = false)
    private String okatoCode;

    @Column(name = "oktmo_code", nullable = false)
    private String oktmoCode;

    @Column(name = "gost_code")
    private String gostCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "fd_id")
    private FederalDistrictEntity fd;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wrd_id")
    private WaterResourcesDivisionEntity wrd;

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
        RfSubjectEntity that = (RfSubjectEntity) o;
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
