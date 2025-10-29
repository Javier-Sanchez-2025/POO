package com.mycompany.refactorizado_sanchez;

import excepciones.ValidacionException;
import java.util.InputMismatchException;
import java.util.Scanner;
import modelo.Aldeano;
import modelo.Comerciante;
import modelo.Npc;

/**
 * Clase principal del sistema de gestión de NPCs Demuestra el uso de herencia,
 * encapsulamiento y manejo de excepciones
 */
public class Refactorizado_Sanchez {

    /**
     * Método principal que ejecuta la aplicación
     *
     * @param args Argumentos de línea de comandos
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        boolean continuar = true;

        System.out.println("=== SISTEMA DE GESTION DE NPCs ===");
        System.out.println("NPCs creados hasta ahora: " + Npc.getContadorNpcs());

        while (continuar) {
            try {
                ejecutarCreacionNPCs(scanner);
                continuar = preguntarContinuar(scanner);
            } catch (Exception e) {
                System.out.println("Error inesperado: " + e.getMessage());
                scanner.nextLine(); // Limpiar buffer
            }
        }

        System.out.println("\n=== RESUMEN FINAL ===");
        System.out.println("Total de NPCs creados en esta sesion: " + Npc.getContadorNpcs());
        System.out.println("Hasta pronto");
        scanner.close();
    }

    /**
     * Ejecuta el proceso de creación de NPCs
     *
     * @param scanner Scanner para entrada de datos
     */
    private static void ejecutarCreacionNPCs(Scanner scanner) {
        System.out.println("\n=== CREACION DE NPCs ===");

        Comerciante comerciante = crearComerciante(scanner);
        if (comerciante != null) {
            Aldeano aldeano = crearAldeano(scanner);
            if (aldeano != null) {
                mostrarInformacionNPCs(comerciante, aldeano);
            }
        }
    }

    /**
     * Crea un comerciante con datos ingresados por el usuario
     *
     * @param scanner Scanner para entrada de datos
     * @return Instancia de Comerciante creada, o null si hubo error
     */
    private static Comerciante crearComerciante(Scanner scanner) {
        System.out.println("\n--- CREACION DE COMERCIANTE ---");

        try {
            String nombreComerciante = obtenerNombreValido(scanner, "Nombre del comerciante");

            System.out.print("Edad del comerciante: ");
            int edadComerciante = obtenerEnteroValido(scanner);

            scanner.nextLine(); // Limpiar buffer

            String puebloComerciante = obtenerNombreValido(scanner, "Pueblo del comerciante");

            System.out.print("Es pacifico (S/N): ");
            boolean esAmigableComerciante = obtenerBooleanoValido(scanner);

            String tipoMercancia = obtenerTextoValido(scanner, "Tipo de mercancia");

            System.out.print("Precio base: ");
            double precioBase = obtenerDoubleValido(scanner);

            System.out.print("Nivel de reputacion (1-5): ");
            int nivelReputacion = obtenerEnteroEnRango(scanner, 1, 5);

            // Crear el objeto con los datos ingresados
            return new Comerciante(nombreComerciante, edadComerciante,
                    puebloComerciante, esAmigableComerciante,
                    tipoMercancia, precioBase, nivelReputacion);

        } catch (ValidacionException e) {
            System.out.println("Error de validacion: " + e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error inesperado al crear comerciante: " + e.getMessage());
            return null;
        }
    }

    /**
     * Crea un aldeano con datos ingresados por el usuario
     *
     * @param scanner Scanner para entrada de datos
     * @return Instancia de Aldeano creada, o null si hubo error
     */
    private static Aldeano crearAldeano(Scanner scanner) {
        System.out.println("\n--- CREACION DE ALDEANO ---");

        try {
            // Usar validación mejorada para nombre
            String nombreAldeano = obtenerNombreValido(scanner, "Nombre del aldeano");

            System.out.print("Edad del aldeano: ");
            int edadAldeano = obtenerEnteroValido(scanner);

            scanner.nextLine(); // Limpiar buffer

            // Usar validación mejorada para pueblo
            String puebloAldeano = obtenerNombreValido(scanner, "Pueblo del aldeano");

            System.out.print("Es pacifico (S/N): ");
            boolean esAmigableAldeano = obtenerBooleanoValido(scanner);

            // Usar validación para profesión
            String profesion = obtenerTextoValido(scanner, "Profesion del aldeano");

            System.out.print("Tiene hogar (S/N): ");
            boolean tieneHogar = obtenerBooleanoValido(scanner);

            // Usar validación para diálogo favorito
            String dialogoFavorito = obtenerTextoValido(scanner, "Dialogo favorito");

            // Crear el objeto con los datos ingresados
            return new Aldeano(nombreAldeano, edadAldeano, puebloAldeano,
                    esAmigableAldeano, profesion, tieneHogar, dialogoFavorito);

        } catch (ValidacionException e) {
            System.out.println("Error de validacion: " + e.getMessage());
            return null;
        } catch (IllegalArgumentException e) {
            System.out.println("Error en los datos: " + e.getMessage());
            return null;
        } catch (Exception e) {
            System.out.println("Error inesperado al crear aldeano: " + e.getMessage());
            return null;
        }
    }

    /**
     * Muestra la información de los NPCs creados
     *
     * @param comerciante Comerciante a mostrar
     * @param aldeano Aldeano a mostrar
     */
    private static void mostrarInformacionNPCs(Comerciante comerciante, Aldeano aldeano) {
        System.out.println("\n=== INFORMACION DE NPCs CREADOS ===");

        System.out.println("\n--- COMERCIANTE ---");
        System.out.println("Nombre: " + comerciante.getNombre());
        System.out.println("Edad: " + comerciante.getEdad());
        System.out.println("Pueblo: " + comerciante.getPueblo());
        System.out.println("Pacifico: " + (comerciante.isEsAmigable() ? "Si" : "No"));
        System.out.println("Mercancia: " + comerciante.getTipoMercancia());
        System.out.println("Precio Base: " + comerciante.getPrecioBase());
        System.out.println("Reputacion: " + comerciante.getNivelReputacion());
        System.out.println("Precio Final: " + String.format("%.2f", comerciante.calcularPrecioFinal()));
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
    }

    // Métodos auxiliares para validación de entrada
    /**
     * Obtiene un entero válido del usuario
     *
     * @param scanner Scanner para entrada de datos
     * @return Entero válido ingresado por el usuario
     */
    private static int obtenerEnteroValido(Scanner scanner) {
        while (true) {
            try {
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.print("Error: Debe ingresar un numero entero. Intente nuevamente: ");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    /**
     * Obtiene un double válido del usuario (acepta tanto punto como coma
     * decimal)
     *
     * @param scanner Scanner para entrada de datos
     * @return Double válido ingresado por el usuario
     */
    private static double obtenerDoubleValido(Scanner scanner) {
        while (true) {
            try {
                String input = scanner.next();
                // Reemplazar coma por punto para permitir ambos formatos
                input = input.replace(',', '.');
                return Double.parseDouble(input);
            } catch (NumberFormatException e) {
                System.out.print("Error: Debe ingresar un número decimal válido. Intente nuevamente: ");
            } catch (InputMismatchException e) {
                System.out.print("Error: Debe ingresar un número decimal. Intente nuevamente: ");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    /**
     * Obtiene un entero dentro de un rango específico
     *
     * @param scanner Scanner para entrada de datos
     * @param min Valor mínimo permitido
     * @param max Valor máximo permitido
     * @return Entero válido dentro del rango especificado
     */
    private static int obtenerEnteroEnRango(Scanner scanner, int min, int max) {
        while (true) {
            try {
                int valor = scanner.nextInt();
                if (valor >= min && valor <= max) {
                    return valor;
                } else {
                    System.out.printf("Error: El valor debe estar entre %d y %d. Intente nuevamente: ", min, max);
                }
            } catch (InputMismatchException e) {
                System.out.print("Error: Debe ingresar un numero entero. Intente nuevamente: ");
                scanner.nextLine(); // Limpiar buffer
            }
        }
    }

    /**
     * Obtiene un valor booleano válido (S/N) del usuario
     *
     * @param scanner Scanner para entrada de datos
     * @return true para 'S', false para 'N'
     */
    private static boolean obtenerBooleanoValido(Scanner scanner) {
        while (true) {
            try {
                String respuesta = scanner.nextLine().trim().toUpperCase();
                if (respuesta.equals("S") || respuesta.equals("SI") || respuesta.equals("SÍ")) {
                    return true;
                } else if (respuesta.equals("N") || respuesta.equals("NO")) {
                    return false;
                } else {
                    System.out.print("Error: Debe ingresar 'S' para Si o 'N' para No. Intente nuevamente: ");
                }
            } catch (Exception e) {
                System.out.print("Error inesperado. Intente nuevamente: ");
                scanner.nextLine(); // Limpiar buffer en caso de error
            }
        }
    }

    /**
     * Pregunta al usuario si desea continuar
     *
     * @param scanner Scanner para entrada de datos
     * @return true si desea continuar, false si no
     */
    private static boolean preguntarContinuar(Scanner scanner) {
        System.out.print("\n Desea crear mas NPCs (S/N): ");
        return obtenerBooleanoValido(scanner);
    }

    /**
     * Obtiene un nombre válido (solo letras y espacios) del usuario
     *
     * @param scanner Scanner para entrada de datos
     * @param campo Nombre del campo que se está solicitando (para el mensaje)
     * @return Nombre válido ingresado por el usuario
     */
    private static String obtenerNombreValido(Scanner scanner, String campo) {
        while (true) {
            try {
                System.out.print(campo + ": ");
                String input = scanner.nextLine().trim();

                // Validar que solo contenga letras y espacios
                if (input.matches("[a-zA-ZáéíóúÁÉÍÓÚñÑ\\s]+")) {
                    return input;
                } else {
                    System.out.print("Error: " + campo + " solo puede contener letras y espacios. Intente nuevamente: ");
                }
            } catch (Exception e) {
                System.out.print("Error inesperado. Intente nuevamente: ");
            }
        }
    }

    /**
     * Obtiene un texto válido (puede contener letras, números y espacios) del
     * usuario
     *
     * @param scanner Scanner para entrada de datos
     * @param campo Nombre del campo que se está solicitando (para el mensaje)
     * @return Texto válido ingresado por el usuario
     */
    private static String obtenerTextoValido(Scanner scanner, String campo) {
        while (true) {
            try {
                System.out.print(campo + ": ");
                String input = scanner.nextLine().trim();

                // Validar que no esté vacío
                if (!input.isEmpty()) {
                    return input;
                } else {
                    System.out.print("Error: " + campo + " no puede estar vacio. Intente nuevamente: ");
                }
            } catch (Exception e) {
                System.out.print("Error inesperado. Intente nuevamente: ");
            }
        }
    }
}
