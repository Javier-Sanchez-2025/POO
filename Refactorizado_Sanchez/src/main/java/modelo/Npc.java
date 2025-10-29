package modelo;

/**
 * Clase base que representa un Personaje No Jugable (NPC) en el sistema
 */
import excepciones.ValidacionException;

public class Npc {

    // Atributos privados con encapsulamiento
    private String nombre;
    private int edad;
    private String pueblo;
    private boolean esAmigable;

    // Atributo estático para contar instancias
    private static int contadorNpcs = 0;

    /**
     * Constructor por defecto
     */
    public Npc() {
        this.nombre = "Desconocido";
        this.edad = 0;
        this.pueblo = "Sin pueblo";
        this.esAmigable = true;
        contadorNpcs++; // Incrementa el contador al crear una instancia
    }

    /**
     * Constructor con parámetros
     *
     * @param nombre Nombre del NPC
     * @param edad Edad del NPC
     * @param pueblo Pueblo de origen del NPC
     * @param esAmigable Indica si el NPC es amigable
     * @throws ValidacionException Si los datos no son válidos
     */
    public Npc(String nombre, int edad, String pueblo, boolean esAmigable) throws ValidacionException {
        setNombre(nombre);
        setEdad(edad);
        setPueblo(pueblo);
        this.esAmigable = esAmigable;
        contadorNpcs++;
    }

    // Getters y Setters públicos
    public String getNombre() {
        return nombre;
    }

    /**
     * Establece el nombre del NPC con validación
     *
     * @param nombre Nombre del NPC
     * @throws IllegalArgumentException Si el nombre es nulo o vacío
     */
    public void setNombre(String nombre) {
        if (nombre == null || nombre.trim().isEmpty()) {
            throw new IllegalArgumentException("El nombre no puede estar vacio");
        }
        this.nombre = nombre.trim();
    }

    public int getEdad() {
        return edad;
    }

    /**
     * Establece la edad del NPC con validación
     *
     * @param edad Edad del NPC
     * @throws ValidacionException Si la edad no es válida
     */
    public void setEdad(int edad) throws ValidacionException {
        if (edad < 0 || edad > 100) {
            throw new ValidacionException("La edad debe estar entre 0 y 100 anios");
        }
        this.edad = edad;
    }

    public String getPueblo() {
        return pueblo;
    }

    /**
     * Establece el pueblo del NPC con validación
     *
     * @param pueblo Pueblo del NPC
     * @throws IllegalArgumentException Si el pueblo es nulo o vacío
     */
    public void setPueblo(String pueblo) {
        if (pueblo == null || pueblo.trim().isEmpty()) {
            throw new IllegalArgumentException("El pueblo no puede estar vacio");
        }
        this.pueblo = pueblo.trim();
    }

    public boolean isEsAmigable() {
        return esAmigable;
    }

    public void setEsAmigable(boolean esAmigable) {
        this.esAmigable = esAmigable;
    }

    /**
     * Método estático para obtener el contador de NPCs creados
     *
     * @return Número total de NPCs creados
     */
    public static int getContadorNpcs() {
        return contadorNpcs;
    }

    /**
     * Método protegido que genera un ID interno para el NPC Solo visible para
     * las clases hijas
     *
     * @return ID interno generado
     */
    protected String generarIDInterno() {
        return "NPC " + this.nombre.substring(0, Math.min(3, this.nombre.length())).toUpperCase() + "_" + this.edad;
    }

    /**
     * Saludo estándar del NPC
     */
    public void saludar() {
        System.out.println("Mucho gusto explorador yo soy " + nombre + " del pueblo " + pueblo);
    }
}
