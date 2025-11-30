package com.medicalteachingcoordination.Administrativo;

import java.util.ArrayList;

import com.medicalteachingcoordination.Estudiante.Estudiante;
import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Misc.Contador;
import com.medicalteachingcoordination.Misc.GenerarCodigo;

/**
 * Clase que permite agregar usuarios al sistema.
 * 
 * @version 1.0
 * @author Pedro Enrique Sánchez Rodríguez
 */
public class AgregarUsuario {

    /**
     * Metodo para agregar un usuario al sistema.
     * 
     * @param nombre           Nombre completo del usuario.
     * @param usuario          Nombre de usuario para iniciar sesión.
     * @param contrasena       Contraseña del usuario.
     * @param tipo             Tipo de usuario (estudiante o administrativo).
     * @param contadorUsuarios Contador para generar códigos únicos.
     * @param usuarios         Lista de usuarios existentes en el sistema.
     * @return Código de estado indicando el resultado de la operación. 1-5 para
     *         errores,
     *         6 para estudiante agregado, 7 para administrativo agregado.
     */
    public int agregarUsuario(String nombre, String usuario, char[] contrasena, String tipo, Contador contadorUsuarios,
            ArrayList<Usuario> usuarios) {
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

    /**
     * Metodo para verificar si un usuario ya existe en el sistema.
     * 
     * @param usuario  Nombre de usuario a verificar.
     * @param usuarios Lista de usuarios existentes en el sistema.
     * @return true si el usuario existe, false en caso contrario.
     */
    public boolean existeUsuario(String usuario, ArrayList<Usuario> usuarios) {
        for (Usuario u : usuarios) {
            if (u.getUsuario().equals(usuario)) {
                return true;
            }
        }
        return false;
    }
}
