package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import java.util.Objects;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.proxy.HibernateProxy;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_appdoc_receipt", schema = "dbo")
public class AsvAppdocReceiptEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "appdoc_id", nullable = false)
    private AsvAppdocEntity appdoc;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "material")
    private String material;

    @Column(name = "requisites")
    private String requisites;

    @Column(name = "page_cnt")
    private Integer pageCnt;

    @Column(name = "original_cnt")
    private Integer originalCnt;

    @Column(name = "copy_cnt")
    private Integer copyCnt;

    @Column(name = "doc_num")
    private String docNum;

    @Column(name = "notary_affirm")
    private Integer notaryAffirm;

    @Column(name = "other_affirm")
    private Integer otherAffirm;

    @Column(name = "complect")
    private Integer complect;

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
        AsvAppdocReceiptEntity that = (AsvAppdocReceiptEntity) o;
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
