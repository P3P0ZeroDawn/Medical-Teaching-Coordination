package com.medicalteachingcoordination.Visual;

import javax.swing.*;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

import com.medicalteachingcoordination.Estudiante.Estudiante;
import com.medicalteachingcoordination.Misc.Asistencia;

public class CursoEspecifico extends JPanel {

    public CursoEspecifico(MainFrame frame, ContenedorEntidades contenedor) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(CENTER_ALIGNMENT);

        JLabel mainLabel = new JLabel(contenedor.getCursoEspecifico().getNombre());
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
        form.add(Box.createVerticalStrut(60));

        Dimension buttonSize = new Dimension(150, 30);

        JButton btnAsistencia = new JButton("Registrar Asistencia");
        btnAsistencia.setPreferredSize(buttonSize);
        btnAsistencia.setMaximumSize(buttonSize);
        btnAsistencia.setMinimumSize(buttonSize);
        btnAsistencia.setAlignmentX(CENTER_ALIGNMENT);
        btnAsistencia.addActionListener(e -> {
            Estudiante estudiante = (Estudiante) contenedor.getUsuarioActual();
            Asistencia asistencia = estudiante.registrarAsistencia(contenedor.getCursoEspecifico().getNombre());
            contenedor.getAsistencias().add(asistencia);
            JOptionPane.showMessageDialog(this, "Asistencia registrada correctamente.");
        });
        form.add(btnAsistencia);
        form.add(Box.createVerticalStrut(10));
        

        JButton btnConstancia = new JButton("Subir Constancia");
        btnConstancia.setPreferredSize(buttonSize);
        btnConstancia.setMaximumSize(buttonSize);
        btnConstancia.setMinimumSize(buttonSize);
        btnConstancia.setAlignmentX(CENTER_ALIGNMENT);
        btnConstancia.addActionListener(e -> {
            frame.mostrarVista("subirConstancia", contenedor);
        });
        form.add(btnConstancia);
        form.add(Box.createVerticalStrut(10));

        form.add(Box.createVerticalStrut(10));

        form.add(Box.createVerticalGlue());

        JButton btnBack = new JButton("Regresar");
        btnBack.setPreferredSize(buttonSize);
        btnBack.setMaximumSize(buttonSize);
        btnBack.setMinimumSize(buttonSize);
        btnBack.setAlignmentX(CENTER_ALIGNMENT);
        btnBack.addActionListener(e -> {
            frame.mostrarVista("cursos", contenedor);
        });
        form.add(btnBack);
        form.add(Box.createVerticalStrut(15));

        GridBagConstraints gbc = new GridBagConstraints();
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.weightx = 1.0;
        gbc.weighty = 1.0;
        gbc.fill = GridBagConstraints.BOTH;
        gbc.anchor = GridBagConstraints.CENTER;
        add(form, gbc);
    }
}
