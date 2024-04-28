package conector;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conector {
    private final String ApiKey = "df912a99443df99361cc50a7";
    private String moedaInicial;
    private String moedaFinal;
    private String enderecoGet = "https://v6.exchangerate-api.com/v6/"
            + ApiKey
            + "/pair/"
            + moedaInicial
            + "/"
            + moedaFinal;


    public Conector(String moedaInicial, String moedaFinal) {
        this.moedaInicial = moedaInicial;
        this.moedaFinal = moedaFinal;
    }

    public String setConexao() throws IOException, InterruptedException {
        try {
            HttpClient client = HttpClient.newBuilder().build();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(enderecoGet))
                    .build();
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
            return response.body();
        } catch (Exception ex) {
            return "Erro de conexão.";
        }
    }
}
