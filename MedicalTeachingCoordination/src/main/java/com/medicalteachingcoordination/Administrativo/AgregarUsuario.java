package com.medicalteachingcoordination.Administrativo;

import java.util.ArrayList;

import com.medicalteachingcoordination.Estudiante.Estudiante;
import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Misc.Contador;
import com.medicalteachingcoordination.Misc.GenerarCodigo;

public class AgregarUsuario {

    public int agregarUsuario(String nombre, String usuario, char[] contrasena, String tipo, Contador contadorUsuarios, ArrayList<Usuario> usuarios) {
        if (nombre.isEmpty()) {
            return 1; // Nombre vacio
        }
        if (usuario.isEmpty()) {
            return 2; // Usuario vacio
        }
        if (contrasena.length == 0) {
            return 3; // Contrasena vacia
        }
        if (tipo.isEmpty()) {
            return 4; // Tipo vacio
        }
        if (existeUsuario(usuario, usuarios)) {
            return 5; // Usuario ya existe
        }
        if (tipo == "estudiante") {
            usuarios.add(new Estudiante(nombre, usuario, contrasena,
                    new GenerarCodigo(contadorUsuarios).generarCodigo(tipo)));
                    return 6;
        } else {
            usuarios.add(new Administrativo(nombre, usuario, contrasena,
                    new GenerarCodigo(contadorUsuarios).generarCodigo(tipo)));
                    return 7;
        }
    }

    public boolean existeUsuario(String usuario, ArrayList<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }
}
