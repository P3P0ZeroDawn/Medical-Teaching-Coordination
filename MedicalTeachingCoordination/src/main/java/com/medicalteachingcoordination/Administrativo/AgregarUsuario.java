package com.medicalteachingcoordination.Administrativo;

import java.util.ArrayList;

import com.medicalteachingcoordination.Estudiante.Estudiante;
import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Misc.Contador;
import com.medicalteachingcoordination.Misc.GenerarCodigo;

public class AgregarUsuario {

    public ArrayList<Usuario> agregarUsuario(String nombre, String apellido, char[] contrasena, String tipo,
            Contador contadorUSuarios, ArrayList<Usuario> usuarios) {
        if (tipo == "estudiante") {
            usuarios.add(new Estudiante(nombre, apellido, contrasena,
                    new GenerarCodigo(contadorUSuarios).generarCodigo(tipo)));
        } else {
            usuarios.add(new Administrativo(nombre, apellido, contrasena,
                    new GenerarCodigo(contadorUSuarios).generarCodigo(tipo)));
        }
        return usuarios;
    }
}
