package com.medicalteachingcoordination.Curso;

import java.util.ArrayList;
import com.medicalteachingcoordination.Documentos.Constancia;

public class GestionarConstancias {
    private Curso curso;
    private ArrayList<Constancia> constancias;

    public GestionarConstancias(Curso curso, ArrayList<Constancia> constancias) {
        this.curso = curso;
        this.constancias = constancias;
    }
}
