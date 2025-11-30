package com.medicalteachingcoordination.Curso;

import java.util.ArrayList;
import com.medicalteachingcoordination.Documentos.Constancia;

public class GestionarConstancias {
    private Curso curso;
    private ArrayList<Constancia> constanciasPorValidar = new ArrayList<>();
    private ArrayList<Constancia> constanciasValidadas = new ArrayList<>();

    public GestionarConstancias(Curso curso) {
        this.curso = curso;
        this.constanciasPorValidar = new ArrayList<>();
        this.constanciasPorValidar = new ArrayList<>();
    }

    public int agregarConstanciaPorValidar(Constancia constancia) {
        for (Constancia c: constanciasPorValidar){
            if (c.getClave().equals(constancia.getClave()) && c.getCurso().equals(constancia.getCurso()) && c.getEstudiante().equals(constancia.getEstudiante())){
                return 1;
            }
        }
        for (Constancia c: constanciasValidadas){
            if (c.getClave().equals(constancia.getClave()) && c.getCurso().equals(constancia.getCurso()) && c.getEstudiante().equals(constancia.getEstudiante())){
                return 2;
            }
        }
        constanciasPorValidar.add(constancia);
        return 3;
    }

    public int agregarConstanciaValidada(Constancia constancia) {
        for (Constancia c: constanciasValidadas){
            if (c.getClave().equals(constancia.getClave()) && c.getCurso().equals(constancia.getCurso()) && c.getEstudiante().equals(constancia.getEstudiante())){
                return 1;
            }
        }
        constanciasPorValidar.remove(constancia);
        constanciasValidadas.add(constancia);
        return 2;
    }

    public Curso getCurso() {
        return this.curso;
    }

    public ArrayList<Constancia> getConstanciasPorValidar() {
        return constanciasPorValidar;
    }

    public ArrayList<Constancia> getConstanciasValidadas() {
        return constanciasValidadas;
    }
}
