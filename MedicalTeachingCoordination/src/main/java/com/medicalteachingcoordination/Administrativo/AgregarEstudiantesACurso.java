package com.medicalteachingcoordination.Administrativo;

import java.util.ArrayList;

import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Estudiante.Estudiante;

public class AgregarEstudiantesACurso {
    public Curso agregarEstudiantesACurso(Curso curso, Estudiante estudiante) {
        ArrayList<Estudiante> estudiantes = curso.getEstudiantes();
        estudiantes.add(estudiante);
        return curso;
    }
}
