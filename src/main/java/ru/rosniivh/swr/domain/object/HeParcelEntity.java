package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;
import java.util.Objects;
import java.util.Set;
import lombok.*;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.auth.UserEntity;
import ru.rosniivh.swr.domain.catalog.RfSubjectEntity;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_he_parcel", schema = "dbo")
public class HeParcelEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "code")
    private String code;

    @Column(name = "num")
    private String num;

    @Column(name = "name")
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subbasin_id", nullable = false)
    private SubbasinEntity subbasin;

    @Column(name = "description")
    private String description;

    @Column(name = "area")
    private BigDecimal area;

    @Column(name = "waterway_length")
    private BigDecimal waterwayLength;

    @Column(name = "inserted_on", nullable = false)
    private Instant insertedOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inserted_by", nullable = false)
    private UserEntity insertedBy;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "updated_by")
    private UserEntity updatedBy;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "confirmed_on")
    private Instant confirmedOn;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.MERGE)
    @JoinColumn(name = "confirmed_by")
    private UserEntity confirmedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "confirmation_document_id")
    private ConfirmationDocumentEntity confirmationDocument;

    @OneToMany(targetEntity = WaterObjectEntity.class, mappedBy = "hep", cascade = CascadeType.MERGE)
    private Set<WaterObjectEntity> waterObjects;

    @ManyToMany(targetEntity = RfSubjectEntity.class, cascade = CascadeType.MERGE)
    @JoinTable(
            schema = "dbo",
            name = "jt_he_parcel_rf_subject",
            joinColumns = {@JoinColumn(name = "he_parcel_id", referencedColumnName = "uid")},
            inverseJoinColumns = {@JoinColumn(name = "rf_subject_id", referencedColumnName = "uid")})
    private Set<RfSubjectEntity> rfSubjects = new LinkedHashSet<>();

    //    Добавить
    //    @ManyToMany(targetEntity=ControlPointEntity.class, cascade=CascadeType.MERGE)
    //    @JoinTable(schema="dbo", name="jt_he_parcel_control_point",
    //            joinColumns=@JoinColumn(name="he_parcel_id", nullable=false),
    //            inverseJoinColumns=@JoinColumn(name="control_point_id"))
    //    private Set<ControlPointEntity> controlPointEntitys = new LinkedHashSet<>();

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
        HeParcelEntity that = (HeParcelEntity) o;
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
