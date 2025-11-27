package com.medicalteachingcoordination.Documentos;

import java.util.ArrayList;

import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Misc.Asistencia;

public class Reporte {
    private ArrayList<GestionarConstancias> constanciasPorCurso;
    private ArrayList<Asistencia> asistencias;

    public Reporte(ArrayList<GestionarConstancias> constanciasPorCurso, ArrayList<Asistencia> asistencias) {
        this.constanciasPorCurso = constanciasPorCurso;
        this.asistencias = asistencias;
    }

    public ArrayList<GestionarConstancias> getConstanciasPorCurso() {
        return constanciasPorCurso;
    }

    public ArrayList<Asistencia> getAsistencias() {
        return asistencias;
    }
}
