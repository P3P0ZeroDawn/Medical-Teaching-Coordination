package com.medicalteachingcoordination.Administrativo;

import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Estudiante.Estudiante;

public class AgregarEstudiantesACurso {
    public int agregarEstudiantesACurso(Curso curso, Estudiante estudiante) {
        if(curso == null || estudiante == null) {
            return 1; // Error: curso o estudiante nulo
        }
        if(curso.getEstudiantes().contains(estudiante)) {
            return 2; // Error: el estudiante ya está inscrito en el curso
        }
        curso.getEstudiantes().add(estudiante);
        return 3; // Éxito
    }
}
