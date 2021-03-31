package com.cellebrite.driver;

public enum Browser {

    CHROME("Chrome"),
    FIREFOX("Firefox");

    private String value;

    Browser(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

}
