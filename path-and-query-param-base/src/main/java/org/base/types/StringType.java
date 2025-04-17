package org.base.types;

public class StringType {

    private String value;


    protected StringType() {
    }


    protected StringType(final String value) {
        this.value = value;
    }


    public String getValue() {
        return value;
    }


    public static StringType fromString(final String s) {
        return new StringType(s);
    }


    @Override
    public String toString() {
        return value;
    }
}
