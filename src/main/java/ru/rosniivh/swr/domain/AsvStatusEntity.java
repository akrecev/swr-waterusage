package ru.rosniivh.swr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema = "dbo", name = "cat_asv_status")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvStatusEntity {
    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(name = "name")
    private String name;

    @Column(name = "old_code")
    private String oldCode;
}
