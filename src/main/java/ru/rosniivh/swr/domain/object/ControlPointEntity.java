package ru.rosniivh.swr.domain.object;

import jakarta.persistence.*;
import java.math.BigDecimal;
import lombok.*;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "o_control_point", schema = "dbo")
public class ControlPointEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "ladeg")
    private Integer ladeg;

    @Column(name = "lamin")
    private Integer lamin;

    @Column(name = "lasec")
    private BigDecimal lasec;

    @Column(name = "lodeg")
    private Integer lodeg;

    @Column(name = "lomin")
    private Integer lomin;

    @Column(name = "losec")
    private BigDecimal losec;

    @Column(name = "alt")
    private BigDecimal alt;

    @Column(name = "line_description", length = Integer.MAX_VALUE)
    private String lineDescription;

    @Column(name = "description", length = Integer.MAX_VALUE)
    private String description;

    @Column(name = "order_num")
    private Integer orderNum;
}
