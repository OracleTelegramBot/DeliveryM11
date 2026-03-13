package com.app.registroestudiantil.modelos;

public class Estudiante extends Persona {
    private double nota;

    public Estudiante(String nombre, int edad, double nota) {
        super(nombre, edad);
        this.nota = nota;
    }

    public double getNota() { return nota; }

    /**
     * Retorna el estado con base en la calificación
     */
    public String obtenerEstado() {
        if (this.nota >= 6.0) return "Aprobado";
        else return "Reprobado";
    }

    public String obtenerTipo() {
        return "Estudiante"; 
    }

    public void mostrarInfo() {
        System.out.println("Nombre: " + getNombre() + " | Nota: " + nota);
    }

    public void mostrarInfo(boolean mostrarEstado) {
        mostrarInfo();
        if (mostrarEstado) {
            System.out.println("Estado: " + obtenerEstado());
        }
    }
}