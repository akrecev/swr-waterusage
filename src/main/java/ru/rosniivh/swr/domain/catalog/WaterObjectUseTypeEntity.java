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
@Table(name = "cat_water_object_use_type", schema = "dbo")
public class WaterObjectUseTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "in_code", length = Integer.MAX_VALUE)
    private String inCode;

    @Column(name = "get_code", length = Integer.MAX_VALUE)
    private String getCode;

    @Column(name = "out_code", length = Integer.MAX_VALUE)
    private String outCode;

    @Column(name = "old_code_in", length = Integer.MAX_VALUE)
    private String oldCodeIn;

    @Column(name = "old_code_out", length = Integer.MAX_VALUE)
    private String oldCodeOut;

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
        WaterObjectUseTypeEntity that = (WaterObjectUseTypeEntity) o;
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
