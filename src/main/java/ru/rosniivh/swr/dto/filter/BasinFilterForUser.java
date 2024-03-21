package ru.rosniivh.swr.dto.filter;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class BasinFilterForUser {
    private Integer uidHeParcel;
    private Integer uidSubBasin;
    private Integer uidRiver;
    private Integer uidDistrict;

    private String nameHeParcel;
    private String nameSubBasin;
    private String nameRiver;
    private String nameDistrict;

    private String codeHeParcel;
    private String codeSubBasin;
    private String codeRiver;
    private String codeDistrict;

    private String constNumber;
    private String nameRf;
    private Integer uidRf;
    private String federalDistrict;
    private Integer uidFd;

    public BasinFilterForUser(
            Integer uidHeParcel,
            Integer uidSubBasin,
            Integer uidRiver,
            Integer uidDistrict,
            String nameHeParcel,
            String nameSubBasin,
            String nameRiver,
            String nameDistrict,
            String codeHeParcel,
            String codeSubBasin,
            String codeRiver,
            String codeDistrict) {
        this.uidHeParcel = uidHeParcel;
        this.uidSubBasin = uidSubBasin;
        this.uidRiver = uidRiver;
        this.uidDistrict = uidDistrict;
        this.nameHeParcel = nameHeParcel;
        this.nameSubBasin = nameSubBasin;
        this.nameRiver = nameRiver;
        this.nameDistrict = nameDistrict;
        this.codeHeParcel = codeHeParcel;
        this.codeSubBasin = codeSubBasin;
        this.codeRiver = codeRiver;
        this.codeDistrict = codeDistrict;
    }

    public BasinFilterForUser(String constNumber, String nameRf, Integer uidRf, String federalDistrict, Integer uidFd) {
        this.constNumber = constNumber;
        this.nameRf = nameRf;
        this.uidRf = uidRf;
        this.federalDistrict = federalDistrict;
        this.uidFd = uidFd;
    }
}
