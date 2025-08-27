package service;

import java.util.Scanner;

public class PrintMenu {
    public int printMainMenu() {
        Scanner sc = new Scanner(System.in);
        System.out.println("1. Cadastrar um novo pet");
        System.out.println("2. Listar pets por algum critério (idade, nome, raça)");
        System.out.println("3. Deletar um pet cadastrado");
        System.out.println("4. Listar todos os pets cadastrados");
        System.out.println("5. Alterar os dados do pet cadastrados");
        System.out.println("6. Sair");
        int chose = readNumberInRange(sc);
        return chose;
    }

    public static int readNumberInRange(Scanner sc) {
        while (true) {
            System.out.print("Digite um número de 1 a 6: ");

            if (sc.hasNextInt()) {
                int num = sc.nextInt();
                sc.nextLine();
                if (num >= 1 && num <= 6) {
                    return num;
                } else {
                    System.out.println("Número fora do intervalo. Tente novamente.");
                }
            } else {
                System.out.println("Entrada inválida. Digite apenas números.");
                sc.nextLine();
            }
        }

    }
}
