package com.medicalteachingcoordination.Documentos;

import java.util.ArrayList;

import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Misc.Asistencia;

/**
 * Clase que representa un reporte que contiene constancias por curso y
 * asistencias.
 * 
 * @version 1.0
 * @author César Daniel Ortega Castillejos
 */
public class Reporte {
    private ArrayList<GestionarConstancias> constanciasPorCurso;
    private ArrayList<Asistencia> asistencias;

    /**
     * Constructor de la clase Reporte.
     * 
     * @param constanciasPorCurso Lista de gestionar constancias.
     * @param asistencias         Lista de asistencias.
     */
    public Reporte(ArrayList<GestionarConstancias> constanciasPorCurso, ArrayList<Asistencia> asistencias) {
        this.constanciasPorCurso = constanciasPorCurso;
        this.asistencias = asistencias;
    }

    /**
     * Método get para obtener la lista de gestionar constancias.
     * 
     * @return Lista de gestionar constancias.
     */
    public ArrayList<GestionarConstancias> getConstanciasPorCurso() {
        return constanciasPorCurso;
    }

    /**
     * Método get para obtener la lista de asistencias.
     * 
     * @return Lista de asistencias.
     */
    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }
}
