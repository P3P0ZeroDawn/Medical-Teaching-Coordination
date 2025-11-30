package com.medicalteachingcoordination.Visual;

import javax.swing.*;
import java.awt.*;
import com.medicalteachingcoordination.Documentos.Reporte;

public class ConsultarReporte extends JPanel {

    public ConsultarReporte(MainFrame frame, ContenedorEntidades contenedor) {
        // Centrar el formulario en la pantalla
        setLayout(new GridBagLayout());

        JPanel form = new JPanel();
        form.setLayout(new BoxLayout(form, BoxLayout.Y_AXIS));
        form.setAlignmentX(CENTER_ALIGNMENT);

        JLabel mainLabel = new JLabel("Reporte");
        mainLabel.setFont(mainLabel.getFont().deriveFont(30.0f));
        mainLabel.setPreferredSize(new Dimension(600, 40));
        mainLabel.setMaximumSize(new Dimension(Integer.MAX_VALUE, 40));
        mainLabel.setMinimumSize(new Dimension(600, 40));
        mainLabel.setHorizontalAlignment(SwingConstants.LEFT);
        mainLabel.setBorder(BorderFactory.createEmptyBorder(0, 90, 0, 0));

        // Campos
        Reporte reporte = new com.medicalteachingcoordination.Administrativo.ConsultarReporte().generarReporte(contenedor.getConstancias(), contenedor.getAsistencias());
        String textoReporte = new com.medicalteachingcoordination.Administrativo.ConsultarReporte().consultarReporte(reporte);

        if (textoReporte.isEmpty()) {
            textoReporte = "No hay información disponible en el reporte.";
        }

        JTextArea infoReporte = new JTextArea(textoReporte);
        infoReporte.setFont(getFont().deriveFont(15.0f));
        infoReporte.setEditable(false);
        infoReporte.setOpaque(false);    // Para fondo transparente
        infoReporte.setFocusable(false);
        infoReporte.setBorder(null);
        infoReporte.setAlignmentX(LEFT_ALIGNMENT);
        infoReporte.setLineWrap(true);
        infoReporte.setWrapStyleWord(true);

        JScrollPane scrollPane = new JScrollPane(infoReporte);
        scrollPane.setPreferredSize(new Dimension(600, 400));
        scrollPane.setMaximumSize(new Dimension(600, 400));
        scrollPane.setMinimumSize(new Dimension(600, 400));
        scrollPane.setAlignmentX(CENTER_ALIGNMENT);
        scrollPane.setBorder(BorderFactory.createEmptyBorder());
        scrollPane.getVerticalScrollBar().setUnitIncrement(16); // Velocidad de desplazamiento
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);


        // Alinear todos al centro
        mainLabel.setAlignmentX(CENTER_ALIGNMENT);

        // Ensamblar UI con espacios
        Dimension buttonSize = new Dimension(150, 30);

        form.add(Box.createVerticalStrut(10));
        form.add(mainLabel);
        form.add(Box.createVerticalStrut(10));

        form.add(scrollPane);

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
