package com.medicalteachingcoordination.Misc;

public class GenerarCodigo {
    Contador contador;

    public GenerarCodigo() {
        this.contador = new Contador();
    }

    public String generarCodigo(String objeto) {
        String codigo = objeto + contador.getContador();
        contador.incrementarContador();
        return codigo;
    }
}
