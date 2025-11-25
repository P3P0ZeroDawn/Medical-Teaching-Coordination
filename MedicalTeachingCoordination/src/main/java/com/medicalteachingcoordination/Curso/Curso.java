package com.medicalteachingcoordination.Curso;

import java.util.ArrayList;

public class Curso {
    private String nombre;
    private ArrayList<String> claveConstancia;
    private ArrayList<String> estudiantes;

    public Curso(String nombreCurso) {
        this.nombre = nombreCurso;
        claveConstancia = new ArrayList<>();
        estudiantes = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public ArrayList<String> getClaveConstancia() {
        return claveConstancia;
    }

    public ArrayList<String> getEstudiantes() {
        return estudiantes;
    }

    public void setClaveConstancia(ArrayList<String> claveConstancia) {
        this.claveConstancia = claveConstancia;
    }

    public void setEstudiantes(ArrayList<String> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
