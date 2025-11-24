import java.util.*;

public class GestorTareas {
    private Stack<Tarea> pilaPrioritaria;
    private Queue<Tarea> colaEspera;
    private Map<String, String> mapaTrazabilidad;

    public GestorTareas() {
        pilaPrioritaria = new Stack<>();
        colaEspera = new LinkedList<>();
        mapaTrazabilidad = new HashMap<>();
    }

    // Agregar tarea
    public void agregarTarea(Tarea tarea) {
        if (tarea.getPrioridad() == 3) {
            pilaPrioritaria.push(tarea);
        } else {
            colaEspera.offer(tarea);
        }
    }

    // Procesar tarea
    public Tarea procesarSiguienteTarea() {
        Tarea tareaProcesada = null;
        long tiempoProcesado = System.currentTimeMillis();

        if (!pilaPrioritaria.isEmpty()) {
            tareaProcesada = pilaPrioritaria.pop();
        } else if (!colaEspera.isEmpty()) {
            tareaProcesada = colaEspera.poll();
        } else {
            return null;
        }

        long tiempoLlegada = tareaProcesada.getTiempoLlegada();
        long duracion = tiempoProcesado - tiempoLlegada;

        String detalle = String.format(
            "Completada | llegada=%d | procesado=%d | duracionMs=%d",
            tiempoLlegada, tiempoProcesado, duracion
        );

        mapaTrazabilidad.put(tareaProcesada.getId(), detalle);
        return tareaProcesada;
    }

    // Consultar estado
    public String consultarEstadoTarea(String idTarea) {
        if (mapaTrazabilidad.containsKey(idTarea)) {
            return "Completada (" + mapaTrazabilidad.get(idTarea) + ")";
        }
        for (Tarea t : pilaPrioritaria) {
            if (t.getId().equals(idTarea)) {
                return "Pendiente (Alta prioridad)";
            }
        }
        for (Tarea t : colaEspera) {
            if (t.getId().equals(idTarea)) {
                return "Pendiente (Normal)";
            }
        }
        return "No encontrada";
    }

    // Métodos auxiliares
    public int tamañoPila() { return pilaPrioritaria.size(); }
    public int tamañoCola() { return colaEspera.size(); }

}