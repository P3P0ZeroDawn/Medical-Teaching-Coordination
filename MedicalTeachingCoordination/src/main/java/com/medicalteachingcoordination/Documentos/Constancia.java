package com.medicalteachingcoordination.Documentos;

import com.medicalteachingcoordination.Estudiante.Estudiante;
import com.medicalteachingcoordination.Curso.Curso;

public class Constancia {
    private String clave;
    private Estudiante estudiante;
    private Curso curso;

    public Constancia(String clave, Estudiante estudiante, Curso curso) {
        this.clave = clave;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public String getClave() {
        return clave;
    }

    public Estudiante getEstudiante() {
        return estudiante;
    }

    public Curso getCurso() {
        return curso;
    }
}
