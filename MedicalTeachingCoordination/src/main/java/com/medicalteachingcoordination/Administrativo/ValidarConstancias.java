package com.medicalteachingcoordination.Administrativo;

import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Documentos.Constancia;

/**
 * Clase que maneja la validación de constancias de cursos.
 * 
 * @version 1.0
 * @author Pedro Enrique Sanchez Rodriguez
 */
public class ValidarConstancias {

    /**
     * Metodo para validar una constancia.
     * 
     * @param constancias Objeto de GestionarConstancias que contiene las listas de
     *                    constancias.
     * @param constancia  Objeto de Constancia a validar.
     * @return Entero que indica el resultado de la validación:
     *         1 - Constancia validada exitosamente.
     *         2 - Constancia ya fue validada anteriormente, se elimina de la lista
     *         por validar.
     *         3 - Constancia inválida, no está en la lista por validar.
     */
    public int ValidarConstancia(GestionarConstancias constancias, Constancia constancia) {
        if (constancias.getConstanciasPorValidar().contains(constancia)) {
            if (!constancias.getConstanciasValidadas().contains(constancia)) {
                constancias.agregarConstanciaValidada(constancia);
                return 1;
            }
            constancias.getConstanciasPorValidar().remove(constancia);
            return 2;
        }
        return 3;
    }
}
