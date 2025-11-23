package com.medicalteachingcoordination.Administrativo;

import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Misc.Contador;
import com.medicalteachingcoordination.Misc.RegistraAsistencia;
import com.medicalteachingcoordination.Misc.Asistencia;

public class Administrativo extends Usuario implements RegistraAsistencia{
    private String clave;

    public Administrativo(String nombre, String usuario, char[] contrasena, Contador contador) {
        super(nombre, usuario, contrasena, "administrativo");
        clave = "administrativo" + contador.getContador();
        contador.incrementarContador();
    }

    public String getClave() {
        return clave;
    }

    public Asistencia registrarAsistencia(){
        return new Asistencia(this);
    }
}
