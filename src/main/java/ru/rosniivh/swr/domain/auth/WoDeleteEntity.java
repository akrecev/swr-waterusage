package ru.rosniivh.swr.domain.auth;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "s_wo_delete", schema = "dbo")
public class WoDeleteEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "uid_wo")
    private Integer uidWo;

    @Column(name = "code")
    private String code;

    @Column(name = "uid_user")
    private Integer uidUser;

    @Column(name = "upd_date")
    private Instant updDate;

    @Column(name = "notes")
    private String notes;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        WoDeleteEntity that = (WoDeleteEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}