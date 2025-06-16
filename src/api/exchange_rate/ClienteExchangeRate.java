package api.exchange_rate;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;

public class ClienteExchangeRate {
    public static final String url = "https://v6.exchangerate-api.com/v6/57ff1807b853cef3166f3ef5/latest/USD";

    public String consultarApiExchangeRate() {

        try {
            //Construyendo cliente para consumir
            HttpClient client = HttpClient.newHttpClient();
            //Construyendo solicitud
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(url))
                    .build();

            //Construyendo respuesta
            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());

            return response.body();

        } catch (Exception e) {
            System.out.println("Ocurrio un error al consultar el servicio.");
            System.out.println(e.getMessage());
        }

        return null;
    }
}
