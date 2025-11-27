package com.medicalteachingcoordination.Visual;

import javax.swing.*;

import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Misc.Usuario;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import java.awt.GridBagConstraints;

public class CursoEspecifico extends JPanel {

    public CursoEspecifico(MainFrame frame, Curso curso, Usuario usuario, ArrayList<Usuario> usuarios, ArrayList<Curso> cursos) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(CENTER_ALIGNMENT);

        JLabel mainLabel = new JLabel(curso.getNombre());
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
        form.add(btnAsistencia);
        form.add(Box.createVerticalStrut(10));

        JButton btnConstancia = new JButton("Subir Constancia");
        btnConstancia.setPreferredSize(buttonSize);
        btnConstancia.setMaximumSize(buttonSize);
        btnConstancia.setMinimumSize(buttonSize);
        btnConstancia.setAlignmentX(CENTER_ALIGNMENT);
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
            frame.mostrarVista("cursos", cursos, usuario, usuarios);
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
