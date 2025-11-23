package com.medicalteachingcoordination.Misc;

import java.time.LocalDate;

public class Asistencia {
    private Usuario usuario;
    private LocalDate fecha;

    public Asistencia(Usuario usuario) {
        this.usuario = usuario;
        this.fecha = LocalDate.now();
    }

    public Usuario getUsuario(){
        return this.usuario;
    }

    public LocalDate getFecha(){
        return this.fecha;
    }
}
