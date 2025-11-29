package com.medicalteachingcoordination.Administrativo;

import java.util.ArrayList;

import com.medicalteachingcoordination.Curso.Curso;

public class AgregarCurso {

    public int agregarCurso(String nombreCurso, String clave, ArrayList<Curso> cursos) {
        if(nombreCurso == null || nombreCurso.trim().isEmpty()){
            return 1;
        }
        if(clave == null || clave.trim().isEmpty()){
            return 2;
        }
        if(!existeCurso(nombreCurso, cursos)){
            cursos.add(new Curso(nombreCurso, clave));
            return 3;
        }
        return 4;
    }

    public boolean existeCurso(String nombreCurso, ArrayList<Curso> cursos) {
        for (Curso curso : cursos) {
            if (curso.getNombre().equalsIgnoreCase(nombreCurso)) {
                return true;
            }
        }
        return false;
    }
}
