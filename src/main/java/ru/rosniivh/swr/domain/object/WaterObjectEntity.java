package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import lombok.*;
import org.apache.catalina.User;
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
@Table(name = "o_water_object", schema = "dbo")
public class WaterObjectEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "code", nullable = false, length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "category_id", nullable = false)
    private Integer categoryId;

    @Column(name = "type_id", nullable = false)
    private Integer typeId;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="hep_id")
    private HeParcelEntity hep;

    @Column(name = "name", nullable = false, length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "protected", nullable = false)
    private Boolean protectedField = false;

    @Column(name = "fishery_valuable", nullable = false)
    private Boolean fisheryValuable = false;

    @Column(name = "especially_fishery_valuable")
    private Boolean especiallyFisheryValuable;

    @Column(name = "shore_bias_deg")
    private BigDecimal shoreBiasDeg;

    @Column(name = "water_cadastre_number", length = Integer.MAX_VALUE)
    private String waterCadastreNumber;

    @Column(name = "water_cadastre_code", length = Integer.MAX_VALUE)
    private String waterCadastreCode;

    @Column(name = "estuary_distance")
    private BigDecimal estuaryDistance;

//    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
//    @JoinColumn(name="location_id")
//    private LocationEntity locationId;

//    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
//    @JoinColumn(name="cadastre_id")
//    private LandCadastreEntity cadastreId;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="fed_water_object_id")
    private WaterObjectEntity fedWaterObjectId;

    @Column(name = "owner_id")
    private Integer ownerId;

//    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
//    @JoinColumn(name="executive_authority_type_id")
//    private ExecutiveAuthorityTypeEntity executiveAuthorityTypeId;

    @Column(name = "inserted_on", nullable = false)
    private Instant insertedOn;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="inserted_by", nullable=false)
    private UserEntity insertedBy;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "confirmed_on")
    private Instant confirmedOn;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="confirmed_by")
    private UserEntity confirmedBy;

    @ManyToOne(fetch=FetchType.LAZY, cascade=CascadeType.MERGE)
    @JoinColumn(name="confirmation_document_id")
    private ConfirmationDocumentEntity confirmationDocument;

    @Column(name = "deleted")
    private Boolean deleted;

    @Column(name = "is2054")
    private Boolean is2054;

//    @ManyToMany(targetEntity=GkgnObjectEntity.class,
//            mappedBy="waterObjects",
//            cascade=CascadeType.MERGE)
//    private Set<GkgnObjectEntity> getGkgnObjects();

//    @OneToMany(targetEntity=ReservoirEntity.class,
//            mappedBy="waterObject",
//            cascade=CascadeType.PERSIST)
//    private Set<ReservoirEntity> getReservoirs();

//    @OneToMany(targetEntity=WOPropertyRightsLimitEntity.class, mappedBy="waterObject", cascade=CascadeType.MERGE)
//    private Set<WOPropertyRightsLimitEntity> getwOPropertyRightsLimits()

}