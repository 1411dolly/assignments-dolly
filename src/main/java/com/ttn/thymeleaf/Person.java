package com.ttn.thymeleaf;

public enum Person {
        USER("USER"),
        ADMIN("ADMIN"),
        SUPER_ADMIN("SUPER_ADMIN");
        String value;

    Person() {
    }

    Person(String value) {
            this.value = value;
        }

    @Override
    public String toString() {
        return super.toString();
    }

    public String getValue()
    {
        return value;
    }
}
