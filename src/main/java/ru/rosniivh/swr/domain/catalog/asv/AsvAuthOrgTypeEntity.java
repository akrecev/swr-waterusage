package ru.rosniivh.swr.domain.catalog.asv;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cat_asv_auth_org_type", schema = "dbo")
public class AsvAuthOrgTypeEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "code")
    private String code;

    @Lob
    @Column(name = "name")
    private String name;

    @Lob
    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "deleted", nullable = false)
    private Boolean deleted = false;

    @Column(name = "old_id")
    private Integer oldId;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvAuthOrgTypeEntity that = (AsvAuthOrgTypeEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}