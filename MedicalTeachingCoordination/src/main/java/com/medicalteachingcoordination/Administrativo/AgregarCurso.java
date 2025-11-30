package com.medicalteachingcoordination.Administrativo;

import java.util.ArrayList;

import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Curso.GestionarConstancias;

/**
 * Clase que permite agregar cursos al sistema.
 * 
 * @version 1.0
 * @author César Daniel Ortega Castillejos
 */
public class AgregarCurso {

    /**
     * Metodo para agregar un curso al sistema.
     * 
     * @param nombreCurso         Nombre del curso a agregar.
     * @param clave               Clave del curso a agregar.
     * @param cursos              Lista de cursos existentes en el sistema.
     * @param constanciasPorCurso Lista de gestion de constancias por curso.
     * @return Código de estado: 1 - Error: nombre del curso nulo o vacío,
     *         2 - Error: clave del curso nulo o vacío,
     *         3 - Éxito,
     *         4 - Error: el curso ya existe.
     */
    public int agregarCurso(String nombreCurso, String clave, ArrayList<Curso> cursos,
            ArrayList<GestionarConstancias> constanciasPorCurso) {
        if (nombreCurso == null || nombreCurso.trim().isEmpty()) {
            return 1;
        }
        if (clave == null || clave.trim().isEmpty()) {
            return 2;
        }
        if (!existeCurso(nombreCurso, cursos)) {
            Curso nuevoCurso = new Curso(nombreCurso, clave);
            cursos.add(nuevoCurso);
            constanciasPorCurso.add(new GestionarConstancias(nuevoCurso));
            return 3;
        }
        return 4;
    }

    /**
     * Metodo para verificar si un curso ya existe en la lista de cursos.
     * 
     * @param nombreCurso Nombre del curso a verificar.
     * @param cursos      Lista de cursos existentes en el sistema.
     * @return true si el curso existe, false en caso contrario.
     */
    public boolean existeCurso(String nombreCurso, ArrayList<Curso> cursos) {
        for (Curso curso : cursos) {
            if (curso.getNombre().equalsIgnoreCase(nombreCurso)) {
                return true;
            }
        }
        return false;
    }
}
