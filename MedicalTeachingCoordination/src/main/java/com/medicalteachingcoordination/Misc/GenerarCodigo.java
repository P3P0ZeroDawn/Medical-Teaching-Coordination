package com.medicalteachingcoordination.Misc;

/**
 * Clase para generar códigos únicos para diferentes objetos en el sistema.
 * Cada código se compone de un prefijo basado en el tipo de objeto
 * seguido de un número secuencial.
 */
public class GenerarCodigo {
    private Contador contador;

    public GenerarCodigo(Contador contador) {
        this.contador = contador;
    }

    public String generarCodigo(String objeto) {
        String codigo = objeto + contador.getContador();
        contador.incrementarContador();
        return codigo;
    }
}
