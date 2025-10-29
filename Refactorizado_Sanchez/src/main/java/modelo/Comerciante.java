package modelo;

import excepciones.ValidacionException;

/**
 * Clase que representa un Comerciante en el sistema, hereda de Npc
 */
public class Comerciante extends Npc {

    // Atributos únicos del comerciante
    private String tipoMercancia;
    private double precioBase;
    private int nivelReputacion;

    /**
     * Constructor por defecto
     */
    public Comerciante() {
        super();
        this.tipoMercancia = "Variado";
        this.precioBase = 10.0;
        this.nivelReputacion = 1;
    }

    /**
     * Constructor con parámetros
     *
     * @param nombre Nombre del comerciante
     * @param edad Edad del comerciante
     * @param pueblo Pueblo del comerciante
     * @param esAmigable Indica si el comerciante es amigable
     * @param tipoMercancia Tipo de mercancía que vende
     * @param precioBase Precio base de la mercancía
     * @param nivelReputacion Nivel de reputación del comerciante
     * @throws ValidacionException Si los datos no son válidos
     */
    public Comerciante(String nombre, int edad, String pueblo, boolean esAmigable,
            String tipoMercancia, double precioBase, int nivelReputacion) throws ValidacionException {
        super(nombre, edad, pueblo, esAmigable);
        setTipoMercancia(tipoMercancia);
        setPrecioBase(precioBase);
        setNivelReputacion(nivelReputacion);

        // Uso del método protegido de la clase padre
        String idInterno = generarIDInterno();
        System.out.println("ID interno generado para comerciante: " + idInterno);
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    /**
     * Establece el tipo de mercancía con validación
     *
     * @param tipoMercancia Tipo de mercancía
     * @throws IllegalArgumentException Si el tipo de mercancía es nulo o vacío
     */
    public void setTipoMercancia(String tipoMercancia) {
        if (tipoMercancia == null || tipoMercancia.trim().isEmpty()) {
            throw new IllegalArgumentException("El tipo de mercancia no puede estar vacio");
        }
        this.tipoMercancia = tipoMercancia.trim();
    }

    public double getPrecioBase() {
        return precioBase;
    }

    /**
     * Establece el precio base con validación
     *
     * @param precioBase Precio base de la mercancía
     * @throws ValidacionException Si el precio no es válido
     */
    public void setPrecioBase(double precioBase) throws ValidacionException {
        if (precioBase <= 0) {
            throw new ValidacionException("El precio base debe ser mayor a 0");
        }
        this.precioBase = precioBase;
    }

    public int getNivelReputacion() {
        return nivelReputacion;
    }

    /**
     * Establece el nivel de reputación con validación
     *
     * @param nivelReputacion Nivel de reputación
     * @throws ValidacionException Si el nivel de reputación no es válido
     */
    public void setNivelReputacion(int nivelReputacion) throws ValidacionException {
        if (nivelReputacion < 1 || nivelReputacion > 5) {
            throw new ValidacionException("El nivel de reputación debe estar entre 1 y 5");
        }
        this.nivelReputacion = nivelReputacion;
    }

    /**
     * Simula la venta de un item por el comerciante
     */
    public void venderItem() {
        System.out.println(getNombre() + " esta vendiendo " + tipoMercancia + " por "
                + calcularPrecioFinal() + " monedas de cobre");
    }

    /**
     * Calcula el precio final aplicando descuentos por reputación
     *
     * @return Precio final después de aplicar descuentos
     */
    public double calcularPrecioFinal() {
        double descuento = nivelReputacion * 0.05;
        return precioBase * (1 - descuento);
    }
}
