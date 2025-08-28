package service;

import model.Pet;
import model.PetAddress;
import repository.FileRepository;

import java.util.Scanner;

public class RegisterPet {

    public void registerPet() {
        Scanner sc = new Scanner(System.in);
        Pet pet = new Pet();
        PetAddress petAddress = new PetAddress();


        FileRepository.readSpecifyLine(1);
        String nameInput = sc.nextLine();
        pet.setName(nameInput);

        FileRepository.readSpecifyLine(2);
        String petTypeInput = sc.nextLine();
        if (petTypeInput.equalsIgnoreCase("Cachorro"))  {
            pet.setPetTypeChoose(1);
        } else if (petTypeInput.equalsIgnoreCase("Gato")) {
            pet.setPetTypeChoose(2);
        } else {
            throw new IllegalArgumentException("Escolha um tipo de pet correto!");
        }

        FileRepository.readSpecifyLine(3);
        String petGenderInput = sc.nextLine();
        if (petGenderInput.equalsIgnoreCase("Macho"))  {
            pet.setPetGenderChose(1);
        } else if (petGenderInput.equalsIgnoreCase("Femea")) {
            pet.setPetGenderChose(2);
        } else {
            throw new IllegalArgumentException("Escolha um sexo do pet existente!");
        }

        FileRepository.readSpecifyLine(4);
        System.out.print("Número da casa: ");
        String petAddressInput = sc.nextLine();
        petAddress.setHouseNumber(petAddressInput);

        System.out.print("Cidade: ");
        String petCityInput = sc.nextLine();
        petAddress.setCity(petCityInput);

        System.out.print("Rua: ");
        String petStreetInput = sc.nextLine();
        petAddress.setStreet(petStreetInput);


        FileRepository.readSpecifyLine(5);
        String petAgeInput = sc.nextLine();
        pet.setAge(petAgeInput);

        FileRepository.readSpecifyLine(6);
        String petWeightInput = sc.nextLine();
        pet.setWeight(petWeightInput);

        FileRepository.readSpecifyLine(7);
        String petBreedInput = sc.nextLine();
        pet.setBreed(petBreedInput);

        pet.setAddress(petAddress);
        pet.savePet();
    }
}
