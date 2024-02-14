package ru.rosniivh.swr.domain.catalog;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Entity
@Table(name = "cat_executive_authority_type", schema = "dbo")
public class ExecutiveAuthorityTypeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "uid", nullable = false)
    private Integer id;

    @Column(name = "code", length = Integer.MAX_VALUE)
    private String code;

    @Column(name = "name", length = Integer.MAX_VALUE)
    private String name;

    @Column(name = "org_type", length = Integer.MAX_VALUE)
    private String orgType;

    @Column(name = "visible", nullable = false)
    private Boolean visible = false;
}
