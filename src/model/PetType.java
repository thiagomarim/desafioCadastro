package model;

public enum PetType {
    CACHORRO("Cachorro"),
    GATO("Gato");

    private final String displayName;

    PetType(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}
