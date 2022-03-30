package com.swivel.qpon.enums;

/**
 * ResponseStatusType
 */
public enum ResponseStatusType {

    ERROR("Error");

    private final String status;

    ResponseStatusType(String status) {
        this.status = status;
    }

    public String getValue() {
        return status;
    }
}
