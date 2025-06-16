import operaciones.Conversor;

import java.util.Scanner;

public class App {

    public static void mostrarMenu(){
        System.out.println("""
                ****************************************
                Binvenido al conversor de monedas
                Menu:
                1.Dolar (USD) a Peso Argentino (ARS).                 
                2.Dolar (USD) a Bolivares (BOB).                
                3.Dolar (USD) a Real brasileño (BRL).
                4.Dolar (USD) a Dolar Candiense (CAD).
                5.Dolar (USD) a Peso Cubano (CUP).
                6.Dolar (USD) a Peso Mexicano (MXN).
                7.Salir               
                ***************************************
                """);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Conversor conversor = new Conversor();

        mostrarMenu();
        System.out.println("Elija una opcion valida:");
        int opcion = scanner.nextInt();

        //Asegurando una opcion valida
        while(opcion > 7 || opcion < 1){
            System.out.println("Opcion invalida elija una numero del menú:");
            opcion = scanner.nextInt();
        }

        if(opcion != 7){
            System.out.println("Ingrese el monto:");
            double monto = scanner.nextDouble();

            double montoConvertido = conversor.convertirMonto(opcion, monto);
            System.out.println("El monto convertido es: " + montoConvertido);
        } else {
            System.out.println("Saliendo de la aplicacion ...");
        }
    }
}
