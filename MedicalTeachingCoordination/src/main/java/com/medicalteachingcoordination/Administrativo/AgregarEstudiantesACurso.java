package com.medicalteachingcoordination.Administrativo;

import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Estudiante.Estudiante;

/**
 * Clase que permite agregar estudiantes a un curso.
 * 
 * @version 1.0
 * @author César Daniel Ortega Castillejos
 */
public class AgregarEstudiantesACurso {

    /**
     * Metodo para agregar un estudiante a un curso.
     * 
     * @param curso      Curso al que se desea agregar el estudiante.
     * @param estudiante Estudiante que se desea agregar al curso.
     * @return Código de estado: 1 - Error: curso o estudiante nulo,
     *         2 - Error: el estudiante ya está inscrito en el curso,
     *         3 - Éxito.
     */
    public int agregarEstudiantesACurso(Curso curso, Estudiante estudiante) {
        if (curso == null || estudiante == null) {
            return 1;
        }
        if (curso.getEstudiantes().contains(estudiante)) {
            return 2;
        }
        curso.getEstudiantes().add(estudiante);
        return 3;
    }
}
