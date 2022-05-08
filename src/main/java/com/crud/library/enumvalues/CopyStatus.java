package com.crud.library.enumvalues;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;

import java.util.stream.Stream;

public enum CopyStatus {
    AVAILABLE("available"),
    BORROWED("borrowed"),
    DAMAGED("damaged"),
    LOST("lost");

    private String status;

    private CopyStatus(String status) {
        this.status = status;
    }

    @JsonCreator
    public static CopyStatus decode(final String status) {
        return Stream.of(CopyStatus.values())
                .filter(targetEnum -> targetEnum.status.equals(status))
                .findFirst()
                .orElse(null);
    }

    @JsonValue
    public String getStatus() {
        return status;
    }
}