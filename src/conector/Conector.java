package conector;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Conector {
    private String ApiKey = "df912a99443df99361cc50a7";
    private String enderecoGet;

    public Conector(){
        this.enderecoGet = "https://v6.exchangerate-api.com/v6/%s/codes"
                .formatted(ApiKey);
    }

    public Conector(String moedaInicial, String moedaFinal) {
        this.enderecoGet = "https://v6.exchangerate-api.com/v6/%s/pair/%s/%s"
                .formatted(ApiKey, moedaInicial, moedaFinal);
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
