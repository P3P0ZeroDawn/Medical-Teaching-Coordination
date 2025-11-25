package com.medicalteachingcoordination.Documentos;

public class Constancia {
    private String clave;
    private String estudiante;
    private String curso;

    public Constancia(String clave, String estudiante, String curso) {
        this.clave = clave;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    public String getClave() {
        return clave;
    }

    public String getEstudiante() {
        return estudiante;
    }

    public String getCurso() {
        return curso;
    }
}
