package de.htw.webtechdemo.persistence;

public enum Gender {
    MALE(1), FEMALE(2);

    private final int name;

    private Gender(int name) {
        this.name = name;
    }

    /**
     * @return The string representation of this element in the enumeration.
     */
    public int getName() {
        return this.name;
    }
}