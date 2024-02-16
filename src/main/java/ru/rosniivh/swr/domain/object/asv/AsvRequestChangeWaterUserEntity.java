package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.time.LocalDate;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvImportAuthOrgContractEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_request_change_water_user", schema = "dbo")
public class AsvRequestChangeWaterUserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "ref")
    private String ref;

    @Column(name = "mark_del")
    private Integer markDel;

    @Column(name = "date_create")
    private LocalDate dateCreate;

    @Column(name = "number")
    private String number;

    @Column(name = "posted")
    private Integer posted;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "wateruser_id")
    private AsvImportLegalSubjectEntity wateruser;

    @Column(name = "wateruser_id_old")
    private String wateruserIdOld;

    @Column(name = "basis")
    private String basis;

    @Column(name = "status_id")
    private Integer statusId;

    @Column(name = "status_id_old")
    private String statusIdOld;

    @Column(name = "reason_refuse")
    private String reasonRefuse;

    @Column(name = "user_id")
    private Integer userId;

    @Column(name = "user_id_old")
    private String userIdOld;

    @Column(name = "date_confirm")
    private LocalDate dateConfirm;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    private AsvImportAuthOrgContractEntity organ;

    @Column(name = "organ_id_old")
    private String organIdOld;

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
        AsvRequestChangeWaterUserEntity that = (AsvRequestChangeWaterUserEntity) o;
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
