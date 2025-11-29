package com.medicalteachingcoordination.Visual;

import javax.swing.*;
import java.awt.*;
import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Administrativo.AgregarEstudiantesACurso;
import com.medicalteachingcoordination.Estudiante.Estudiante;

public class AgregarEstudianteACurso extends JPanel {

    public AgregarEstudianteACurso(MainFrame frame, ContenedorEntidades contenedor) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(CENTER_ALIGNMENT);

        JLabel mainLabel = new JLabel("Agregar estudiante a curso");
        mainLabel.setFont(mainLabel.getFont().deriveFont(30.0f));
        mainLabel.setPreferredSize(new Dimension(600, 40));
        mainLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        mainLabel.setMinimumSize(new Dimension(600, 40));
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Campos
        JLabel estudianteLabel = new JLabel("Estudiante:");
        estudianteLabel.setAlignmentX(CENTER_ALIGNMENT);
        JComboBox<String> estudianteField = new JComboBox<>();
        estudianteField.setMaximumSize(new Dimension(250, 30));
        estudianteField.setPreferredSize(new Dimension(250, 30));
        estudianteField.setMinimumSize(new Dimension(250, 30));
        for(Usuario usuario : contenedor.getUsuarios()){
            if(usuario.getTipo().equals("estudiante")){
                estudianteField.addItem(usuario.getNombre());
            }
        }

        JLabel cursoLabel = new JLabel("Curso:");
        cursoLabel.setAlignmentX(CENTER_ALIGNMENT);
        JComboBox<String> cursoField = new JComboBox<>();
        cursoField.setMaximumSize(new Dimension(250, 30));
        cursoField.setPreferredSize(new Dimension(250, 30));
        cursoField.setMinimumSize(new Dimension(250, 30));
        for(Curso curso : contenedor.getCursos()){
            cursoField.addItem(curso.getNombre());
        }

        JButton btn = new JButton("Agregar Usuario al curso");
        btn.setAlignmentX(CENTER_ALIGNMENT);

        btn.addActionListener(e -> {
            int agregado = new AgregarEstudiantesACurso().agregarEstudiantesACurso(
                    contenedor.getCursoPorNombre((String)cursoField.getSelectedItem()),
                    (Estudiante) contenedor.getUsuarioPorNombre((String)estudianteField.getSelectedItem())
            );
            if(agregado == 3){
                JOptionPane.showMessageDialog(this, "Estudiante agregado al curso exitosamente.");
            } else if(agregado == 2){
                JOptionPane.showMessageDialog(this, "Error: El estudiante ya está inscrito en el curso.");
            } else {
                JOptionPane.showMessageDialog(this, "Error: Curso o estudiante no válido.");
            }
            
        });

        // Alinear todos al centro
        mainLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Ensamblar UI con espacios
        Dimension buttonSize = new Dimension(150, 30);

        form.add(Box.createVerticalStrut(30));
        form.add(mainLabel);
        form.add(Box.createVerticalStrut(60));

        form.add(estudianteLabel);
        form.add(estudianteField);
        form.add(Box.createVerticalStrut(10));

        form.add(cursoLabel);
        form.add(cursoField);
        form.add(Box.createVerticalStrut(20));

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
}
