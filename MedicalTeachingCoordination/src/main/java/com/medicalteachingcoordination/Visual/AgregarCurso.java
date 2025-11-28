package com.medicalteachingcoordination.Visual;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import com.medicalteachingcoordination.Curso.Curso;

public class AgregarCurso extends JPanel {

    public AgregarCurso(MainFrame frame, ContenedorEntidades contenedor) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(CENTER_ALIGNMENT);

        JLabel mainLabel = new JLabel("Agregar Curso");
        mainLabel.setFont(mainLabel.getFont().deriveFont(30.0f));
        mainLabel.setPreferredSize(new Dimension(600, 40));
        mainLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        mainLabel.setMinimumSize(new Dimension(600, 40));
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Campos
        JLabel cursoNameLabel = new JLabel("Nombre del Curso:");
        cursoNameLabel.setAlignmentX(CENTER_ALIGNMENT);
        JTextField cursoNameField = new JTextField();
        cursoNameField.setMaximumSize(new Dimension(250, 50));

        JLabel cursoClaveLabel = new JLabel("Clave para validacion de constancias:");
        cursoClaveLabel.setAlignmentX(CENTER_ALIGNMENT);
        JTextField cursoClaveField = new JTextField();
        cursoClaveField.setMaximumSize(new Dimension(250, 50));

        JButton btn = new JButton("Registrar Curso");
        btn.setAlignmentX(CENTER_ALIGNMENT);

        btn.addActionListener(e -> {
            if (!existeCurso(cursoNameField.getText(), contenedor)) {
                Curso nuevoCurso = new Curso(cursoNameField.getText(), cursoClaveField.getText());
                contenedor.getCursos().add(nuevoCurso);
                JOptionPane.showMessageDialog(frame, "Curso registrado exitosamente");
                cursoNameField.setText("");
                cursoClaveField.setText("");
            } else {
                JOptionPane.showMessageDialog(frame, "Ya existe un curso con ese nombre");
            }
        });

        // Alinear todos al centro
        mainLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Ensamblar UI con espacios
        Dimension buttonSize = new Dimension(150, 30);

        form.add(Box.createVerticalStrut(30));
        form.add(mainLabel);
        form.add(Box.createVerticalStrut(60));

        form.add(cursoNameLabel);
        form.add(cursoNameField);
        form.add(Box.createVerticalStrut(10));

        form.add(cursoClaveLabel);
        form.add(cursoClaveField);
        form.add(Box.createVerticalStrut(15));

        form.add(btn);

        form.add(Box.createVerticalGlue());

        JButton btnBack = new JButton("Regresar");
        btnBack.setPreferredSize(buttonSize);
        btnBack.setMaximumSize(buttonSize);
        btnBack.setMinimumSize(buttonSize);
        btnBack.setAlignmentX(CENTER_ALIGNMENT);
        btnBack.addActionListener(e -> {
            frame.mostrarVista("menu", contenedor);
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

    private boolean existeCurso(String nombre, ContenedorEntidades contenedor) {
        for (Curso curso : contenedor.getCursos()) {
            if (curso.getNombre().equalsIgnoreCase(nombre)) {
                return true;
            }
        }
        return false;
    }
}
