package com.books.entities.enums;

import com.fasterxml.jackson.annotation.JsonValue;

/**
 * Created by ham.heitormartins on 31/05/2017.
 */
public enum STATUS {

    FALSE(0, "false"), TRUE(1, "true");

    private final int id;
    private final String label;

    STATUS(int id, String label) {
        this.id = id;
        this.label = label;
    }

    public int getId() {
        return id;
    }

    public static STATUS fromValue(String value) {
        for (STATUS status : STATUS.values()) {
            if (status.getLabel().equals(value)) {
                return status;
            }
        }

        return null;
    }


    @JsonValue
    public String getLabel() {
        return label;
    }
}
