package modelos;

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
            
            Escolha a moeda que você quer converter:
            ----------------------------------------""";

    private String menu2 = """
            ****************************************
            Escolha a moeda que você quer o valor:
            ----------------------------------------""";

    private String menu3 = """
            ****************************************
            Qual o valor que você quer converter:
            ----------------------------------------""";

    private String menu4 = """
            ****************************************
            %.2f de %s equivalem a %.2f de %s.
            ****************************************""";

    private String menuFinal = """
            ****************************************
            Escolha 1 para uma nova conversão ou 0 para sair.""";

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
        System.out.printf(menu4, valorInicial, moedaInicial, valorFinal, moedaFinal);
    }
}
