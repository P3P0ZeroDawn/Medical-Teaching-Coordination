package com.medicalteachingcoordination.Misc;

/**
 * Clase que genera códigos únicos para diferentes tipos de objetos en el
 * sistema.
 * Utiliza un contador.
 * 
 * @version 1.0
 * @author César Daniel Ortega Castillejos
 */
public class GenerarCodigo {
    private Contador contador;

    /**
     * Constructor de la clase GenerarCodigo.
     * 
     * @param contador Contador para generar códigos únicos.
     */
    public GenerarCodigo(Contador contador) {
        this.contador = contador;
    }

    /**
     * Metodo para generar un código único basado en el tipo de objeto.
     * 
     * @param objeto Tipo de objeto.
     * @return Código único generado.
     */
    public String generarCodigo(String objeto) {
        String codigo = objeto + contador.getContador();
        contador.incrementarContador();
        return codigo;
    }
}
