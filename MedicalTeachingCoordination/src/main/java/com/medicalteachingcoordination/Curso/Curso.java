package com.medicalteachingcoordination.Curso;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private String claveConstancia;
    private ArrayList<String> estudiantes;

    public Curso(String nombreCurso, String claveConstancia) {
        this.nombre = nombreCurso;
        this.claveConstancia = claveConstancia;
        estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public String getClaveConstancia() {
        return claveConstancia;
    }

    public ArrayList<String> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<String> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
