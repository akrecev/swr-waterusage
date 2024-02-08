package ru.rosniivh.swr.domain.catalog.asv;

import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Objects;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_additional_agreement", schema = "dbo")
public class AsvAdditionalAgreementEntity {
    @Id
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "contract_id")
    private Integer contractId;

    @Lob
    @Column(name = "reg_number")
    private String regNumber;

    @Lob
    @Column(name = "add_agr_number")
    private String addAgrNumber;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "npp")
    private Integer npp;

    @Lob
    @Column(name = "wu_start_period")
    private String wuStartPeriod;

    @Column(name = "has_observation_program")
    private Integer hasObservationProgram;

    @Lob
    @Column(name = "observation_program_points")
    private String observationProgramPoints;

    @Lob
    @Column(name = "organ_text")
    private String organText;

    @Lob
    @Column(name = "organ_name")
    private String organName;

    @Lob
    @Column(name = "organ_fio")
    private String organFio;

    @Lob
    @Column(name = "organ_basis")
    private String organBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Lob
    @Column(name = "water_user_name")
    private String waterUserName;

    @Lob
    @Column(name = "water_user_fio")
    private String waterUserFio;

    @Lob
    @Column(name = "water_user_basis")
    private String waterUserBasis;

    @Lob
    @Column(name = "notes")
    private String notes;

    @Lob
    @Column(name = "old_code")
    private String oldCode;

    @Lob
    @Column(name = "order_number")
    private String orderNumber;

    @Override
    public final boolean equals(Object o) {
        if (this == o) return true;
        if (o == null) return false;
        Class<?> oEffectiveClass = o instanceof HibernateProxy ? ((HibernateProxy) o).getHibernateLazyInitializer().getPersistentClass() : o.getClass();
        Class<?> thisEffectiveClass = this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass() : this.getClass();
        if (thisEffectiveClass != oEffectiveClass) return false;
        AsvAdditionalAgreementEntity that = (AsvAdditionalAgreementEntity) o;
        return getId() != null && Objects.equals(getId(), that.getId());
    }

    @Override
    public final int hashCode() {
        return this instanceof HibernateProxy ? ((HibernateProxy) this).getHibernateLazyInitializer().getPersistentClass().hashCode() : getClass().hashCode();
    }
}