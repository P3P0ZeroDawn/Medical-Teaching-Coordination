package com.medicalteachingcoordination.Curso;

import java.util.ArrayList;
import com.medicalteachingcoordination.Estudiante.Estudiante;

public class Curso {
    private String nombre;
    private String claveConstancia;
    private ArrayList<Estudiante> estudiantes;

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

    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }

    public void setEstudiantes(ArrayList<Estudiante> estudiantes) {
        this.estudiantes = estudiantes;
    }
}
