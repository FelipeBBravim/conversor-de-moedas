package modelos;

import com.google.gson.Gson;
import conector.Conector;
import persistenciaDeDados.Cotacao;

import java.io.IOException;

public class Moedas {
    private String moedaInicial;
    private double valorInicial;
    private String moedaFinal;
    private double valorFinal;

    public Moedas(String moedaInicial, String moedaFinal, double valorInicial) {
        this.moedaInicial = moedaInicial;
        this.moedaFinal = moedaFinal;
        this.valorInicial = valorInicial;
    }

    public String getMoedaInicial() {
        return moedaInicial;
    }

    public double getValorInicial() {
        return valorInicial;
    }

    public String getMoedaFinal() {
        return moedaFinal;
    }

    public double getValorFinal() throws IOException, InterruptedException {
        Conector conector = new Conector(this.moedaInicial,this.moedaFinal);
        Gson gson = new Gson();
        double cotacao = gson.fromJson(conector.setConexao(), Cotacao.class).conversion_rate();
        this.valorFinal = valorInicial * cotacao;
        return this.valorFinal;
    }

    public void definindoMoedaInicial(String moeda){
        switch (moeda){
            case "1" -> this.moedaInicial = "ARS";
            case "2" -> this.moedaInicial = "BOB";
            case "3" -> this.moedaInicial = "BRL";
            case "4" -> this.moedaInicial = "CLP";
            case "5" -> this.moedaInicial = "COP";
            case "6" -> this.moedaInicial = "USD";
        }
    }

    public void definindoMoedaFinal(String moeda){
        switch (moeda){
            case "1" -> this.moedaFinal = "ARS";
            case "2" -> this.moedaFinal = "BOB";
            case "3" -> this.moedaFinal = "BRL";
            case "4" -> this.moedaFinal = "CLP";
            case "5" -> this.moedaFinal = "COP";
            case "6" -> this.moedaFinal = "USD";
        }
    }
}
