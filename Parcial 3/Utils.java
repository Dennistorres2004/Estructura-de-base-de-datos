// Clase de utilidades generales
public class Utils {

    // Generador de número único para cuentas
    public static String generarNumeroCuenta() {
        return "ACC" + (int)(Math.random() * 900000 + 100000);
    }

    public static void linea() {
        System.out.println("-------------------------------------");
    }
}
