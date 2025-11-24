// Implementación real del algoritmo MergeSort aplicado a cuentas
import java.util.ArrayList;

public class MergeSort {

    // Recibe una lista y devuelve una ordenada por saldo
    public static ArrayList<Cuenta> ordenar(ArrayList<Cuenta> lista) {
        if (lista.size() <= 1) return lista;

        int mitad = lista.size() / 2;

        ArrayList<Cuenta> izquierda = new ArrayList<>(lista.subList(0, mitad));
        ArrayList<Cuenta> derecha = new ArrayList<>(lista.subList(mitad, lista.size()));

        izquierda = ordenar(izquierda);
        derecha = ordenar(derecha);

        return mezclar(izquierda, derecha);
    }

    private static ArrayList<Cuenta> mezclar(ArrayList<Cuenta> a, ArrayList<Cuenta> b) {
        ArrayList<Cuenta> resultado = new ArrayList<>();
        int i = 0, j = 0;

        while (i < a.size() && j < b.size()) {
            if (a.get(i).getSaldo() <= b.get(j).getSaldo()) {
                resultado.add(a.get(i));
                i++;
            } else {
                resultado.add(b.get(j));
                j++;
            }
        }

        while (i < a.size()) resultado.add(a.get(i++));
        while (j < b.size()) resultado.add(b.get(j++));

        return resultado;
    }
}
