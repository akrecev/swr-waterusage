package ru.rosniivh.swr.domain.object.asv;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;
import org.hibernate.proxy.HibernateProxy;

import java.time.LocalDate;
import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_asv_additional_agreement", schema = "dbo")
public class AsvAdditionalAgreementEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "contract_id")
    private Integer contractId;

    @Column(name = "reg_number")
    private String regNumber;

    @Column(name = "add_agr_number")
    private String addAgrNumber;

    @Column(name = "sign_date")
    private LocalDate signDate;

    @Column(name = "reg_date")
    private LocalDate regDate;

    @Column(name = "npp")
    private Integer npp;

    @Column(name = "wu_start_period")
    private String wuStartPeriod;

    @Column(name = "has_observation_program")
    private Integer hasObservationProgram;

    @Column(name = "observation_program_points")
    private String observationProgramPoints;

    @Column(name = "organ_text")
    private String organText;

    @Column(name = "organ_name")
    private String organName;

    @Column(name = "organ_fio")
    private String organFio;

    @Column(name = "organ_basis")
    private String organBasis;

    @ManyToOne(fetch = FetchType.LAZY)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JoinColumn(name = "water_user_id")
    private AsvImportLegalSubjectEntity waterUser;

    @Column(name = "water_user_name")
    private String waterUserName;

    @Column(name = "water_user_fio")
    private String waterUserFio;

    @Column(name = "water_user_basis")
    private String waterUserBasis;

    @Column(name = "notes")
    private String notes;

    @Column(name = "old_code")
    private String oldCode;

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