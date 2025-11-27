package com.medicalteachingcoordination.Misc;

import java.time.LocalDate;

/**
 * Clase almacenadora que representa la asistencia generada en el proceso
 * "Registrar asistencia".
 * Contiene dos atributos, metodos constructor y gets.
 * 
 * @version 1.0
 * @author Pedro Enrique Sánchez Rodríguez
 */

public class Asistencia {
    private Usuario usuario;
    private LocalDate fecha;
    private String informacion;

    /**
     * Constructor de la clase Asistencia.
     * 
     * @param usuario objeto usuario que registra la asistencia.
     */
    public Asistencia(Usuario usuario, String informacion) {
        this.usuario = usuario;
        this.fecha = LocalDate.now();
        this.informacion = informacion;
    }

    /**
     * Metodo para obtener el usuario de la Asistencia.
     * 
     * @return usuario.
     */
    public Usuario getUsuario() {
        return this.usuario;
    }

    /**
     * Metodo para obtener la fecha de la Asistencia.
     * 
     * @return fecha de tipo "LocalDate".
     */
    public LocalDate getFecha() {
        return this.fecha;
    }
}
