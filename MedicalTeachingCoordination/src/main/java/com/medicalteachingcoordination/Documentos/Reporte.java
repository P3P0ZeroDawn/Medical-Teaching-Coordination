package com.medicalteachingcoordination.Documentos;

import java.lang.reflect.Array;
import java.util.ArrayList;

import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Misc.Asistencia;

public class Reporte {
    ArrayList<GestionarConstancias> constanciasPorCurso;
    ArrayList<Asistencia> asistencias;

    public Reporte(ArrayList<GestionarConstancias> constanciasPorCurso, ArrayList<Asistencia> asistencias) {
        this.constanciasPorCurso = constanciasPorCurso;
        this.asistencias = asistencias;
    }
}
