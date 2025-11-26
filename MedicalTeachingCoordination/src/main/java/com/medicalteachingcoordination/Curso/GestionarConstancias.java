package com.medicalteachingcoordination.Curso;

import java.util.ArrayList;
import com.medicalteachingcoordination.Documentos.Constancia;

public class GestionarConstancias {
    private Curso curso;
    private ArrayList<Constancia> constanciasPorValidar;
    private ArrayList<Constancia> constanciasValidadas;

    public GestionarConstancias(Curso curso) {
        this.curso = curso;
        this.constanciasPorValidar = new ArrayList<>();
        this.constanciasPorValidar = new ArrayList<>();
    }

    public void agregarConstanciaPorValidar(Constancia constancia) {
        if (!constanciasPorValidar.contains(constancia) && !constanciasValidadas.contains(constancia) && curso.getClaveConstancia().equals(constancia.getClave())){
            constanciasPorValidar.add(constancia);
        }     
    }

    public void agregarConstanciaValidada(Constancia constancia) {
        if (constanciasPorValidar.contains(constancia)) {
            constanciasPorValidar.remove(constancia);
            constanciasValidadas.add(constancia);
        }
    }
}
