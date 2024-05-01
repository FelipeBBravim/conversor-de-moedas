package modelos;

import com.google.gson.internal.bind.util.ISO8601Utils;

import java.util.Scanner;

public class Menu {
    private String menuMoedas = """
            1) Peso argentino
            2) Boliviano boliviano
            3) Real brasileiro
            4) Peso chileno
            5) Peso colombiano
            6) Dólar americano""";

    private String menu1 = """
            ****************************************
            Seja bem vindo(a) ao conversor de moedas
            
            Escolha a moeda que você quer converter:""";

    private String menu2 = """
            ****************************************
            Escolha a moeda que você quer o valor:""";

    private String menu3 = """
            ****************************************
            Qual o valor que você quer converter:""";

    private String menuFinal = """
            ****************************************
            %.2f de %s equivalem a %.2f de %s""";

    public String getMenuMoedas() {
        return menuMoedas;
    }

    public String getMenu1() {
        return menu1;
    }

    public String getMenu2() {
        return menu2;
    }

    public String getMenu3() {
        return menu3;
    }

    public void getMenuFinal(double valorInicial, String moedaInicial, double valorFinal, String moedaFinal){
        System.out.printf(menuFinal, valorInicial, moedaInicial, valorFinal, moedaFinal);
    }
}
