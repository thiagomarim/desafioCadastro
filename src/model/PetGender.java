package model;

public enum PetGender {
    MACHO("Macho"),
    FEMEA("Fêmea");

    private final String displayName;

    PetGender(String displayName) {
        this.displayName = displayName;
    }

    public String toString() {
        return displayName;
    }
}
