package modelo;

/**
 * Clase que representa un Aldeano en el sistema, hereda de Npc
 */
import excepciones.ValidacionException;

public class Aldeano extends Npc {

    // Atributos propios del Aldeano
    private String profesion;
    private boolean tieneHogar;
    private String dialogoFavorito;

    /**
     * Constructor por defecto
     */
    public Aldeano() {
        super();
        this.profesion = "Cartografo";
        this.tieneHogar = true;
        this.dialogoFavorito = "Buen dia";
    }

    /**
     * Constructor con parámetros
     *
     * @param nombre Nombre del aldeano
     * @param edad Edad del aldeano
     * @param pueblo Pueblo del aldeano
     * @param esAmigable Indica si el aldeano es amigable
     * @param profesion Profesión del aldeano
     * @param tieneHogar Indica si el aldeano tiene hogar
     * @param dialogoFavorito Diálogo favorito del aldeano
     * @throws ValidacionException Si los datos no son válidos
     */
    public Aldeano(String nombre, int edad, String pueblo, boolean esAmigable,
            String profesion, boolean tieneHogar, String dialogoFavorito) throws ValidacionException {
        super(nombre, edad, pueblo, esAmigable);
        setProfesion(profesion);
        this.tieneHogar = tieneHogar;
        setDialogoFavorito(dialogoFavorito);

        // Uso del método protegido de la clase padre
        String idInterno = generarIDInterno();
        System.out.println("ID interno generado para aldeano: " + idInterno);
    }

    public String getProfesion() {
        return profesion;
    }

    /**
     * Establece la profesión del aldeano con validación
     *
     * @param profesion Profesión del aldeano
     * @throws IllegalArgumentException Si la profesión es nula o vacía
     */
    public void setProfesion(String profesion) {
        if (profesion == null || profesion.trim().isEmpty()) {
            throw new IllegalArgumentException("La profesion no puede estar vacia");
        }
        this.profesion = profesion.trim();
    }

    public boolean getTieneHogar() {
        return tieneHogar;
    }

    public void setTieneHogar(boolean tieneHogar) {
        this.tieneHogar = tieneHogar;
    }

    public String getDialogoFavorito() {
        return dialogoFavorito;
    }

    /**
     * Establece el diálogo favorito con validación
     *
     * @param dialogoFavorito Diálogo favorito del aldeano
     * @throws IllegalArgumentException Si el diálogo es nulo o vacío
     */
    public void setDialogoFavorito(String dialogoFavorito) {
        if (dialogoFavorito == null || dialogoFavorito.trim().isEmpty()) {
            throw new IllegalArgumentException("El dialogo favorito no puede estar vacio");
        }
        this.dialogoFavorito = dialogoFavorito.trim();
    }

    /**
     * Simula el trabajo del aldeano
     */
    public void trabajar() {
        System.out.println(getNombre() + " esta trabajando como " + profesion);
    }

    /**
     * Simula una conversación del aldeano
     */
    public void conversar() {
        System.out.println(getNombre() + " dice: \"" + dialogoFavorito + "\"");
    }
}
