package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
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
@Table(name = "o_asv_quota_detail", schema = "dbo")
public class AsvQuotaDetailEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quota_id")
    private AsvQuotaEntity quota;

    @Column(name = "quota_old_code")
    private String quotaOldCode;

    @Column(name = "npp")
    private Integer npp;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "organ_id")
    private AsvImportAuthOrgContractEntity organ;

    @Column(name = "organ_old_code")
    private String organOldCode;

    @Column(name = "q1")
    private Double q1;

    @Column(name = "q2")
    private Double q2;

    @Column(name = "q3")
    private Double q3;

    @Column(name = "q4")
    private Double q4;

    @Column(name = "sea_desc")
    private String seaDesc;

    @Column(name = "q1_sea")
    private Double q1Sea;

    @Column(name = "q2_sea")
    private Double q2Sea;

    @Column(name = "q3_sea")
    private Double q3Sea;

    @Column(name = "q4_sea")
    private Double q4Sea;

    @Column(name = "year")
    private Double year;

    @Column(name = "sea_year")
    private Double seaYear;

    @Column(name = "table_line")
    private Integer tableLine;

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
        AsvQuotaDetailEntity that = (AsvQuotaDetailEntity) o;
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
