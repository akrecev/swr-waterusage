package ru.rosniivh.swr.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class UidCodeNameFilter {
    private Integer uid;
    private String name;
    private String code;
}
