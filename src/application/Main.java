package application;

import service.PrintMenu;
import service.RegisterPet;

public class Main {
    public static void main(String[] args) {
        PrintMenu printMenu = new PrintMenu();
        int option = printMenu.printMainMenu();
        RegisterPet registerPet = new RegisterPet();

        while (option != 6) {
            switch (option) {
                case 1:
                    registerPet.registerPet();
                    break;
                case 2:
                    System.out.println("Alterar os dados do pet cadastrado");
                    break;
                case 3:
                    System.out.println("Deletar um pet cadastrado");
                    break;
                case 4:
                    System.out.println("Listar todos os pets cadastrados");
                    break;
                case 5:
                    System.out.println("Listar pets por algum critério (idade, nome, raça)");
                    break;
                default:
                    System.out.println("Opção inválida, tente novamente.");
            }
            option = printMenu.printMainMenu();
        }
    }
}