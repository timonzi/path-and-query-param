package org.base.types;


public class TypesBuilder {

    private TypesBuilder() {
    }


    public static StringType newStringType(final String value) {
//        return new StringType(value);
        return StringType.fromString(value);
    }

}
