package com.mycompany.p1tarea2sanchez;
import java.util.*;

public class P1Tarea2Sanchez {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);// Crear Scanner para entrada de datos

        System.out.println("=== Creacion de NPCs ===");
        System.out.println("Vamos a crear un Comerciante y un Aldeano\n");
        System.out.println("--- Comerciante ---");
        System.out.print("Nombre del comerciante: ");
        String nombreComerciante = sc.nextLine();// Retiene texto 
        System.out.print("Edad del comerciante: ");
        int edadComerciante = sc.nextInt();// Capta numeros enteros
        sc.nextLine();
        System.out.print("Pueblo del comerciante: ");
        String puebloComerciante = sc.nextLine();
        System.out.print("Es pacifico (S/N): ");
        String respuestaAmigable = sc.nextLine();
        boolean esAmigableComerciante = respuestaAmigable.equalsIgnoreCase("S"); //Convierte a boolean
        System.out.print("Tipo de mercancia: ");
        String tipoMercancia = sc.nextLine();
        System.out.print("Precio base: ");
        double precioBase = sc.nextDouble();
        System.out.print("Nivel de reputacion (1-5): ");
        int nivelReputacion = sc.nextInt();
        sc.nextLine();

        // Crea el objeto con los datos ingresado :v
        Comerciante comerciante = new Comerciante(nombreComerciante, edadComerciante,
                puebloComerciante, esAmigableComerciante,
                tipoMercancia, precioBase, nivelReputacion);

        System.out.println("\n--- Aldeano ---");
        System.out.print("Nombre del aldeano: ");
        String nombreAldeano = sc.nextLine();
        System.out.print("Edad del aldeano: ");
        int edadAldeano = sc.nextInt();
        sc.nextLine();
        System.out.print("Pueblo del aldeano: ");
        String puebloAldeano = sc.nextLine();
        System.out.print("Es pacifico (S/N): ");
        respuestaAmigable = sc.nextLine();
        boolean esAmigableAldeano = respuestaAmigable.equalsIgnoreCase("S");
        System.out.print("Profesion del aldeano: ");
        String profesion = sc.nextLine();
        System.out.print("Tiene hogar (S/N): ");
        String respuestaHogar = sc.nextLine();
        boolean tieneHogar = respuestaHogar.equalsIgnoreCase("S");
        System.out.print("Dialogo favorito: ");
        String dialogoFavorito = sc.nextLine();

        //Instacnia del aldeano
        Aldeano aldeano = new Aldeano(nombreAldeano, edadAldeano, puebloAldeano,
                esAmigableAldeano, profesion, tieneHogar, dialogoFavorito);
        
        System.out.println("\n=== INFROMACION ===");

        System.out.println("\n--- COMERCIANTE ---");
        System.out.println("Nombre: " + comerciante.getNombre());
        System.out.println("Edad: " + comerciante.getEdad());
        System.out.println("Pueblo: " + comerciante.getPueblo());
        System.out.println("Pacifico: " + (comerciante.isEsAmigable() ? "Si" : "No"));
        System.out.println("Mercancia: " + comerciante.getTipoMercancia());
        System.out.println("Precio Base: " + comerciante.getPrecioBase());
        System.out.println("Reputacion: " + comerciante.getNivelReputacion());
        System.out.println("Precio Final: " + comerciante.calcularPrecioFinal());
        comerciante.saludar();
        comerciante.venderItem();

        System.out.println("\n--- ALDEANO ---");
        System.out.println("Nombre: " + aldeano.getNombre());
        System.out.println("Edad: " + aldeano.getEdad());
        System.out.println("Pueblo: " + aldeano.getPueblo());
        System.out.println("Amigable: " + (aldeano.isEsAmigable() ? "Si" : "No"));
        System.out.println("Profesion: " + aldeano.getProfesion());
        System.out.println("Tiene Hogar: " + (aldeano.getTieneHogar() ? "Si" : "No"));
        System.out.println("Dialogo Favorito: " + aldeano.getDialogoFavorito());
        aldeano.saludar();
        aldeano.trabajar();
        aldeano.conversar();

        sc.close();
    }
}
