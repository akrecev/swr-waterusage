package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;
import ru.rosniivh.swr.domain.auth.UserEntity;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_river_basin", schema = "dbo")
public class RiverBasinEntity {
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

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "basin_district_id", nullable = false)
    private BasinDistrictEntity basinDistrict;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "area")
    private BigDecimal area;

    @Column(name = "inserted_on", nullable = false)
    private Instant insertedOn;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "inserted_by", nullable = false)
    private UserEntity insertedBy;

    @Column(name = "updated_on")
    private Instant updatedOn;

    @Column(name = "updated_by")
    private Integer updatedBy;

    @Column(name = "confirmed")
    private Boolean confirmed;

    @Column(name = "confirmed_on")
    private Instant confirmedOn;

    @Column(name = "confirmed_by")
    private Integer confirmedBy;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "confirmation_document_id")
    private ConfirmationDocumentEntity confirmationDocument;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        RiverBasinEntity that = (RiverBasinEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}