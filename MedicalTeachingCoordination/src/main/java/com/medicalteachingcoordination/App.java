package com.medicalteachingcoordination;

import javax.swing.SwingUtilities;

import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Visual.MainFrame;
import com.medicalteachingcoordination.Administrativo.Administrativo;
import com.medicalteachingcoordination.Misc.GenerarCodigo;
import com.medicalteachingcoordination.Misc.Asistencia;
import com.medicalteachingcoordination.Misc.Contador;
import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Estudiante.Estudiante;
import java.util.ArrayList;

/**
 * Hello world!
 *
 */
public class App {
    public static void main(String[] args) {

        ArrayList<Usuario> usuarios = new ArrayList<>();
        ArrayList<Asistencia> asistencias = new ArrayList<>();
        ArrayList<Curso> cursos = new ArrayList<>();
        ArrayList<GestionarConstancias> constancias = new ArrayList<>();

        Contador contadorUsuarios = new Contador();

        Administrativo admin1 = new Administrativo("Admin Por Defecto", "admin1",
                new char[] { 'p', 'a', 's', 's', '1' }, new GenerarCodigo(contadorUsuarios).generarCodigo("admin"));

        usuarios.add(admin1);

        Estudiante estudiante1 = new Estudiante("Estudiante Por Defecto", "estudiante1",
                new char[] { 'p', 'a', 's', 's', '1' }, new GenerarCodigo(contadorUsuarios).generarCodigo("estudiante"));

        usuarios.add(estudiante1);

        Curso curso1 = new Curso("Anatomía Humana", "AH-2025/11-SGEM");

        cursos.add(curso1);

        curso1.getEstudiantes().add(estudiante1);

        SwingUtilities.invokeLater(() -> new MainFrame(usuarios, asistencias, cursos, constancias, contadorUsuarios).setVisible(true));
    }
}
