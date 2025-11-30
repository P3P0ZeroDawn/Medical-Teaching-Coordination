package com.medicalteachingcoordination.Visual;

import com.medicalteachingcoordination.Administrativo.*;
import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Misc.Usuario;

import javax.swing.*;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;

public class Menu extends JPanel {

    public Menu(MainFrame frame, ContenedorEntidades contenedor) {
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
        JLabel userLabel = new JLabel("Usuario: " + contenedor.getUsuarioActual().getNombre());
        userLabel.setAlignmentX(Component.LEFT_ALIGNMENT);
        userLabel.setFont(getFont().deriveFont(15.0f));

        JLabel userType = new JLabel("Tipo de usuario: " + contenedor.getUsuarioActual().getClass().getSimpleName());
        userType.setAlignmentX(Component.LEFT_ALIGNMENT);
        userType.setFont(getFont().deriveFont(15.0f));

        form.add(userLabel);
        form.add(userType);
        form.add(Box.createVerticalStrut(20));

        // Tamaño uniforme para los botones del panel izquierdo
        Dimension buttonSize = new Dimension(200, 30);

        if (contenedor.getUsuarioActual() instanceof Administrativo) {
            JButton btnReporte = new JButton("Consultar reporte");
            btnReporte.setPreferredSize(buttonSize);
            btnReporte.setMaximumSize(buttonSize);
            btnReporte.setMinimumSize(buttonSize);
            btnReporte.setAlignmentX(Component.LEFT_ALIGNMENT);
            btnReporte.addActionListener(e -> {
                frame.mostrarVista("consultarReporte", contenedor);
            });
            form.add(btnReporte);
            form.add(Box.createVerticalStrut(15));

            JButton btnAgregarCurso = new JButton("Agregar curso");
            btnAgregarCurso.setPreferredSize(buttonSize);
            btnAgregarCurso.setMaximumSize(buttonSize);
            btnAgregarCurso.setMinimumSize(buttonSize);
            btnAgregarCurso.setAlignmentX(Component.LEFT_ALIGNMENT);
            btnAgregarCurso.addActionListener(e -> {
                frame.mostrarVista("agregarCurso", contenedor);
            });
            form.add(btnAgregarCurso);
            form.add(Box.createVerticalStrut(15));

            JButton btnAgregarUsuario = new JButton("Agregar usuario");
            btnAgregarUsuario.setPreferredSize(buttonSize);
            btnAgregarUsuario.setMaximumSize(buttonSize);
            btnAgregarUsuario.setMinimumSize(buttonSize);
            btnAgregarUsuario.setAlignmentX(Component.LEFT_ALIGNMENT);
            btnAgregarUsuario.addActionListener(e -> {
                frame.mostrarVista("agregarUsuario", contenedor);
            });
            form.add(btnAgregarUsuario);
            form.add(Box.createVerticalStrut(15));

            JButton btnAgregarEstudianteACurso = new JButton("Agregar estudiante a curso");
            btnAgregarEstudianteACurso.setPreferredSize(buttonSize);
            btnAgregarEstudianteACurso.setMaximumSize(buttonSize);
            btnAgregarEstudianteACurso.setMinimumSize(buttonSize);
            btnAgregarEstudianteACurso.setAlignmentX(Component.LEFT_ALIGNMENT);
            btnAgregarEstudianteACurso.addActionListener(e -> {
                frame.mostrarVista("agregarEstudianteACurso", contenedor);
            });
            form.add(btnAgregarEstudianteACurso);
            form.add(Box.createVerticalStrut(15));

            JButton btnValidarConstancias = new JButton("Validar Constancias");
            btnValidarConstancias.setPreferredSize(buttonSize);
            btnValidarConstancias.setMaximumSize(buttonSize);
            btnValidarConstancias.setMinimumSize(buttonSize);
            btnValidarConstancias.setAlignmentX(Component.LEFT_ALIGNMENT);
            btnValidarConstancias.addActionListener(e -> {
                frame.mostrarVista("validarConstancias", contenedor);
            });
            form.add(btnValidarConstancias);
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
            frame.mostrarVista("login", contenedor);
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
        JPanel panelDerecha = new JPanel(new GridLayout(1, 2, 20, 0));
        panelDerecha.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // SUBPANEL IZQUIERDO (Cursos)
        JPanel panelCursos = new JPanel();
        panelCursos.setLayout(new BoxLayout(panelCursos, BoxLayout.Y_AXIS));

        JLabel listaCursosLabel = new JLabel("Lista de Cursos");
        listaCursosLabel.setFont(getFont().deriveFont(30.0f));
        String cursos = "";
        if (contenedor.getCursos().isEmpty()) {
            cursos = "No hay cursos registrados.\n";
        }else {
            for (Curso curso : contenedor.getCursos()) {
            cursos += "- " + curso.getNombre() + "\n";
            }
        }
        JTextArea listaCursos = new JTextArea(cursos);
        listaCursos.setFont(getFont().deriveFont(15.0f));
        listaCursos.setEditable(false);
        listaCursos.setOpaque(false);    // Para fondo transparente
        listaCursos.setFocusable(false);
        listaCursos.setBorder(null);
        listaCursos.setPreferredSize(new Dimension(200, 500));
        listaCursos.setMaximumSize(new Dimension(200, 500));
        listaCursos.setMinimumSize(new Dimension(200, 500));
        listaCursos.setAlignmentX(LEFT_ALIGNMENT);

        panelCursos.add(listaCursosLabel);
        panelCursos.add(listaCursos);


        // SUBPANEL DERECHO (Usuarios)
        JPanel panelUsuarios = new JPanel();
        panelUsuarios.setLayout(new BoxLayout(panelUsuarios, BoxLayout.Y_AXIS));

        JLabel listaUsuariosLabel = new JLabel("Lista de Usuarios");
        listaUsuariosLabel.setFont(getFont().deriveFont(30.0f));
        String usuarios = "";
        if (contenedor.getUsuarios().isEmpty()) {
            usuarios = "No hay usuarios registrados.\n";
        }else {
            for (Usuario usuario : contenedor.getUsuarios()) {
            usuarios += "- " + usuario.getNombre() + " (" + usuario.getClass().getSimpleName() + ")\n";
            }
        }
        JTextArea listaUsuarios = new JTextArea(usuarios);
        listaUsuarios.setFont(getFont().deriveFont(15.0f));
        listaUsuarios.setEditable(false);
        listaUsuarios.setOpaque(false);    // Para fondo transparente
        listaUsuarios.setFocusable(false);
        listaUsuarios.setBorder(null);
        listaUsuarios.setPreferredSize(new Dimension(400, 500));
        listaUsuarios.setMaximumSize(new Dimension(400, 500));
        listaUsuarios.setMinimumSize(new Dimension(400, 500));
        listaUsuarios.setAlignmentX(LEFT_ALIGNMENT);

        panelUsuarios.add(listaUsuariosLabel);
        panelUsuarios.add(listaUsuarios);


        panelDerecha.add(panelCursos);
        panelDerecha.add(Box.createHorizontalStrut(20));
        panelDerecha.add(panelUsuarios);
        
        panelDerecha.setLayout(new BoxLayout(panelDerecha, BoxLayout.X_AXIS));
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
}
