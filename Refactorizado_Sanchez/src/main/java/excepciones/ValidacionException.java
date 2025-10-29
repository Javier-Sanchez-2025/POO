package excepciones;

/**
 * Excepción personalizada para validaciones de dominio del sistema
 */
public class ValidacionException extends Exception {

    /**
     * Constructor que recibe un mensaje descriptivo del error
     *
     * @param mensaje Descripción del error de validación
     */
    public ValidacionException(String mensaje) {
        super(mensaje);
    }
}
