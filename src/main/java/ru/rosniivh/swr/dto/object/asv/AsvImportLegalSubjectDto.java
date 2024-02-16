package ru.rosniivh.swr.dto.object.asv;

import java.util.LinkedHashSet;
import java.util.Set;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class AsvImportLegalSubjectDto {

    private Integer id;
    private String deleted;
    private String code;
    private String description;
    private String fullName;
    private String inn;
    private String kpp;
    private String ogrn;
    private String okpo;
    private String industryCode;
    private Integer industryId;
    private String oldIndustryCode;
    private String territValue;
    private Integer locationId;
    private String oldLocationId;
    private String minist;
    private Integer okved2001Id;
    private String oldOkved2001Id;
    private String requisites;
    private String legalAddress;
    private String placeAddress;
    private String phone;
    private String fax;
    private String lsExecutorPost;
    private String lsExecutorName;
    private String lsExecutorTypeDoc;
    private String lsExecutorSerieDoc;
    private String lsExecutorNumDoc;
    private String lsExecutorDateDoc;
    private String lsExecutorOrgDoc;
    private String lsExecutorOrgCodeDoc;
    private String lsExecutorOrgTypeDoc;
    private String destroy;
    private String lsContactName;
    private String lsContactPost;
    private String gup;
    private String okato;
    private Integer bankId;
    private String oldBankId;
    private Integer bankAccountId;
    private String lsType;
    private Integer okopf99Id;
    private String oldOkopf99Id;
    private String email;
    private String lsExecutorReason;
    private Integer okved2007Id;
    private String oldOkved2007Id;
    private String guiv;
    private String oldOkopf2012Id;
    private String snils;
    private String oktmo;
    private String eip;
    private String aeip;
    private String resident;
    private String kio;
    private String oldOkved2016Id;
    private String oldCode;
    private String oldBankAccountId;
    private Set<AsvAdditionalAgreementDto> asvAdditionalAgreementDtos = new LinkedHashSet<>();
    private Set<AsvContractDto> asvContractDtos = new LinkedHashSet<>();
    private Set<AsvContractTransferDto> asvContractTransferDtos = new LinkedHashSet<>();
    private Set<AsvDecisionDto> asvDecisionDtos = new LinkedHashSet<>();
}