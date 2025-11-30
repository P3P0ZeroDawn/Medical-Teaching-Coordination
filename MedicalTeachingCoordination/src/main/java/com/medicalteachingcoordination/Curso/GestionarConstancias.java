package com.medicalteachingcoordination.Curso;

import java.util.ArrayList;
import com.medicalteachingcoordination.Documentos.Constancia;

/**
 * Clase que gestiona las constancias de un curso.
 * Contiene el curso, las constancias por validar y las constancias validadas.
 * 
 * @version 1.0
 * @author César Daniel Ortega Castillejos
 */
public class GestionarConstancias {
    private Curso curso;
    private ArrayList<Constancia> constanciasPorValidar = new ArrayList<>();
    private ArrayList<Constancia> constanciasValidadas = new ArrayList<>();

    /**
     * Constructor de la clase GestionarConstancias.
     * 
     * @param curso Curso asociado a las constancias.
     */
    public GestionarConstancias(Curso curso) {
        this.curso = curso;
        this.constanciasPorValidar = new ArrayList<>();
        this.constanciasPorValidar = new ArrayList<>();
    }

    /**
     * Método para agregar una constancia a la lista de constancias por validar.
     * 
     * @param constancia Constancia a agregar.
     * @return 1 si la constancia ya está en la lista de por validar, 2 si ya está
     *         validada, 3 si se agregó correctamente.
     */
    public int agregarConstanciaPorValidar(Constancia constancia) {
        for (Constancia c : constanciasPorValidar) {
            if (c.getClave().equals(constancia.getClave()) && c.getCurso().equals(constancia.getCurso())
                    && c.getEstudiante().equals(constancia.getEstudiante())) {
                return 1;
            }
        }
        for (Constancia c : constanciasValidadas) {
            if (c.getClave().equals(constancia.getClave()) && c.getCurso().equals(constancia.getCurso())
                    && c.getEstudiante().equals(constancia.getEstudiante())) {
                return 2;
            }
        }
        constanciasPorValidar.add(constancia);
        return 3;
    }

    /**
     * Método para agregar una constancia a la lista de constancias validadas.
     * 
     * @param constancia Constancia a agregar.
     * @return 1 si la constancia ya está validada, 2 si se validó correctamente.
     */
    public int agregarConstanciaValidada(Constancia constancia) {
        for (Constancia c : constanciasValidadas) {
            if (c.getClave().equals(constancia.getClave()) && c.getCurso().equals(constancia.getCurso())
                    && c.getEstudiante().equals(constancia.getEstudiante())) {
                return 1;
            }
        }
        constanciasPorValidar.remove(constancia);
        constanciasValidadas.add(constancia);
        return 2;
    }

    /**
     * Medoto get para obtener el curso asociado a las constancias.
     * 
     * @return Curso asociado a las constancias.
     */
    public Curso getCurso() {
        return this.curso;
    }

    /**
     * Metodo get para obtener las lista de constancias por validar.
     * 
     * @return Lista de constancias por validar.
     */
    public ArrayList<Constancia> getConstanciasPorValidar() {
        return constanciasPorValidar;
    }

    /**
     * Metodo get para obtener las lista de constancias validadas.
     * 
     * @return Lista de constancias validadas.
     */
    public ArrayList<Constancia> getConstanciasValidadas() {
        return constanciasValidadas;
    }
}
