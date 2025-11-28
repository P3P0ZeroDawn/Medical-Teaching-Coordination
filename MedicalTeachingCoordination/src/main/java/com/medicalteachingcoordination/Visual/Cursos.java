package com.medicalteachingcoordination.Visual;

import javax.swing.*;
import java.util.ArrayList;
import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Misc.Usuario;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class Cursos extends JPanel {

    public Cursos(MainFrame frame, ContenedorEntidades contenedor) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(CENTER_ALIGNMENT);

        JLabel mainLabel = new JLabel("Bienvenido, " + contenedor.getUsuarioActual().getNombre());
        mainLabel.setFont(mainLabel.getFont().deriveFont(30.0f));
        mainLabel.setPreferredSize(new Dimension(600, 40));
        mainLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        mainLabel.setMinimumSize(new Dimension(600, 40));
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Alinear todos al centro
        mainLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Ensamblar UI con espacios
        form.add(Box.createVerticalStrut(30));
        form.add(mainLabel);
        form.add(Box.createVerticalStrut(8));

        Dimension buttonSize = new Dimension(150, 30);

        ArrayList<Curso> userCourses = new ArrayList<>();

        for (Curso curso : contenedor.getCursos()) {
            if (curso.getEstudiantes().contains(contenedor.getUsuarioActual())) {
                userCourses.add(curso);
            }
        }

        if (userCourses.isEmpty()) {
            JLabel noCoursesLabel = new JLabel("No estás inscrito en ningún curso.");
            noCoursesLabel.setFont(noCoursesLabel.getFont().deriveFont(15.0f));
            noCoursesLabel.setAlignmentX(CENTER_ALIGNMENT);
            form.add(noCoursesLabel);
            form.add(Box.createVerticalStrut(10));
        } else {
            JLabel firstLabel = new JLabel("Tus cursos:");
            firstLabel.setFont(firstLabel.getFont().deriveFont(15.0f));
            firstLabel.setAlignmentX(CENTER_ALIGNMENT);
            form.add(firstLabel);
            form.add(Box.createVerticalStrut(20));
            for (Curso curso : userCourses) {
                JButton btnCurso = new JButton(curso.getNombre());
                btnCurso.setPreferredSize(buttonSize);
                btnCurso.setMaximumSize(buttonSize);
                btnCurso.setMinimumSize(buttonSize);
                btnCurso.setAlignmentX(CENTER_ALIGNMENT);
                form.add(btnCurso);
                form.add(Box.createVerticalStrut(10));
                btnCurso.addActionListener(e -> {
                    contenedor.setCursoEspecifico(curso);
                    frame.mostrarVista("cursoEspecifico");
                });
            }
        }

        form.add(Box.createVerticalStrut(10));

        // Empuja el botón de logout hacia el borde inferior
        form.add(Box.createVerticalGlue());

        JButton btnLogout = new JButton("Cerrar sesión");
        btnLogout.setPreferredSize(buttonSize);
        btnLogout.setMaximumSize(buttonSize);
        btnLogout.setMinimumSize(buttonSize);
        btnLogout.setAlignmentX(CENTER_ALIGNMENT);
        btnLogout.setAlignmentY(BOTTOM_ALIGNMENT);
        btnLogout.addActionListener(e -> {
            frame.mostrarVista("login");
        });
        form.add(btnLogout);
        form.add(Box.createVerticalStrut(15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        // Permitir que el panel `form` se expanda verticalmente
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        add(form, gbc);
    }
}
