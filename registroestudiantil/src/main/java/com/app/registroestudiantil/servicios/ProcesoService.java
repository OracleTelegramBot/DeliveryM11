package com.app.registroestudiantil.servicios;

import com.app.registroestudiantil.modelos.Estudiante;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * Clase que gestiona el almacenamiento y los cálculos de las calificaciones.
 * Cumple con los requisitos de arreglos, colecciones y recursividad.
 * @author sammy
 */
public class ProcesoService {

    // --- PARTE 3: ARREGLOS Y COLECCIONES EXIGIDOS ---
    private double[] notas = new double[100]; // Arreglo estático (límite 100)
    private ArrayList<String> nombres = new ArrayList<>();
    private HashMap<String, Double> informacion = new HashMap<>();
    
    // Variable auxiliar para saber cuántos alumnos llevamos en el arreglo notas[]
    private int contador = 0;

    /**
     * Registra un estudiante guardando sus datos en las 3 estructuras solicitadas.
     */
    public void registrarEstudiante(Estudiante e) {
        if (contador < notas.length) {
            nombres.add(e.getNombre());            // Se guarda en el ArrayList
            notas[contador] = e.getNota();         // Se guarda en el arreglo double[]
            informacion.put(e.getNombre(), e.getNota()); // Se guarda en el HashMap
            contador++;
        } else {
            System.out.println("Error: Límite de capacidad (100) alcanzado.");
        }
    }

    /**
     * Muestra la lista completa de estudiantes usando un ciclo for.
     */
    public void mostrarEstudiantes() {
        if (contador == 0) {
            System.out.println("No hay estudiantes registrados aún.");
            return;
        }
        // Uso del for exigido por la rúbrica
        for (int i = 0; i < contador; i++) {
            System.out.println((i + 1) + ". " + nombres.get(i) + " - Nota: " + notas[i] + " (" + obtenerEstado(notas[i]) + ")");
        }
    }

    /**
     * Busca a un estudiante en el HashMap y muestra su nota y estado.
     */
    public void buscarEstudiante(String nombre) {
        // Validación en el HashMap como lo pide la Parte 3
        if (informacion.containsKey(nombre)) {
            double notaEncontrada = informacion.get(nombre);
            System.out.println("Estudiante encontrado:");
            System.out.println("Nombre: " + nombre + " | Nota: " + notaEncontrada + " | Estado: " + obtenerEstado(notaEncontrada));
        } else {
            System.out.println("Estudiante '" + nombre + "' no encontrado en el sistema.");
        }
    }

    /**
     * Imprime todos los resultados de los cálculos en el Main.
     */
    public void mostrarEstadisticas() {
        if (contador == 0) {
            System.out.println("No hay datos para calcular estadísticas.");
            return;
        }
        System.out.println("Promedio del grupo: " + calcularPromedio(notas));
        System.out.println("Nota más alta: " + notaMasAlta(notas));
        System.out.println("Nota más baja: " + notaMasBaja(notas));
        System.out.println("Total de aprobados: " + contarAprobados(notas));
    }

    // =========================================================
    // --- PARTE 2: MÉTODOS DE CÁLCULO EXIGIDOS ---
    // =========================================================

    /**
     * Retorna "Aprobado" o "Reprobado" según la nota (>= 6.0).
     */
    public String obtenerEstado(double nota) {
        if (nota >= 6.0) return "Aprobado";
        else return "Reprobado";
    }

    /**
     * Retorna la nota más alta del arreglo.
     */
    public double notaMasAlta(double[] arregloNotas) {
        if (contador == 0) return 0.0;
        double maxima = arregloNotas[0];
        for (int i = 1; i < contador; i++) {
            if (arregloNotas[i] > maxima) maxima = arregloNotas[i];
        }
        return maxima;
    }

    /**
     * Retorna la nota más baja del arreglo.
     */
    public double notaMasBaja(double[] arregloNotas) {
        if (contador == 0) return 0.0;
        double minima = arregloNotas[0];
        for (int i = 1; i < contador; i++) {
            if (arregloNotas[i] < minima) minima = arregloNotas[i];
        }
        return minima;
    }

    /**
     * Cuenta y retorna cuántos estudiantes aprobaron (nota >= 6.0).
     */
    public int contarAprobados(double[] arregloNotas) {
        int aprobados = 0;
        for (int i = 0; i < contador; i++) {
            if (arregloNotas[i] >= 6.0) aprobados++;
        }
        return aprobados;
    }

    /**
     * ⭐ MÉTODO RECURSIVO OBLIGATORIO ⭐
     * Suma las notas una por una llamándose a sí mismo.
     */
    public double sumarNotas(double[] arregloNotas, int i) {
        // Caso base: Si se llega a un índice negativo, terminamos la recursión devolviendo 0
        if (i < 0) {
            return 0;
        }
        // Llamada recursiva: La nota actual + la suma de todas las anteriores
        return arregloNotas[i] + sumarNotas(arregloNotas, i - 1);
    }

    /**
     * Calcula el promedio usando recursividad
     */
    public double calcularPromedio(double[] arregloNotas) {
        if (contador == 0) return 0.0;
        
        // Se llama a la recursividad del metodo pasándole el índice del último elemento agregado
        double sumaTotal = sumarNotas(arregloNotas, contador - 1);
        return sumaTotal / contador;
    }
}