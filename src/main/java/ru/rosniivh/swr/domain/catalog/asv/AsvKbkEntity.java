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
@Table(name = "cat_asv_kbk", schema = "dbo")
public class AsvKbkEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "code")
    private String code;

    @Lob
    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "admin_code")
    private String adminCode;

    @Lob
    @Column(name = "kind_code")
    private String kindCode;

    @Lob
    @Column(name = "subkind_code")
    private String subkindCode;

    @Lob
    @Column(name = "ekd_code")
    private String ekdCode;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvKbkEntity that = (AsvKbkEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}