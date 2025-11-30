package com.medicalteachingcoordination.Estudiante;

import java.util.ArrayList;

import com.medicalteachingcoordination.Documentos.Constancia;
import com.medicalteachingcoordination.Curso.GestionarConstancias;

/**
 * Clase que permite a un estudiante subir una constancia para un curso
 * específico.
 * 
 * @version 1.0
 * @author Pedro Enrique Sánchez Rodríguez
 */
public class EstudianteSubirConstancia {

    /**
     * Metodo que permite a un estudiante subir una constancia para un curso
     * específico.
     * 
     * @param clave                Clave de la constancia.
     * @param nombreCurso          Nombre del curso especifico.
     * @param estudiante           Estudiante que sube la constancia.
     * @param gestionarConstancias Lista de gestionar constancias.
     * @return
     */
    public int subirConstancia(String clave, String nombreCurso, Estudiante estudiante,
            ArrayList<GestionarConstancias> gestionarConstancias) {
        GestionarConstancias gConstanciaCurso;
        for (GestionarConstancias gConstancia : gestionarConstancias) {
            if (gConstancia.getCurso().getNombre() == nombreCurso) {
                gConstanciaCurso = gConstancia;
                Constancia constancia = new Constancia(clave, estudiante, gConstanciaCurso.getCurso());
                return gConstanciaCurso.agregarConstanciaPorValidar(constancia);
            }
        }
        return 0;
    }

}
