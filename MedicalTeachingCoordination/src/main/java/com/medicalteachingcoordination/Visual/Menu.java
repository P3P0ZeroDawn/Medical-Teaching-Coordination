package com.medicalteachingcoordination.Visual;

import com.medicalteachingcoordination.Administrativo.Administrativo;
import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Misc.Usuario;
import com.medicalteachingcoordination.Misc.Contador;

import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.util.ArrayList;
import javax.swing.*;

public class Menu extends JPanel {

    public Menu(MainFrame frame, Usuario usuario, ArrayList<Usuario> usuarios, Contador contadorUsuarios,
            ArrayList<Curso> cursos) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        // ======= Panel izquierda =======
        GridBagConstraints left = new GridBagConstraints();
        left.gridx = 0; // Columna 0
        left.gridy = 0; // Fila 0
        left.weightx = 0; // No se expande horizontalmente
        left.weighty = 1; // Sí se estira verticalmente
        left.anchor = GridBagConstraints.NORTHWEST;
        left.fill = GridBagConstraints.VERTICAL;

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(Component.LEFT_ALIGNMENT);

        // Margen del panel izquierdo
        form.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Campos
        JLabel userLabel = new JLabel("Usuario: " + usuario.getNombre());
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);

        JLabel userType = new JLabel("Tipo de usuario: " + getUserType(usuario));
        userType.setAlignmentX(Component.LEFT_ALIGNMENT);

        form.add(userLabel);
        form.add(userType);
        form.add(Box.createVerticalStrut(20));

        // Tamaño uniforme para los botones del panel izquierdo
        Dimension buttonSize = new Dimension(150, 30);

        if (getUserType(usuario).equals("Administrativo")) {
            JButton btnReporte = new JButton("Consultar reporte");
            btnReporte.setPreferredSize(buttonSize);
            btnReporte.setMaximumSize(buttonSize);
            btnReporte.setMinimumSize(buttonSize);
            btnReporte.setAlignmentX(Component.LEFT_ALIGNMENT);
            btnReporte.addActionListener(e -> {
                // Acción para consultar reporte
            });
            form.add(btnReporte);
            form.add(Box.createVerticalStrut(15));

            JButton btnAgregarCurso = new JButton("Agregar curso");
            btnAgregarCurso.setPreferredSize(buttonSize);
            btnAgregarCurso.setMaximumSize(buttonSize);
            btnAgregarCurso.setMinimumSize(buttonSize);
            btnAgregarCurso.setAlignmentX(Component.LEFT_ALIGNMENT);
            form.add(btnAgregarCurso);
            form.add(Box.createVerticalStrut(15));
        }

        // Empuja lo que viene después (el botón de logout) hacia el fondo
        form.add(Box.createVerticalGlue());

        JButton btnLogout = new JButton("Cerrar sesión");
        btnLogout.setPreferredSize(buttonSize);
        btnLogout.setMaximumSize(buttonSize);
        btnLogout.setMinimumSize(buttonSize);
        btnLogout.setAlignmentX(Component.LEFT_ALIGNMENT);
        btnLogout.addActionListener(e -> {
            frame.mostrarVista("login", usuarios);
        });
        form.add(btnLogout);
        form.add(Box.createVerticalStrut(15));

        add(form, left);

        /*
         * ============================
         * SEPARADOR VERTICAL
         * ============================
         */
        JSeparator separator = new JSeparator(SwingConstants.VERTICAL);
        separator.setPreferredSize(new Dimension(5, 1)); // ancho 5px aprox

        GridBagConstraints sep = new GridBagConstraints();
        sep.gridx = 1;
        sep.gridy = 0;
        sep.fill = GridBagConstraints.VERTICAL;
        sep.weightx = 0;
        sep.weighty = 1;
        add(separator, sep);

        // ======= Panel derecha =======
        JPanel panelDerecha = new JPanel();
        panelDerecha.add(new JLabel("Aquí va la info de la derecha"));
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.Y_AXIS));
        panelDerecha.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // Config de GridBag para la derecha
        GridBagConstraints right = new GridBagConstraints();
        right.gridx = 2; // Columna 1
        right.gridy = 0; // Fila 0
        right.weightx = 1; // Se expande horizontalmente
        right.weighty = 1; // Se expande verticalmente
        right.anchor = GridBagConstraints.NORTHWEST;
        right.fill = GridBagConstraints.BOTH;

        add(panelDerecha, right);
    }

    public String getUserType(Usuario usuario) {
        if (usuario instanceof Administrativo) {
            return "Administrativo";
        }
        // Agregar más tipos de usuario según sea necesario
        return "Desconocido";
    }
}
