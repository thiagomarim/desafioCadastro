package application;

import java.util.Scanner;

public class MenuInicial {
    public static void main(String[] args) {
        MenuInicial();
    }

    public static void MenuInicial() {
        Scanner sc = new Scanner(System.in);
        int escolha = 0;

        do {
            System.out.println("1. Cadastrar um novo pet");
            System.out.println("2. Alterar os dados do pet cadastrado");
            System.out.println("3. Deletar um pet cadastrado");
            System.out.println("4. Listar todos os pets cadastrados");
            System.out.println("5. Listar pets por algum critério (idade, nome, raça)");
            System.out.println("6. Sair");
            System.out.print("Escolha uma opção: ");

            if (sc.hasNextInt()) {
                escolha = sc.nextInt();

                if (escolha >= 1 && escolha <= 6) {
                    switch (escolha) {
                        case 1:
                            System.out.println("Função de Cadastrar um novo pet");
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
                        case 6:
                            System.out.println("Sair");
                            break;
                    }
                } else {
                    System.out.println("Selecione uma opção válida!");
                }
            } else {
                System.out.println("Entrada inválida! Digite apenas números.");
                sc.next();
            }

            System.out.println();
        } while (escolha != 6);

        sc.close();
    }
}
