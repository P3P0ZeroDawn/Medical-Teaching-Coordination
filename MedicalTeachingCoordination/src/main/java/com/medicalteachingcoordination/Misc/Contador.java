package com.medicalteachingcoordination.Misc;

/**
 * Contador simple para llevar la cuenta de usuarios.
 * 
 * @version 1.0
 * @author Pedro Enrique Sánchez Rodríguez
 */
public class Contador {
    int contador;

    /**
     * Constructor que inicializa el contador en 1.
     */
    public Contador() {
        contador = 1;
    }

    /**
     * Obtiene el valor actual del contador.
     * 
     * @return El valor del contador.
     */
    public int getContador() {
        return contador;
    }

    /**
     * Incrementa el contador en 1.
     */
    public void incrementarContador() {
        contador++;
    }
}
