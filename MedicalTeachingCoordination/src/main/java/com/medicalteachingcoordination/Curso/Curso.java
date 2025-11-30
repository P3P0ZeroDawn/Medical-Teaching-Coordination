package com.medicalteachingcoordination.Curso;

import java.util.ArrayList;
import com.medicalteachingcoordination.Estudiante.Estudiante;

/**
 * Clase instanciable que representa un curso.
 * Contiene el nombre del curso, la clave de constancia y la lista de
 * estudiantes inscritos.
 * 
 * @version 1.0
 * @author César Daniel Ortega Castillejos
 */
public class Curso {
    private String nombre;
    private String claveConstancia;
    private ArrayList<Estudiante> estudiantes;

    /**
     * Constructor de la clase Curso.
     * 
     * @param nombreCurso     Nombre del curso.
     * @param claveConstancia Clave de la constancia del curso.
     */
    public Curso(String nombreCurso, String claveConstancia) {
        this.nombre = nombreCurso;
        this.claveConstancia = claveConstancia;
        estudiantes = new ArrayList<>();
    }

    /**
     * Metodo get para obtener el nombre del curso.
     * 
     * @return Nombre del curso.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Metodo get para obtener la clave de la constancia del curso.
     * 
     * @return Clave de la constancia del curso.
     */
    public String getClaveConstancia() {
        return claveConstancia;
    }

    /**
     * Metodo get para obtener la lista de estudiantes inscritos en el curso.
     * 
     * @return Lista de estudiantes inscritos en el curso.
     */
    public ArrayList<Estudiante> getEstudiantes() {
        return estudiantes;
    }
}
