// Implementación real de búsqueda binaria por número de cuenta
import java.util.ArrayList;

public class BinarySearch {

    public static Cuenta buscar(ArrayList<Cuenta> listaOrdenada, String numero) {
        int izquierda = 0;
        int derecha = listaOrdenada.size() - 1;

        while (izquierda <= derecha) {
            int mid = (izquierda + derecha) / 2;
            Cuenta c = listaOrdenada.get(mid);

            int comparacion = c.getNumero().compareTo(numero);

            if (comparacion == 0) return c;
            if (comparacion < 0) izquierda = mid + 1;
            else derecha = mid - 1;
        }

        return null;
    }
}
