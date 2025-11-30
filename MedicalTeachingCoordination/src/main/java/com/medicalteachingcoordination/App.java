package com.medicalteachingcoordination;

import javax.swing.SwingUtilities;

import com.medicalteachingcoordination.Visual.MainFrame;
import com.medicalteachingcoordination.Visual.ContenedorEntidades;
import com.medicalteachingcoordination.Administrativo.Administrativo;
import com.medicalteachingcoordination.Misc.GenerarCodigo;

/**
 * Clase principal para iniciar la aplicación de Coordinación de Enseñanza
 *
 */
public class App {
    public static void main(String[] args) {

        ContenedorEntidades contenedor = new ContenedorEntidades();

        Administrativo admin1 = new Administrativo("Admin Por Defecto", "admin1",
                new char[] { 'p', 'a', 's', 's', '1' },
                new GenerarCodigo(contenedor.getContadorUsuarios()).generarCodigo("admin"));

        contenedor.getUsuarios().add(admin1);

        SwingUtilities.invokeLater(() -> new MainFrame(contenedor).setVisible(true));
    }
}
