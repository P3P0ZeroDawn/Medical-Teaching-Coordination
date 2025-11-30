package com.medicalteachingcoordination.Administrativo;

import java.util.ArrayList;

import com.medicalteachingcoordination.Documentos.Reporte;
import com.medicalteachingcoordination.Documentos.Constancia;
import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Misc.Asistencia;

public class ConsultarReporte {

    public String consultarReporte(Reporte reporte) {
        String reporteString = "";
        reporteString = reporteString + crearReporteCursos(reporte.getConstanciasPorCurso());
        reporteString = reporteString + crearReporteAsistencias(reporte.getAsistencias());
        return reporteString;
    }

    private String crearReporteCursos(ArrayList<GestionarConstancias> gestionarConstancias) {
        if (gestionarConstancias.size() == 0)
            return "";
        String infoCursos = "";
        for (GestionarConstancias gc : gestionarConstancias) {
            infoCursos = infoCursos + "\n\n" + gc.getCurso().getNombre() + "\n" + "Constancias validadas: " + "\n";
            if( gc.getConstanciasValidadas() == null || gc.getConstanciasValidadas().size() == 0){
                infoCursos = infoCursos + "  Ninguna \n";
            } else {
                for (Constancia constancia : gc.getConstanciasValidadas()) {
                    infoCursos = infoCursos + "Clave: " + constancia.getClave() + "   Estudiante: "
                            + constancia.getEstudiante().getNombre() + "\n";
                }
            }
            infoCursos = infoCursos + "Constancias sin validar: \n";
            if( gc.getConstanciasPorValidar() == null || gc.getConstanciasPorValidar().size() == 0){
                infoCursos = infoCursos + "  Ninguna \n";
            } else {
                for (Constancia constancia : gc.getConstanciasPorValidar()) {
                    infoCursos = infoCursos + "Clave: " + constancia.getClave() + "   Estudiante: "
                            + constancia.getEstudiante().getNombre() + "\n";
                }
            }
        }
        return infoCursos;
    }

    private String crearReporteAsistencias(ArrayList<Asistencia> asistencias) {
        if (asistencias.size() == 0)
            return "";
        String infoAsistencias = "\n";
        ArrayList<String> cursos = new ArrayList<>();
        for (Asistencia asistencia : asistencias) {
            boolean esta = false;
            for (String c : cursos) {
                if (c == asistencia.getInformacion())
                    esta = true;
            }
            if (!esta)
                cursos.add(asistencia.getInformacion());
        }

        infoAsistencias = infoAsistencias + "Asistencias por curso \n";

        for (String c : cursos) {
            infoAsistencias = infoAsistencias + "\n" + c + "\n";
            for (Asistencia asistenciaCurso : asistencias) {
                if (c == asistenciaCurso.getInformacion()) {
                    infoAsistencias = infoAsistencias + asistenciaCurso.getUsuario().getNombre() + "  " + asistenciaCurso.getFecha()
                            + "\n";
                }
            }
        }
        return infoAsistencias;
    }

    public Reporte generarReporte(ArrayList<GestionarConstancias> constanciasPorCurso, ArrayList<Asistencia> asistencias){
        Reporte reporte = new Reporte(constanciasPorCurso, asistencias);
        return reporte;
    }
}
