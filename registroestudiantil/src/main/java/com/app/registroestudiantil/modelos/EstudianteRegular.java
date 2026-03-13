/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.app.registroestudiantil.modelos;

/**
 * Clase que representa a un estudiante de tipo regular
 * Hereda de la clase Estudiante
 * @author sammy
 */
public class EstudianteRegular extends Estudiante {

    /**
     * Constructor que inicializa un estudiante regular
     */
    public EstudianteRegular(String nombre, int edad, double nota) {
        super(nombre, edad, nota);
    }

    /**
     * Sobreescribe el método del padre para definir el tipo de estudiante
     */
    @Override
    public String obtenerTipo() {
        return "Regular";
    }
}