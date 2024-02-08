package ru.rosniivh.swr.domain.auth;

import lombok.*;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "s_users", schema = "dbo")
public class UserEntity {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Lob
    @Column(name = "username")
    private String username;

    @Lob
    @Column(name = "email")
    private String email;

    @Lob
    @Column(name = "password")
    private String password;

    @Column(name = "last_password_reset")
    private LocalDate lastPasswordReset;

    @Lob
    @Column(name = "fio")
    private String fio;

    @Lob
    @Column(name = "auth_text")
    private String authText;

    @Lob
    @Column(name = "\"position\"")
    private String position;

    @Lob
    @Column(name = "phone")
    private String phone;

    @Lob
    @Column(name = "authorities")
    private String authorities;

    @Column(name = "legacy")
    private Boolean legacy;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "asv")
    private Integer asv;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        UserEntity that = (UserEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}