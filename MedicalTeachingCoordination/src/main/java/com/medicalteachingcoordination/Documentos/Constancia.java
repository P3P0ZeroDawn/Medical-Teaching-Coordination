package com.medicalteachingcoordination.Documentos;

import com.medicalteachingcoordination.Estudiante.Estudiante;
import com.medicalteachingcoordination.Curso.Curso;

/**
 * Clase que representa una constancia de curso para un estudiante.
 * Contiene la clave de la constancia, el estudiante y el curso asociado.
 * 
 * @version 1.0
 * @author César Daniel Ortega Castillejos
 */
public class Constancia {
    private String clave;
    private Estudiante estudiante;
    private Curso curso;

    /**
     * Constructor de la clase Constancia.
     * 
     * @param clave      Clave de la constancia.
     * @param estudiante Estudiante asociado a la constancia.
     * @param curso      Curso asociado a la constancia.
     */
    public Constancia(String clave, Estudiante estudiante, Curso curso) {
        this.clave = clave;
        this.estudiante = estudiante;
        this.curso = curso;
    }

    /**
     * Método get para obtener la Clave de la constancia.
     * 
     * @return Clave de la constancia.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Método get para obtener el Estudiante de la constancia.
     * 
     * @return Estudiante de la constancia.
     */
    public Estudiante getEstudiante() {
        return estudiante;
    }

    /**
     * Método get para obtener el Curso de la constancia.
     * 
     * @return Curso de la constancia.
     */
    public Curso getCurso() {
        return curso;
    }
}
