import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    // Contiene la lista de jugadores
    private static ArrayList<Jugador> jugadores = new ArrayList<>();

    // Método que permite visualizar el menú del programa
    public static void generarMenu() {
        int opcion = 0;

        System.out.println("");
        System.out.println("=============  GESTIÓN DE JUGADORES ============");
        System.out.println("================================================");
        do {
            System.out.println("1. Agregar Jugador");
            System.out.println("2. Modificar Jugador");
            System.out.println("3. Eliminar Jugador");
            System.out.println("4. Buscar Jugador");
            System.out.println("5. Listar Jugadores");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");

            // Colocamos un manejador de excepciones por si ingresan alguna opción diferente a los que se esperan
            try {

                // Capturamos la opción que ingrese el usuario
                Scanner sc = new Scanner(System.in);
                opcion = sc.nextInt();

                // Validamos la opción ingresada
                switch (opcion) {
                    case 1: agregarJugador(); break;
                    case 2: modificarJugador(); break;
                    case 3: eliminarJugador(); break;
                    case 4: buscarJugador(); break;
                    case 5: listarJugadores();
                            generarMenu();
                            break;
                    case 6: System.exit(0);
                    default: System.out.println("Opcion invalida. Intente nuevamente");
                }

            } catch (Exception e) {
                System.out.println("Opcion invalida.  Intente nuevamente.");
            }

        } while (opcion != 6);

    }

    // Método que permite agregar un jugador
    private static void agregarJugador() {
        String nombre;
        String apellido;
        String edad;

        // Capturamos la información del jugador
        Scanner sc = new Scanner(System.in);
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Apellido: ");
        apellido = sc.nextLine();
        System.out.print("Edad: ");
        edad = sc.nextLine();


        try {
            // Creamos un objeto de la clase Jugador
            Jugador objJugador = new Jugador(nombre, apellido, Integer.parseInt(edad));
            // Agregamos el jugador
            jugadores.add(objJugador);
            System.out.println("Jugador agregado correctamente.");
            generarMenu();
        } catch (Exception e) {
            System.out.println("No se logró agregar el nuevo jugador.");
        }
    }

    // Método que permite modificar un jugador de acuerdo con el ID ingresado
    private static void modificarJugador() {
        // Declaramos las variables datos del jugador
        String nombre;
        String apellido;
        String edad;
        String id;

        System.out.println("=============  MODIFICAR JUGADOR ============");
        System.out.println("==========================================");
        listarJugadores();

        // Solicitamos los datos a modificar del jugador.
        System.out.println("INFO: Si no desea modificar algún dato del jugador, dejelo en blanco y presione ENTER para continuar.");
        Scanner sc = new Scanner(System.in);
        System.out.println("Ingrese el ID del jugador a modificar");
        id = sc.nextLine();
        System.out.print("Nombre: ");
        nombre = sc.nextLine();
        System.out.print("Apellido: ");
        apellido = sc.nextLine();
        System.out.print("Edad: ");
        edad = sc.nextLine();

        try {
            // Realizamos la búsqueda del jugador de acuerdo con el ID ingresado y modificamos los datos.
            for (int i = 0; i < jugadores.size(); i++) {
                if (Integer.parseInt(id) == jugadores.get(i).getId()) {

                    if (nombre != "") {
                        jugadores.get(i).setNombre(nombre);
                    }
                    if (apellido != "") {
                        jugadores.get(i).setApellido(apellido);
                    }
                    if (edad != "") {
                        jugadores.get(i).setEdad(Integer.parseInt(edad));
                    }
                }
            }
            System.out.println("El jugador ha sido modificado con exito");
            generarMenu();
        } catch (Exception e) {
            System.out.println("No se pudo modificar el jugador con el  ID:" + id);
        }
    }

    // Método que permite eliminar un jugador.  Se le solicita el ID al usuario para eliminarlo.
    private static void eliminarJugador() {
        String id;
        System.out.println("=============  ELIMINAR JUGADOR ============");
        System.out.println("============================================");
        listarJugadores();

        System.out.println("Ingrese el ID del jugador a eliminar");
        Scanner sc = new Scanner(System.in);
        id = sc.nextLine();

        try {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).getId() == Integer.parseInt(id)) {
                    jugadores.remove(i);
                }
            }
            System.out.println("El jugador ha sido eliminado con exito");
            generarMenu();
        } catch (Exception e) {
            System.out.println("No se pudo eliminar el jugador con el  ID:." + id);
        }
    }

    // Método que permite buscar un jugador de acuerdo con ID ingresado.
    private static void buscarJugador() {
        String id;
        System.out.println("=============  BUSCAR JUGADOR ============");
        System.out.println("==========================================");

        System.out.println("Ingrese el ID del jugador a buscar");
        Scanner sc = new Scanner(System.in);
        id = sc.nextLine();

        try {
            for (int i = 0; i < jugadores.size(); i++) {
                if (jugadores.get(i).getId() == Integer.parseInt(id)) {
                    System.out.println(jugadores.get(i).toString());
                }
            }
            generarMenu();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

    }

    // Método que permite listar todos los jugadores guardados en el ArrayList
    private static void listarJugadores() {
        if (jugadores == null || jugadores.isEmpty()) {
            System.out.println("No hay jugadores...");
        } else {
            for (int i = 0; i < jugadores.size(); i++) {
                System.out.println(jugadores.get(i).toString());
            }
        }
    }


    // Método del programa principal
    public static void main(String[] args) {
        generarMenu();
    }
}