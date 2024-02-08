package ru.rosniivh.swr.domain.object.asv;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.util.Objects;

@Builder
@Entity
@Table(name = "cat_asv_import_okopf_2012", schema = "dbo")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvImportOkopf2012Entity {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(name = "delete")
    private Boolean delete;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "parent_id")
    private Integer parentId;

    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "old_parent_code")
    private String oldParentCode;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvImportOkopf2012Entity that = (AsvImportOkopf2012Entity) o;
        return getUid() != null && Objects.equals(getUid(), that.getUid());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}
