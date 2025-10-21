package com.mycompany.p1tarea2sanchez;

public class Npc {

    //encapsulamiento
    private String nombre;
    private int edad;
    private String pueblo;
    private boolean esAmigable;

    //constructores por default
    public Npc() {
        this.nombre = "Desconocido";
        this.edad = 0;
        this.pueblo = "Sin pueblo";
        this.esAmigable = true;
    }

    public Npc(String nombre, int edad, String pueblo, boolean esAmigable) {
        this.nombre = nombre;
        this.edad = edad;
        this.pueblo = pueblo;
        this.esAmigable = esAmigable;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getPueblo() {
        return pueblo;
    }

    public void setPueblo(String pueblo) {
        this.pueblo = pueblo;
    }

    public boolean isEsAmigable() {
        return esAmigable;
    }

    public void setEsAmigable(boolean esAmigable) {
        this.esAmigable = esAmigable;
    }

    public void saludar() {
        System.out.println("Mucho gusto explorador yo soy " + nombre + " del pueblo " + pueblo);
    }
}
