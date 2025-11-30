package com.medicalteachingcoordination.Estudiante;

import com.medicalteachingcoordination.Misc.RegistraAsistencia;
import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Misc.Asistencia;

/**
 * Clase instanciable que hereda de la clase Usuario e implementa la interfaz
 * RegistrarAsistencia.
 * Contiene el atributo matricula que funciona como ID, metodo de la interfaz.
 * 
 * @version 1.0
 * @author Jorge Araujo Hernández
 */
public class Estudiante extends Usuario implements RegistraAsistencia {
    private String matricula;

    /**
     * Constructor de la clase Estudiante, llama a super de la clase Usuario.
     * 
     * @param nombre     Nombre completo del usuario.
     * @param usuario    Nombre de usuario para iniciar sesión.
     * @param contrasena Contraseña del usuario.
     * @param matricula  Matrícula del estudiante.
     */
    public Estudiante(String nombre, String usuario, char[] contrasena, String matricula) {
        super(nombre, usuario, contrasena, "estudiante");
        this.matricula = matricula;
    }

    /**
     * Metodo para obtener la matricula del Estudiante.
     * 
     * @return Matrícula del estudiante.
     */
    public String getmatricula() {
        return this.matricula;
    }

    /**
     * Metodo para establecer la matricula del Estudiante.
     * 
     * @param matricula Matrícula del estudiante.
     */
    public void setmatricula(String matricula) {
        this.matricula = matricula;
    }

    /**
     * Metodo para instanciar un objeto tipo Asistencia.
     * 
     * @return Objeto de tipo Asistencia.
     */
    public Asistencia registrarAsistencia(String curso) {
        return new Asistencia(this, "Curso: " + curso);
    }
}
