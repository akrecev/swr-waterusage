package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.catalog.asv.AsvActivityEntity;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_activities_plan_volumes", schema = "dbo")
public class AsvActivitiesPlanVolumeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "year")
    private Integer year;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "kv1")
    private Double kv1;

    @Column(name = "kv2")
    private Double kv2;

    @Column(name = "kv3")
    private Double kv3;

    @Column(name = "kv4")
    private Double kv4;

    @Column(name = "total")
    private Double total;

    @Column(name = "old_code_detail_activity", length = Integer.MAX_VALUE)
    private String oldCodeDetailActivity;

    @Column(name = "old_code_activity", length = Integer.MAX_VALUE)
    private String oldCodeActivity;

    @Column(name = "old_code_parent", length = Integer.MAX_VALUE)
    private String oldCodeParent;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activity_id")
    private AsvActivityEntity activity;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "activities_plan_id")
    private AsvActivitiesPlanEntity activitiesPlan;

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
        AsvActivitiesPlanVolumeEntity that = (AsvActivitiesPlanVolumeEntity) o;
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
