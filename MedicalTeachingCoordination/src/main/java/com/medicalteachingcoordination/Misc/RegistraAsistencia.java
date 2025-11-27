package com.medicalteachingcoordination.Misc;

/**
 * Interface que contiene un metodo abstracto para registrar la asistencia.
 * 
 * @version 1.0
 * @author Pedro Enrique Sánchez Rodríguez
 */
public interface RegistraAsistencia {
    /**
     * Metodo para registrar asistencia.
     * 
     * @return un objeto de tipo Asistencia.
     */
    public abstract Asistencia registrarAsistencia(String info);
}
