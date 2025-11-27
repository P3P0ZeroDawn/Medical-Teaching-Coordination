package com.medicalteachingcoordination.Administrativo;

import java.util.ArrayList;

import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Misc.Contador;
import com.medicalteachingcoordination.Misc.GenerarCodigo;

public class AgregarCurso {

    public ArrayList<Curso> agregarCurso(String nombreCurso, ArrayList<Curso> cursos, Contador contadorCursos) {
        cursos.add(new Curso(nombreCurso, new GenerarCodigo(contadorCursos).generarCodigo(nombreCurso)));
        return cursos;
    }
}
