public class Tarea {
    private String id;
    private String descripcion;
    private int prioridad; // 1 baja, 2 media, 3 alta
    private long tiempoLlegada;

    public Tarea(String id, String descripcion, int prioridad) {
        this.id = id;
        this.descripcion = descripcion;
        this.prioridad = prioridad;
        this.tiempoLlegada = System.currentTimeMillis();
    }

    public String getId() { return id; }
    public String getDescripcion() { return descripcion; }
    public int getPrioridad() { return prioridad; }
    public long getTiempoLlegada() { return tiempoLlegada; }

    @Override
    public String toString() {
        return String.format("Tarea{id='%s', desc='%s', prioridad=%d}", id, descripcion, prioridad);
    }
}
