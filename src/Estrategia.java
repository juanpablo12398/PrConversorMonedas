import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        // System.out.println(respuesta.body());
        Resultado resultado = new Gson().fromJson(respuesta.body(),Resultado.class);
        // System.out.println(resultado);
        ClaseResultado resultadoFinal = new ClaseResultado(resultado);
        System.out.println(resultadoFinal);

    }

}
