package com.medicalteachingcoordination.Misc;
/**
 * Clase abstracta que representa un usuario en el sistema de coordinación médica.
 * Contiene atributos y métodos comunes para todos los tipos de usuarios.
 * @version 1.0
 * @author Pedro Enrique Sánchez Rodríguez
 */
public abstract class Usuario {
    protected String nombre;
    protected String usuario;
    protected String contrasena;
    protected String tipo;

    /**
     * Constructor de la clase Usuario.
     * @param nombre Nombre completo del usuario.
     * @param usuario Nombre de usuario para iniciar sesión.
     * @param contrasena Contraseña del usuario.
     * @param tipo Tipo de usuario ("estudiante" o "administrativo").
     */
    public Usuario(String nombre, String usuario, String contrasena, String tipo) {
        this.nombre = nombre;
        this.usuario = usuario;
        this.contrasena = contrasena;
        this.tipo = tipo;
    }

    /**
     * Método para obtener el nombre del usuario.
     * @return Nombre completo del usuario.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Método para obtener el nombre de usuario.
     * @return Nombre de usuario.
     */
    public String getUsuario() {
        return usuario;
    }
    /**
     * Método para obtener la contraseña del usuario.
     * @return Contraseña del usuario.
     */
    public String getContrasena() {
        return contrasena;
    }
    /**
     * Método para obtener el tipo de usuario.
     * @return Tipo de usuario ("estudiante" o "administrativo").
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * Método para establecer el nombre del usuario.
     * @param nombre Nombre completo del usuario.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Método para establecer el nombre de usuario.
     * @param usuario Nombre de usuario.
     */
    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
    /**
     * Método para establecer la contraseña del usuario.
     * @param contrasena Contraseña del usuario.
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    /**
     * Método para establecer el tipo de usuario.
     * @param tipo Tipo de usuario ("estudiante" o "administrativo").
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * Método para iniciar sesión.
     * @param usuario Nombre de usuario.
     * @param contrasena Contraseña del usuario.
     * @return true si las credenciales son correctas, false en caso contrario.
     */
    public boolean iniciarSesion(String usuario, String contrasena) {
        if (this.usuario.equals(usuario) && this.contrasena.equals(contrasena)) {
            return true;
        }
        return false;
    };
}
