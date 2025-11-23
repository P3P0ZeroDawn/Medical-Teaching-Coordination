package com.medicalteachingcoordination.Visual;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.util.ArrayList;
import javax.swing.*;
import com.medicalteachingcoordination.Misc.Usuario; 

public class Login extends JPanel {

    public Login(MainFrame frame, ArrayList<Usuario> usuarios) {

         // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setPreferredSize(new Dimension(300, 200));

        // Campos
        JLabel userLabel = new JLabel("Usuario:");
        JTextField userField = new JTextField();
        userField.setMaximumSize(new Dimension(250, 30));

        JLabel passLabel = new JLabel("Contraseña:");
        JPasswordField passField = new JPasswordField();
        passField.setMaximumSize(new Dimension(250, 30));

        JButton btn = new JButton("Entrar");
        btn.setAlignmentX(CENTER_ALIGNMENT);

        btn.addActionListener( e -> {
            if (autenticar(userField.getText(), passField.getPassword(), usuarios)) {
                frame.mostrarVista("menu");
            } else {
                JOptionPane.showMessageDialog(frame, "Usuario o contraseña incorrectos");
            }
        });
        
        // Alinear todos al centro
        userLabel.setAlignmentX(CENTER_ALIGNMENT);
        userField.setAlignmentX(CENTER_ALIGNMENT);
        passLabel.setAlignmentX(CENTER_ALIGNMENT);
        passField.setAlignmentX(CENTER_ALIGNMENT);

        // Ensamblar UI con espacios
        form.add(userLabel);
        form.add(userField);
        form.add(Box.createVerticalStrut(10));

        form.add(passLabel);
        form.add(passField);
        form.add(Box.createVerticalStrut(15));

        form.add(btn);

        add(form);
    }
        

    private boolean autenticar(String usuario, char[] contrasena, ArrayList<Usuario> usuarios) {
        for (Usuario user : usuarios) {
                if(user.iniciarSesion(usuario, contrasena)) {
                    return true;
            }
        }
        return false;
    }
}
