package ru.rosniivh.swr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;

@AllArgsConstructor
@Entity
@Table(name = "cat_asv_status", schema = "dbo")
@NoArgsConstructor
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
