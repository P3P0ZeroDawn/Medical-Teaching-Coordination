package com.medicalteachingcoordination.Estudiante;

import java.util.ArrayList;

import com.medicalteachingcoordination.Documentos.Constancia;
import com.medicalteachingcoordination.Curso.GestionarConstancias;

public class EstudianteSubirConstancia {

    public boolean subirConstancia(String clave, String nombreCurso, Estudiante estudiante,
            ArrayList<GestionarConstancias> gestionarConstancias) {
        GestionarConstancias gConstanciaCurso;
        for (GestionarConstancias gConstancia : gestionarConstancias) {
            if (gConstancia.getCurso().getNombre() == nombreCurso) {
                gConstanciaCurso = gConstancia;
                Constancia constancia = new Constancia(clave, estudiante, gConstanciaCurso.getCurso());
                gConstanciaCurso.agregarConstanciaPorValidar(constancia);
                return true;
            }
        }
        return false;
    }

}
