package com.medicalteachingcoordination.Visual;

import javax.swing.*;
import com.medicalteachingcoordination.Estudiante.Estudiante;
import com.medicalteachingcoordination.Estudiante.EstudianteSubirConstancia;

import java.awt.*;

public class SubirConstancia extends JPanel {

    public SubirConstancia(MainFrame frame, ContenedorEntidades contenedor) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(CENTER_ALIGNMENT);

        JLabel mainLabel = new JLabel("Subir constancia para el curso: " + contenedor.getCursoEspecifico().getNombre());
        mainLabel.setFont(mainLabel.getFont().deriveFont(30.0f));
        mainLabel.setPreferredSize(new Dimension(600, 40));
        mainLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        mainLabel.setMinimumSize(new Dimension(600, 40));
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);

        JLabel cursoClaveLabel = new JLabel("Clave de constancia:");
        cursoClaveLabel.setAlignmentX(CENTER_ALIGNMENT);
        JTextField cursoClaveField = new JTextField();
        cursoClaveField.setMaximumSize(new Dimension(250, 30));
        cursoClaveField.setPreferredSize(new Dimension(250, 30));
        cursoClaveField.setMinimumSize(new Dimension(250, 30));

        JButton btn = new JButton("Subir constancia");
        btn.setAlignmentX(CENTER_ALIGNMENT);

        btn.addActionListener(e -> {
            if (cursoClaveField.getText().isEmpty()) {
                JOptionPane.showMessageDialog(this, "Por favor ingrese un valor");
            }else{
                int subido = new EstudianteSubirConstancia().subirConstancia(cursoClaveField.getText(), contenedor.getCursoEspecifico().getNombre(), (Estudiante) contenedor.getUsuarioActual(), contenedor.getConstancias());
                switch (subido) {
                    case 1:
                        JOptionPane.showMessageDialog(this, "La constancia esta presente en el sistema para su validacion, no es necesario volverla a subir");
                        break;
                    case 2:
                        JOptionPane.showMessageDialog(this, "La constancia ya fue validada anteriormente, no es necesario volverla a subir");
                        break;
                    case 3:
                        JOptionPane.showMessageDialog(this, "Se subio la constancia correctamente para su validacion");
                        break;
                    case 0:
                        JOptionPane.showMessageDialog(this, "La constancia contiene un curso invalido");
                        break;
                    default:
                        break;
                }   
            }     
        });

        // Alinear todos al centro
        mainLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Ensamblar UI con espacios
        Dimension buttonSize = new Dimension(150, 30);

        form.add(Box.createVerticalStrut(30));
        form.add(mainLabel);
        form.add(Box.createVerticalStrut(60));

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
