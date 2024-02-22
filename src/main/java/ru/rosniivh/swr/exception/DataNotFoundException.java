package ru.rosniivh.swr.exception;

import lombok.experimental.StandardException;

@StandardException
public class DataNotFoundException extends RuntimeException {
    public DataNotFoundException(String asvImportAuthOrgContractEntity_not_found) {}
}
