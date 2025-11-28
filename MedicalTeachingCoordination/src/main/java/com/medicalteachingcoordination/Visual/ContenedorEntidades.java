package com.medicalteachingcoordination.Visual;

import java.util.ArrayList;

import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Misc.Asistencia;
import com.medicalteachingcoordination.Misc.Contador;
import com.medicalteachingcoordination.Misc.Usuario;

public class ContenedorEntidades {

    private ArrayList<Usuario> usuarios;
    private ArrayList<Asistencia> asistencias;
    private ArrayList<Curso> cursos;
    private ArrayList<GestionarConstancias> constancias;
    private Contador contadorUsuarios;
    private Usuario usuarioActual;

    public ContenedorEntidades() {
        usuarios = new ArrayList<>();
        asistencias = new ArrayList<>();
        cursos = new ArrayList<>();
        constancias = new ArrayList<>();
        contadorUsuarios = new Contador();
        usuarioActual = null;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }

    public ArrayList<Curso> getCursos() {
        return cursos;
    }

    public ArrayList<GestionarConstancias> getConstancias() {
        return constancias;
    }

    public Contador getContadorUsuarios() {
        return contadorUsuarios;
    }

    public Usuario getUsuarioActual() {
        return usuarioActual;
    }

    public void setUsuarioActual(Usuario usuarioActual) {
        this.usuarioActual = usuarioActual;
    }
}
