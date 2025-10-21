package com.mycompany.p1tarea2sanchez;

public class Aldeano extends Npc {

    // Atributos propios del Aldeano
    private String profesion;
    private boolean tieneHogar;
    private String dialogoFavorito;

    // Constructor
    public Aldeano() {
        super(); 
        this.profesion = "Cartografo";
        this.tieneHogar = true;
        this.dialogoFavorito = "Buen dia";
    }

    public Aldeano(String nombre, int edad, String pueblo, boolean esAmigable,
            String profesion, boolean tieneHogar, String dialogoFavorito) {
        super(nombre, edad, pueblo, esAmigable); 
        this.profesion = profesion;
        this.tieneHogar = tieneHogar;
        this.dialogoFavorito = dialogoFavorito;
    }
    //permite leer el valor de un atributo privado
    public String getProfesion() {
        return profesion; //Y aqui lo retorna 
    }
    //permite modificar el valor de un atributo privado
    public void setProfesion(String profesion) {
        this.profesion = profesion; //Asigna un nuevo valor
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

    public void setDialogoFavorito(String dialogoFavorito) {
        this.dialogoFavorito = dialogoFavorito;
    }

    //Acciones del aldenao
    public void trabajar() {
        System.out.println(getNombre() + " esta trabajando como " + profesion);
    }

    public void conversar() {
        System.out.println(getNombre() + " dice: \"" + dialogoFavorito + "\"");
    }
}
