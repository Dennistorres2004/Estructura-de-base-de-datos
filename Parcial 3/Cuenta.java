// Clase que representa una cuenta bancaria
public class Cuenta {
    private String numero;
    private String titular;
    private String tipo;
    private double saldo;

    public Cuenta(String numero, String titular, String tipo, double saldoInicial) {
        this.numero = numero;
        this.titular = titular;
        this.tipo = tipo;
        this.saldo = saldoInicial;
    }

    public String getNumero() { return numero; }
    public String getTitular() { return titular; }
    public String getTipo() { return tipo; }
    public double getSaldo() { return saldo; }

    public void depositar(double monto) {
        saldo += monto;
    }

    public boolean retirar(double monto) {
        if (monto > saldo) return false;
        saldo -= monto;
        return true;
    }

    @Override
    public String toString() {
        return numero + " | " + titular + " | " + tipo + " | Saldo: $" + saldo;
    }
}
