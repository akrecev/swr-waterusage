package ru.rosniivh.swr.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(schema="dbo", name="cat_asv_import_okopf_2012")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvImportOkopf2012Entity {

    @Id
    @Column(name = "uid")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer uid;

    @Column(name = "delete")
    private Boolean delete;

    @Column(name = "code")
    private String code;

    @Column(name = "description")
    private String description;

    @Column(name = "parentId")
    private Integer parentId;

    @Column(name = "old_code")
    private String oldCode;

    @Column(name = "old_parent_code")
    private String oldParentCode;
}
