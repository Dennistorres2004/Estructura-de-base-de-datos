// Clase principal que contiene toda la lógica del sistema bancario
import java.util.ArrayList;

public class Banco {

    public Cuenta crearCuenta(String titular, String tipo, double saldoInicial) {
        String numero = Utils.generarNumeroCuenta();
        Cuenta nueva = new Cuenta(numero, titular, tipo, saldoInicial);
        BancoStorage.cuentas.add(nueva);
        return nueva;
    }

    // Búsqueda usando BinarySearch
    public Cuenta buscarCuenta(String numero) {
        ArrayList<Cuenta> ordenadas = ordenarPorNumero();
        return BinarySearch.buscar(ordenadas, numero);
    }

    // Ordenar por número (necesario para BinarySearch)
    public ArrayList<Cuenta> ordenarPorNumero() {
        ArrayList<Cuenta> copia = new ArrayList<>(BancoStorage.cuentas);
        copia.sort((a, b) -> a.getNumero().compareTo(b.getNumero()));
        return copia;
    }

    // Depósito
    public boolean depositar(String numero, double monto) {
        Cuenta c = buscarCuenta(numero);
        if (c == null) return false;

        c.depositar(monto);
        BancoStorage.transacciones.add(new Transaccion("Depósito a " + numero + ": $" + monto));
        return true;
    }

    // Retiro
    public boolean retirar(String numero, double monto) {
        Cuenta c = buscarCuenta(numero);
        if (c == null || !c.retirar(monto)) return false;

        BancoStorage.transacciones.add(new Transaccion("Retiro de " + numero + ": $" + monto));
        return true;
    }

    // Transferencia
    public boolean transferir(String origen, String destino, double monto) {
        Cuenta o = buscarCuenta(origen);
        Cuenta d = buscarCuenta(destino);

        if (o == null || d == null || !o.retirar(monto)) return false;

        d.depositar(monto);
        BancoStorage.transacciones.add(
            new Transaccion("Transferencia: $" + monto + " de " + origen + " a " + destino)
        );
        return true;
    }

    // Ordenar por saldo usando MergeSort
    public ArrayList<Cuenta> ordenarPorSaldo() {
        return MergeSort.ordenar(new ArrayList<>(BancoStorage.cuentas));
    }
}
