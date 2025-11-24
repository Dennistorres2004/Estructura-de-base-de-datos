// Menú principal del sistema bancario
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Banco banco = new Banco();
        Scanner sc = new Scanner(System.in);

        while (true) {
            Utils.linea();
            System.out.println(" SISTEMA BANCARIO ");
            Utils.linea();
            System.out.println("1. Crear cuenta");
            System.out.println("2. Depositar");
            System.out.println("3. Retirar");
            System.out.println("4. Transferir");
            System.out.println("5. Buscar cuenta");
            System.out.println("6. Listar cuentas");
            System.out.println("7. Ordenar por saldo");
            System.out.println("8. Ver transacciones");
            System.out.println("0. Salir");
            System.out.print("Opción: ");

            int op = sc.nextInt();
            sc.nextLine();

            switch (op) {

                case 1:
                    System.out.print("Titular: ");
                    String titular = sc.nextLine();
                    System.out.print("Tipo: ");
                    String tipo = sc.nextLine();
                    System.out.print("Saldo inicial: ");
                    double saldo = sc.nextDouble();
                    System.out.println("Cuenta creada: " + banco.crearCuenta(titular, tipo, saldo));
                    break;

                case 2:
                    System.out.print("Número de cuenta: ");
                    String nc1 = sc.nextLine();
                    System.out.print("Monto: ");
                    double m1 = sc.nextDouble();
                    System.out.println(banco.depositar(nc1, m1) ? "Depósito exitoso" : "Error");
                    break;

                case 3:
                    System.out.print("Número de cuenta: ");
                    String nc2 = sc.nextLine();
                    System.out.print("Monto: ");
                    double m2 = sc.nextDouble();
                    System.out.println(banco.retirar(nc2, m2) ? "Retiro exitoso" : "Error");
                    break;

                case 4:
                    System.out.print("Cuenta origen: ");
                    String o = sc.nextLine();
                    System.out.print("Cuenta destino: ");
                    String d = sc.nextLine();
                    System.out.print("Monto: ");
                    double mt = sc.nextDouble();
                    System.out.println(banco.transferir(o, d, mt) ? "Transferencia exitosa" : "Error");
                    break;

                case 5:
                    System.out.print("Número de cuenta: ");
                    String nb = sc.nextLine();
                    Cuenta encontrada = banco.buscarCuenta(nb);
                    System.out.println(encontrada != null ? encontrada : "No existe");
                    break;

                case 6:
                    for (Cuenta cu : BancoStorage.cuentas) System.out.println(cu);
                    break;

                case 7:
                    for (Cuenta cu : banco.ordenarPorSaldo()) System.out.println(cu);
                    break;

                case 8:
                    for (Transaccion t : BancoStorage.transacciones) System.out.println(t);
                    break;

                case 0:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción inválida");
            }
        }
    }
}
