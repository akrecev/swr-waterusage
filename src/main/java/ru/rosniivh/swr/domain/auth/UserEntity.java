package ru.rosniivh.swr.domain.auth;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.BasinWaterManagementBoardEntity;
import ru.rosniivh.swr.domain.catalog.WaterResourcesDivisionEntity;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;

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

    @Column(name = "username")
    private String username;

    @Column(name = "email")
    private String email;

    @JsonIgnore
    @Column(name = "password")
    private String password;

    @Column(name = "last_password_reset")
    private LocalDate lastPasswordReset;

    @Column(name = "fio")
    private String fio;

    @Column(name = "auth_text")
    private String authText;

    @Column(name = "\"position\"")
    private String position;

    @Column(name = "phone")
    private String phone;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "bwm_id")
    private BasinWaterManagementBoardEntity bwm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wrd_id")
    private WaterResourcesDivisionEntity wrd;

    @Column(name = "authorities")
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
