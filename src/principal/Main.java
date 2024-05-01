package principal;

import conector.Conector;
import modelos.Menu;
import modelos.Moedas;

import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        Menu menu = new Menu();
        Scanner scanner = new Scanner(System.in);
        boolean rev = false;
        int mI = 0, mF = 0;

        while (!rev) {
            System.out.println(menu.getMenu1());
            System.out.println(menu.getMenuMoedas());
            mI = scanner.nextInt();
            if (String.valueOf(mI).matches("[1-6]")) {
                rev = true;
            } else {
                System.out.println("Digite uma opção válida.");
            }
        }

        rev = false;

        while (!rev) {
            System.out.println(menu.getMenu2());
            System.out.println(menu.getMenuMoedas());
            mF = scanner.nextInt();
            if (String.valueOf(mF).matches("[1-6]")) {
                rev = true;
            } else {
                System.out.println("Digite uma opção válida.");
            }
        }

        System.out.println(menu.getMenu3());
        double valor = scanner.nextDouble();

        Moedas moedas = new Moedas(String.valueOf(mI), String.valueOf(mF), valor);
        moedas.definindoMoedaInicial(moedas.getMoedaInicial());
        moedas.definindoMoedaFinal(moedas.getMoedaFinal());

        menu.getMenuFinal(moedas.getValorInicial(), moedas.getMoedaInicial(), moedas.getValorFinal(), moedas.getMoedaFinal());

    }
}