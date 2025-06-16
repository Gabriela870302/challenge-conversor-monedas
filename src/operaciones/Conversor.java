package operaciones;

import api.exchange_rate.ClienteExchangeRate;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class Conversor {

    public double convertirMonto(int opcion, double monto) {
        String moneda = obtenerTipoMoneda(opcion);
        double tasa = obtenerTasa(moneda);

        return monto * tasa;
    }

    private String obtenerTipoMoneda(int opcion) {
        switch (opcion) {
            case 1:
                return "ARS";
            case 2:
                return "BOB";
            case 3:
                return "BRL";
            case 4:
                return "CAD";
            case 5:
                return "CUP";
            case 6:
                return "MXN";
            default:
                return "";
        }
    }

    private double obtenerTasa(String moneda) {
        JsonParser parser = new JsonParser();
        Conversor conversor = new Conversor();
        ClienteExchangeRate clienteExchangeRate = new ClienteExchangeRate();

        //Analizando respuesta Json
        String response = clienteExchangeRate.consultarApiExchangeRate();
        JsonElement jsonElement = JsonParser.parseString(response);
        JsonObject jsonObject = jsonElement.getAsJsonObject();

        //Filtrado las monedas
        double tasa = jsonObject.get("conversion_rates").getAsJsonObject().get(moneda).getAsDouble();

        return tasa;
    }
}
