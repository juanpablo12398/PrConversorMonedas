import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.HashMap;

public class BusquedaMoneda {
    public HashMap<Number, Estrategia> estrategiasDisponibles = new HashMap<>();
    // currencyCode determina de que moneda estoy hablando. Para pasar a otra.
    public void buscarMoneda(Number numeroDeBusqueda, Double monto) throws IOException, InterruptedException {
        estrategiasDisponibles.get(numeroDeBusqueda).buscarMoneda(monto);
    }

    public HashMap<Number, Estrategia> getEstrategiasDisponibles() {
        return estrategiasDisponibles;
    }

    public void setEstrategiasDisponibles(HashMap<Number, Estrategia> estrategiasDisponibles) {
        this.estrategiasDisponibles = estrategiasDisponibles;
    }
}
