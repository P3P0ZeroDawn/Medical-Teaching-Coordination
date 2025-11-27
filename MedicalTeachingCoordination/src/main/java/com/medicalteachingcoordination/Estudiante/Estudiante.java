package com.medicalteachingcoordination.Estudiante;

import com.medicalteachingcoordination.Misc.RegistraAsistencia;
import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Misc.Asistencia;
import com.medicalteachingcoordination.Misc.GenerarCodigo;

public class Estudiante extends Usuario implements RegistraAsistencia {
    private String matricula;

    public Estudiante(String nombre, String usuario, char[] contrasena, String matricula) {
        super(nombre, usuario, contrasena, "estudiante");
        this.matricula = matricula;
    }

    public String getmatricula(){
        return this.matricula;
    }

    public void setmatricula(String matricula){
        this.matricula = matricula;
    }

    public Asistencia registrarAsistencia(String curso) {
        return new Asistencia(this, "Curso: " + curso);
    }
}

