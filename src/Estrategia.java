import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class Estrategia {
    public String currencyCodeEntrada;
    public String currencyCodeSalida;

    public String getCurrencyCodeEntrada() {
        return currencyCodeEntrada;
    }

    public void setCurrencyCodeEntrada(String currencyCodeEntrada) {
        this.currencyCodeEntrada = currencyCodeEntrada;
    }

    public String getCurrencyCodeSalida() {
        return currencyCodeSalida;
    }

    public void setCurrencyCodeSalida(String currencyCodeSalida) {
        this.currencyCodeSalida = currencyCodeSalida;
    }

    public Estrategia(String currencyCodeEntrada, String currencyCodeSalida) {
        this.currencyCodeEntrada = currencyCodeEntrada;
        this.currencyCodeSalida = currencyCodeSalida;
    }

    public void buscarMoneda(Double monto) throws IOException, InterruptedException {
        // Quien lo pide.
        HttpClient cliente = HttpClient.newHttpClient();

        // A quien se lo pidio
        String url = "https://v6.exchangerate-api.com/v6/51c0badd713ebdce26143617/pair/"
                +this.currencyCodeEntrada+"/"
                +this.currencyCodeSalida+"/"
                +monto;

        // Lo que se pide
        HttpRequest pedido = HttpRequest.newBuilder()
                .uri(URI.create(url))
                .build();

        // La respuesta del pedido
        HttpResponse<String> respuesta = null;
        respuesta = cliente.send(pedido, HttpResponse.BodyHandlers.ofString());

        String json = respuesta.body();
        System.out.println(json);
    }

}
