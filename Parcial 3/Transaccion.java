// Clase que registra cualquier operación realizada en el banco
public class Transaccion {
    private String detalle;

    public Transaccion(String detalle) {
        this.detalle = detalle;
    }

    public String toString() {
        return detalle;
    }
}
