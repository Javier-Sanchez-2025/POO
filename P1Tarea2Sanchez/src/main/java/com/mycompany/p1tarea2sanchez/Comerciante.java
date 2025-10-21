package com.mycompany.p1tarea2sanchez;

public class Comerciante extends Npc { //Uso de extends para la herencia de la clase Npc

    //Atributos unicos del comerciantes
    private String tipoMercancia;
    private double precioBase;
    private int nivelReputacion;

    // Constructores
    public Comerciante() {
        super();
        this.tipoMercancia = "Variado";
        this.precioBase = 10.0;
        this.nivelReputacion = 1;
    }

    public Comerciante(String nombre, int edad, String pueblo, boolean esAmigable,
            String tipoMercancia, double precioBase, int nivelReputacion) {
        super(nombre, edad, pueblo, esAmigable); // Llama al constructor de la clase padre
        this.tipoMercancia = tipoMercancia;
        this.precioBase = precioBase;
        this.nivelReputacion = nivelReputacion;
    }

    public String getTipoMercancia() {
        return tipoMercancia;
    }

    public void setTipoMercancia(String tipoMercancia) {
        this.tipoMercancia = tipoMercancia;
    }

    public double getPrecioBase() {
        return precioBase;
    }

    public void setPrecioBase(double precioBase) {
        this.precioBase = precioBase;
    }

    public int getNivelReputacion() {
        return nivelReputacion;
    }

    public void setNivelReputacion(int nivelReputacion) {
        this.nivelReputacion = nivelReputacion;
    }

    //Metodo del Ambulante
    public void venderItem() {
        System.out.println(getNombre() + " esta vendiendo " + tipoMercancia + " por " + calcularPrecioFinal() + " monedas de cobre ");
    }

    public double calcularPrecioFinal() {
        double descuento = nivelReputacion * 0.05;
        return precioBase * (1 - descuento);
    }
}
