

public class Jugador {

    // Declaración de los atributos de la clase
    private static int contadorid = 1;
    private int id;
    private String nombre;
    private String apellido;
    private int edad;


    // Propiedades de la clase

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    // Operaciones (métodos)
    // Se define el constructor de la clase
    public Jugador(String nombre, String apellido, int edad) {
        this.id = this.contadorid++;
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
    }

    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + nombre + " | Apellido: " + apellido + " | Edad: " + edad;
    }
}
