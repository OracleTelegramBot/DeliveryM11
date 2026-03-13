/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.app.registroestudiantil;

import com.app.registroestudiantil.modelos.Estudiante;
import com.app.registroestudiantil.modelos.EstudianteBeca;
import com.app.registroestudiantil.modelos.EstudianteRegular;
import com.app.registroestudiantil.servicios.ProcesoService;
import java.util.Scanner;

/**
 * Clase principal que contiene el menú y la interacción con el usuario
 * @author sammy
 */
public class Main {

    /**
     * Método principal que ejecuta el bucle del programa y valida entradas
     */
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        ProcesoService servicio = new ProcesoService();
        boolean salir = false;

        while (!salir) {
            // Menú exacto solicitado en la rúbrica
            System.out.println("╔══════════════════════════════════╗");
            System.out.println("║     SISTEMA ESTUDIANTIL v1.0     ║");
            System.out.println("╠══════════════════════════════════╣");
            System.out.println("║  1. Registrar estudiantes        ║");
            System.out.println("║  2. Ver calificaciones           ║");
            System.out.println("║  3. Ver estadísticas             ║");
            System.out.println("║  4. Buscar estudiante            ║");
            System.out.println("║  5. Salir                        ║");
            System.out.println("╚══════════════════════════════════╝");
            System.out.print("Seleccione una opción: ");

            int opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1 -> {
                    System.out.println("\n--- REGISTRAR ESTUDIANTE ---");
                    System.out.print("Nombre: ");
                    String nombre = teclado.nextLine();

                    System.out.print("Edad: ");
                    int edad = teclado.nextInt();

                    System.out.print("Nota (0.0 a 10.0): ");
                    double nota = teclado.nextDouble();
                    teclado.nextLine(); // Limpiar buffer

                    // VALIDACIÓN EXIGIDA POR LA RÚBRICA (if/else)
                    if (nota >= 0.0 && nota <= 10.0) {
                        System.out.print("Tipo (1. Regular | 2. Becado): ");
                        int tipo = teclado.nextInt();
                        teclado.nextLine(); 

                        Estudiante nuevoAlumno;
                        if (tipo == 1) {
                            nuevoAlumno = new EstudianteRegular(nombre, edad, nota);
                        } else {
                            nuevoAlumno = new EstudianteBeca(nombre, edad, nota);
                        }

                        // Se envia la instancia al servicio para que extraiga los datos
                        servicio.registrarEstudiante(nuevoAlumno);
                        System.out.println("¡Estudiante registrado correctamente!\n");
                    } else {
                        System.out.println("ERROR: La nota debe estar entre 0.0 y 10.0. Registro cancelado.\n");
                    }
                }
                case 2 -> {
                    System.out.println("\n--- LISTA DE CALIFICACIONES ---");
                    // Se llama al método del servicio que usa el "for"
                    servicio.mostrarEstudiantes();
                }
                case 3 -> {
                    System.out.println("\n--- ESTADÍSTICAS DEL GRUPO ---");
                    // Se llama a los métodos de cálculos
                    servicio.mostrarEstadisticas();
                }
                case 4 -> {
                    System.out.println("\n--- BUSCAR ESTUDIANTE ---");
                    System.out.print("Ingrese el nombre exacto del estudiante: ");
                    String buscarNombre = teclado.nextLine();
                    // Buscar en el HashMap
                    servicio.buscarEstudiante(buscarNombre);
                }
                case 5 -> {
                    System.out.println("Saliendo del sistema... ¡Éxito en tu entrega, padrino!");
                    salir = true;
                }
                default -> System.out.println("Opción no válida. Intente de nuevo.\n");
            }
        }
        teclado.close();
    }
}