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
@Table(name = "cat_category_quality_water", schema = "dbo")
public class CategoryQualityWaterEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "withdrawal", length = Integer.MAX_VALUE)
    private String withdrawal;

    @Column(name = "get_code", length = Integer.MAX_VALUE)
    private String getCode;

    @Column(name = "use_code", length = Integer.MAX_VALUE)
    private String useCode;

    @Column(name = "after_u_code", length = Integer.MAX_VALUE)
    private String afterUCode;

    @Column(name = "code_2", length = Integer.MAX_VALUE)
    private String code2;

    @Column(name = "old_code", length = Integer.MAX_VALUE)
    private String oldCode;

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
        CategoryQualityWaterEntity that = (CategoryQualityWaterEntity) o;
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
