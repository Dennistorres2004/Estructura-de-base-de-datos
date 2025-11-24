public class EjecutarAreglos {
    public static void main(String[] args){

        EjecutarAreglos objOp = new EjecutarAreglos();

        //Llenar el arreglo

        int[] x = objOp.llenarArregloEnteros(3);

        //Mostrar el arreglo

        objOp.mostrarArregloEnteros(x);

        System.out.println(objOp.promedioArregloEnteros(x));


    }
}