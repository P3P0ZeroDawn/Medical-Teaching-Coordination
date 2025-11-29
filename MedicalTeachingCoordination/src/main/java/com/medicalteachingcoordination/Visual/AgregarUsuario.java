package com.medicalteachingcoordination.Visual;

import javax.swing.*;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;

public class AgregarUsuario extends JPanel {

    public AgregarUsuario(MainFrame frame, ContenedorEntidades contenedor) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(CENTER_ALIGNMENT);

        JLabel mainLabel = new JLabel("Agregar Usuario");
        mainLabel.setFont(mainLabel.getFont().deriveFont(30.0f));
        mainLabel.setPreferredSize(new Dimension(600, 40));
        mainLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        mainLabel.setMinimumSize(new Dimension(600, 40));
        mainLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Campos
        JLabel usuarioNameLabel = new JLabel("Nombre:");
        usuarioNameLabel.setAlignmentX(CENTER_ALIGNMENT);
        JTextField usuarioNameField = new JTextField();
        usuarioNameField.setMaximumSize(new Dimension(250, 30));
        usuarioNameField.setPreferredSize(new Dimension(250, 30));
        usuarioNameField.setMinimumSize(new Dimension(250, 30));

        JLabel usuarioLabel = new JLabel("Usuario:");
        usuarioLabel.setAlignmentX(CENTER_ALIGNMENT);
        JTextField usuarioField = new JTextField();
        usuarioField.setMaximumSize(new Dimension(250, 30));
        usuarioField.setPreferredSize(new Dimension(250, 30));
        usuarioField.setMinimumSize(new Dimension(250, 30));

        JLabel contrasenaLabel = new JLabel("Contraseña:");
        contrasenaLabel.setAlignmentX(CENTER_ALIGNMENT);
        JPasswordField contrasenaField = new JPasswordField();
        contrasenaField.setMaximumSize(new Dimension(250, 30));
        contrasenaField.setPreferredSize(new Dimension(250, 30));
        contrasenaField.setMinimumSize(new Dimension(250, 30));

        JLabel tipoLabel = new JLabel("Tipo de Usuario:");
        tipoLabel.setAlignmentX(CENTER_ALIGNMENT);
        JRadioButton estudianteRadio = new JRadioButton("Estudiante");
        estudianteRadio.setAlignmentX(CENTER_ALIGNMENT);
        JRadioButton administrativoRadio = new JRadioButton("Administrativo");
        administrativoRadio.setAlignmentX(CENTER_ALIGNMENT);
        ButtonGroup tipoGroup = new ButtonGroup();
        tipoGroup.add(estudianteRadio);
        tipoGroup.add(administrativoRadio);

        JButton btn = new JButton("Agregar Usuario");
        btn.setAlignmentX(CENTER_ALIGNMENT);

        btn.addActionListener(e -> {
            int agregado = new com.medicalteachingcoordination.Administrativo.AgregarUsuario()
                    .agregarUsuario(
                            usuarioNameField.getText(),
                            usuarioField.getText(),
                            contrasenaField.getPassword(),
                            estudianteRadio.isSelected() ? "estudiante" : administrativoRadio.isSelected() ? "administrativo" : "",
                            contenedor.getContadorUsuarios(),
                            contenedor.getUsuarios()
                    );
            if (agregado == 1) {
                JOptionPane.showMessageDialog(frame, "El nombre del usuario no puede estar vacio");
            } else if (agregado == 2) {
                JOptionPane.showMessageDialog(frame, "El nombre de usuario no puede estar vacio");
            } else if (agregado == 3) {
                JOptionPane.showMessageDialog(frame, "La contraseña no puede estar vacia");
            } else if (agregado == 4) {
                JOptionPane.showMessageDialog(frame, "El tipo de usuario no puede estar vacio");
            } else if (agregado == 5) {
                JOptionPane.showMessageDialog(frame, "Ya existe un usuario con ese nombre de usuario");
            } else if(agregado == 6){
                JOptionPane.showMessageDialog(frame, "Estudiante agregado exitosamente");
            } else if(agregado == 7){
                JOptionPane.showMessageDialog(frame, "Administrativo agregado exitosamente");
            }
        });

        // Alinear todos al centro
        mainLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Ensamblar UI con espacios
        Dimension buttonSize = new Dimension(150, 30);

        form.add(Box.createVerticalStrut(30));
        form.add(mainLabel);
        form.add(Box.createVerticalStrut(60));

        form.add(usuarioNameLabel);
        form.add(usuarioNameField);
        form.add(Box.createVerticalStrut(10));

        form.add(usuarioLabel);
        form.add(usuarioField);
        form.add(Box.createVerticalStrut(10));

        form.add(contrasenaLabel);
        form.add(contrasenaField);
        form.add(Box.createVerticalStrut(10));

        form.add(tipoLabel);
        form.add(estudianteRadio);
        form.add(administrativoRadio);
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
