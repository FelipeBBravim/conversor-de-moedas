package principal;

import modelos.Menu;
import modelos.Moedas;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        int opcao = 1;

        while (opcao == 1) {
            Menu menu = new Menu();
            Scanner scanner = new Scanner(System.in);
            boolean rev = false;
            int mI = 0, mF = 0;
            double valor = 0;

            while (!rev) {
                System.out.println(menu.getMenu1());
                System.out.println(menu.getMenuMoedas());
                try {
                    mI = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Por favor, digite um número dentre as opções válidas.");
                    mI = 0;
                }

                System.out.println(menu.getMenu2());
                System.out.println(menu.getMenuMoedas());
                try {
                    mF = scanner.nextInt();
                } catch (InputMismatchException ex) {
                    System.out.println("Por favor, digite um número dentre as opções válidas.");
                    mF = 0;
                }

                System.out.println(menu.getMenu3());
                try {
                    valor = scanner.nextDouble();
                } catch (InputMismatchException | NumberFormatException ex) {
                    System.out.println("Por favor, digite um valor válido.");
                }

                if (conferindo(mI) && conferindo(mF)) {
                    rev = true;
                } else {
                    System.out.println("Escolha uma moeda válida");
                }
            }

            Moedas moedas = new Moedas(String.valueOf(mI), String.valueOf(mF), valor);
            moedas.definindoMoedaInicial(moedas.getMoedaInicial());
            moedas.definindoMoedaFinal(moedas.getMoedaFinal());

            System.out.println(menu.getMenu4(moedas.getValorInicial(),
                    moedas.getMoedaInicial(),
                    moedas.getValorFinal(),
                    moedas.getMoedaFinal()));

            System.out.println(menu.getMenuFinal());
            try{
                opcao = scanner.nextInt();
            } catch (Exception ex) {
                System.out.println("Digite um valor válido");
            }
        }

        System.out.println("Obrigado por conhecer o meu conversor de moeda.");
        System.out.println("Desenvolvido por: Felipe Bravim");
    }

    private static boolean conferindo(int a) {
        if (String.valueOf(a).matches("[1-6]")) {;
            return true;
        } else {
            return false;
        }
    }
}