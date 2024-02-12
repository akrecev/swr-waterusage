package ru.rosniivh.swr.domain.auth;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.AsvImportAuthOrgContractEntity;
import ru.rosniivh.swr.domain.catalog.BasinWaterManagementBoardEntity;
import ru.rosniivh.swr.domain.catalog.WaterResourcesDivisionEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "s_users", schema = "dbo")
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "username", length = Integer.MAX_VALUE)
    private String username;

    @Column(name = "email", length = Integer.MAX_VALUE)
    private String email;

    @Column(name = "password", length = Integer.MAX_VALUE)
    private String password;

    @Column(name = "last_password_reset")
    private LocalDate lastPasswordReset;

    @Column(name = "fio", length = Integer.MAX_VALUE)
    private String fio;

    @Column(name = "auth_text", length = Integer.MAX_VALUE)
    private String authText;

    @Column(name = "\"position\"", length = Integer.MAX_VALUE)
    private String position;

    @Column(name = "phone", length = Integer.MAX_VALUE)
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bwm_id")
    private BasinWaterManagementBoardEntity bwm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wrd_id")
    private WaterResourcesDivisionEntity wrd;

    @Column(name = "authorities", length = Integer.MAX_VALUE)
    private String authorities;

    @Column(name = "legacy")
    private Boolean legacy;

    @Column(name = "deleted")
    private Boolean deleted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "auth_org_id")
    private AsvImportAuthOrgContractEntity authOrg;

    @Column(name = "asv")
    private Integer asv;

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
        UserEntity that = (UserEntity) o;
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
