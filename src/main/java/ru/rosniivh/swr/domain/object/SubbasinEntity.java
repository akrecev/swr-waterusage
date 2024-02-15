package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import lombok.*;
import ru.rosniivh.swr.domain.auth.UserEntity;
import java.math.BigDecimal;
import java.time.Instant;
import java.util.Set;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_subbasin", schema = "dbo")
public class SubbasinEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "full_code", length = Integer.MAX_VALUE)
    private String fullCode;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

<<<<<<< HEAD
=======
    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "river_basin_id", nullable = false)
    private RiverBasinEntity riverBasin;

>>>>>>> swr-waterusage/user-test
    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "area")
    private BigDecimal area;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="inserted_by", nullable=false)
    private UserEntity insertedBy;

    @Column(name = "inserted_on", nullable = false)
    private Instant insertedOn;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="updated_by")
    private UserEntity updatedBy;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "confirmed_on")
    private Instant confirmedOn;

//    Добавить
//    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
//    @JoinColumn(name="river_basin_id", nullable=false)
//    private RiverBasinEntity riverBasin;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="confirmed_by")
    private UserEntity confirmedBy;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="confirmation_document_id")
    private ConfirmationDocumentEntity confirmationDocument;

//    Добавить
//    @ManyToMany(targetEntity=ControlPointEntity.class, cascade=CascadeType.MERGE)
//    @JoinTable(schema="dbo", name="jt_subbasin_control_point", joinColumns=@JoinColumn(name="subbasin_id", nullable=false), inverseJoinColumns=@JoinColumn(name="control_point_id"))
//    public Set<ControlPointEntity> getControlPoints() = new LinkedHashSet<>();

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
        SubbasinEntity that = (SubbasinEntity) o;
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