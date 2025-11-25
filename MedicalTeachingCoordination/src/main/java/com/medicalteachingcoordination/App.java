package com.medicalteachingcoordination;

import javax.swing.SwingUtilities;

import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Visual.MainFrame;
import com.medicalteachingcoordination.Administrativo.Administrativo;
import com.medicalteachingcoordination.Misc.GenerarCodigo;
import com.medicalteachingcoordination.Misc.Asistencia;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {
        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Asistencia> asistencias = new ArrayList<>();
        GenerarCodigo genCodigoAdministrativos = new GenerarCodigo();
        Administrativo admin1 = new Administrativo("Admin Por Defecto", "admin1",
                new char[] { 'p', 'a', 's', 's', '1' }, genCodigoAdministrativos);
        usuarios.add(admin1);
        SwingUtilities.invokeLater(() -> new MainFrame(usuarios).setVisible(true));
    }
}
