package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
import ru.rosniivh.swr.domain.auth.UserEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.LinkedHashSet;

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

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "num", length = Integer.MAX_VALUE)
    private String num;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "subbasin_id", nullable = false)
    private SubbasinEntity subbasin;

    @Column(name = "description", length = Integer.MAX_VALUE)
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

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="updated_by")
    private UserEntity updatedBy;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "confirmed_on")
    private Instant confirmedOn;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="confirmed_by")
    private UserEntity confirmedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "confirmation_document_id")
    private ConfirmationDocumentEntity confirmationDocument;

//    Добавить
//    @OneToMany(targetEntity=WaterObjectEntity.class, mappedBy="heParcel", cascade=CascadeType.MERGE)
//    private Set<WaterObjectEntity> waterObjects;

//    Добавить
//    @ManyToMany(targetEntity=ControlPointEntity.class, cascade=CascadeType.MERGE)
//    @JoinTable(schema="dbo", name="jt_he_parcel_control_point",
//            joinColumns=@JoinColumn(name="he_parcel_id", nullable=false),
//            inverseJoinColumns=@JoinColumn(name="control_point_id"))
//    private Set<ControlPointEntity> controlPointEntitys = new LinkedHashSet<>();

}