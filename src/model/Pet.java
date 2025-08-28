package model;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Pet {
    private String name;
    private PetType petType;
    private PetGender petGender;
    private PetAddress address;
    private String age;
    private String weight;
    private String breed;
    private static final String NOT_INFORMED = "Nao Informado";

    public String getName() {
        return name;
    }

    public String setName(String name) {
        if (name == null) {
            this.name = NOT_INFORMED;
            return this.name;
        }

        if (!name.matches("^[a-zA-Z ]+$")) {
            throw new IllegalArgumentException("O pet deve conter um NOME e um SOBRENOME!");
        }

        this.name = name.trim();
        return this.name;
    }

    public PetType getPetType() {
        return petType;
    }

    public void setPetType(PetType petType) {
        this.petType = petType;
    }

    public void setPetTypeChoose(int chose) {
        switch (chose) {
            case 1:
                setPetType(PetType.CACHORRO);
                break;
            case 2:
                setPetType(PetType.GATO);
                break;
        }
    }

    public PetAddress getAddress() {
        return address;
    }

    public void setAddress(PetAddress address) {
        this.address = address;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String ageInput) {
        if (ageInput == null || ageInput.trim().isEmpty()) {
            this.age = NOT_INFORMED;
        }

        try {
            double age = Double.parseDouble(ageInput.trim());
            if (age > 20 || age < 0) {
                throw new IllegalArgumentException("Digite uma idade válida (Entre 1 a 20 anos)!");
            }
            this.age = String.valueOf((double) age) ;
        } catch (NullPointerException e ) {
            this.age = NOT_INFORMED;
        }
    }

    public String getWeight() {
        return weight;
    }

    public void setWeight(String weightInput) {
        if (weightInput == null || weightInput.trim().isEmpty()) {
            this.weight = NOT_INFORMED;
            return;
        }

        try {
            double weight = Double.parseDouble(weightInput.trim());
            if (weight > 60 || weight < 0.5) {
                throw new IllegalArgumentException("Digite um peso válido (Entre 0.5 a 60 kgs)!");
            }
            this.weight = String.valueOf((double) weight);
        } catch (NullPointerException e) {
            this.weight = NOT_INFORMED;
        }
    }

    public PetGender getPetGender() {
        return petGender;
    }

    public void setPetGender(PetGender petGender) {
        this.petGender = petGender;
    }

    public void setPetGenderChose(int chose) {
        switch (chose) {
            case 1:
                setPetGender(PetGender.MACHO);
                break;
            case 2:
                setPetGender(PetGender.FEMEA);
                break;
            default:
        }
    }

    public String getBreed() {
        return breed;
    }

    public void setBreed(String breed) {
        if (breed == null || breed.trim().isEmpty()) {
            this.breed = NOT_INFORMED;
            return;
        }

        this.breed = breed;
    }

    public void savePet() {
        String formatedName = getName().replace(" ", "").toUpperCase();

        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMdd'T'HHmmss");
        String formattedDateTime = localDateTime.format(dateTimeFormatter);

        File directory = new File("registeredPets");
        directory.mkdir();

        File file = new File(directory, formattedDateTime + formatedName + ".txt");
        try {
            boolean isCreated = file.createNewFile();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        try (FileWriter fw = new FileWriter(file);
             BufferedWriter bw = new BufferedWriter(fw))
        {
            bw.write("1 - " + getName());
            bw.newLine();

            bw.write("2 - " + getPetType());
            bw.newLine();

            bw.write("3 - " + getPetGender());
            bw.newLine();

            bw.write("4 - " + getAddress().getStreet() + ", " + getAddress().getHouseNumber() + ", " + getAddress().getCity());
            bw.newLine();

            bw.write("5 - " + getAge() + " anos");
            bw.newLine();

            bw.write("6 - " + getWeight() + "kg");
            bw.newLine();

            bw.write("7 - " + getBreed());
            bw.newLine();
        } catch (IOException e) {
            System.out.println("Erro ao registrar o seu pet!"  + e.getMessage());
        }

        System.out.println("Pet salvo com sucesso!");
    }
}
