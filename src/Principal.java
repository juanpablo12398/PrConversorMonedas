import java.io.IOException;
import java.util.Objects;
import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        BusquedaMoneda busquedaMoneda = new BusquedaMoneda();
        CreadorEstrategias creadorEstrategias = new CreadorEstrategias();
        busquedaMoneda.setEstrategiasDisponibles(creadorEstrategias.crearEstrategias());
        Menu menu = new Menu();
        Scanner lectura = new Scanner(System.in);

        while (true){
            menu.mostrarMenu();
            String opcionElegida = lectura.nextLine();

            if (Objects.equals(opcionElegida, "7")){
                break;
            }

            System.out.println("Ingrese el valor que desea convertir");
            String monto = lectura.nextLine();

            Number valorDeBusqueda = Integer.valueOf(opcionElegida);
            Double montoACambiar = Double.valueOf(monto);

            try {
                busquedaMoneda.buscarMoneda(valorDeBusqueda,montoACambiar);
            } catch (IOException | InterruptedException e) {
                System.out.println("Se genero un problema");
            } finally {
                System.out.println("Finalizo el programa");
            }
        }

    }
}
