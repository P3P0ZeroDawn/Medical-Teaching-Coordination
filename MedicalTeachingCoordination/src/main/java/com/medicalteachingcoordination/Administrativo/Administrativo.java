package com.medicalteachingcoordination.Administrativo;

import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Misc.RegistraAsistencia;
import com.medicalteachingcoordination.Misc.Asistencia;

/**
 * Clase instanciable que hereda de la clase Usuario e implementa la interfaz
 * RegistrarAsistencia.
 * Contiene el atributo clave que funciona como ID, metodo de la interfaz.
 * 
 * @version 1.0
 * @author Pedro Enrique Sánchez Rodríguez
 */
public class Administrativo extends Usuario implements RegistraAsistencia {
    private String clave;

    /**
     * Constructor de la clase Administrativo, llama a super de la clase Usuario.
     * 
     * @param nombre     Nombre completo del usuario.
     * @param usuario    Nombre de usuario para iniciar sesión.
     * @param contrasena Contraseña del usuario.
     * @param contador   Contador para generar la clave del Administrativo
     */
    public Administrativo(String nombre, String usuario, char[] contrasena, String clave) {
        super(nombre, usuario, contrasena, "administrativo");
        this.clave = clave;
    }

    /**
     * Metodo para obtener la clave del Administrativo.
     * 
     * @return Clave del Administrativo.
     */
    public String getClave() {
        return clave;
    }

    /**
     * Metodo para instanciar un objeto tipo Asistencia.
     * 
     * @return Objeto de tipo Asistencia.
     */
    public Asistencia registrarAsistencia(String info) {
        return new Asistencia(this, info);
    }
}
