package modelos;

import com.google.gson.Gson;
import conector.Conector;

import java.io.IOException;

public class Moedas {
    private String moedaInicial;
    private double valorInicial;
    private String moedaFinal;
    private double valorFinal;

    public Moedas(String moedaInicial, double valorInicial, String moedaFinal, double valorFinal) {
        this.moedaInicial = moedaInicial;
        this.valorInicial = valorInicial;
        this.moedaFinal = moedaFinal;
        this.valorFinal = valorFinal;
    }

    public String converter() throws IOException, InterruptedException {
        Conector conector = new Conector(moedaInicial, moedaFinal);
        Gson gson = new Gson();
        double cotacao = gson.fromJson(conector.setConexao(), Cotacao.class).conversion_rate();
        valorFinal = valorInicial * cotacao;
        return String.valueOf(valorFinal);
    }
}
