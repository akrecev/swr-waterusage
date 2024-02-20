package ru.rosniivh.swr.dto.catalog.asv;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvImportOkopf2012Dto {

    private Integer uid;
    private Boolean delete;
    private String code;
    private String name;
    private String description;
    private Integer parentId;
    private String oldCode;
    private String oldParentCode;
}
