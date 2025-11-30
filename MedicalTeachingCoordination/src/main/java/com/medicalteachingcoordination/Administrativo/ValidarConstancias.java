package com.medicalteachingcoordination.Administrativo;

import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Documentos.Constancia;

public class ValidarConstancias {
    public int ValidarConstancia(GestionarConstancias constancias, Constancia constancia) {
        if (constancias.getConstanciasPorValidar().contains(constancia)) {
            if(!constancias.getConstanciasValidadas().contains(constancia)){
                constancias.agregarConstanciaValidada(constancia);
                return 1; //constancia validada
            }
            constancias.getConstanciasPorValidar().remove(constancia);
            return 2; //constancia ya fue validada anteriormente, la eliminamos
        }
        return 3; //constancia invalida, no esta en la lista por validar
    }
}
