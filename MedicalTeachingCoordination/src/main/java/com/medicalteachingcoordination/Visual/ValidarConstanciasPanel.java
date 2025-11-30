package com.medicalteachingcoordination.Visual;

import javax.swing.*;

import com.medicalteachingcoordination.Administrativo.ValidarConstancias;
import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Documentos.Constancia;

import java.awt.*;
import java.util.ArrayList;

public class ValidarConstanciasPanel extends JPanel {

    private JComboBox<String> comboClaves;
    private JTextArea txtPorValidar;
    private JTextArea txtValidadas;

    private ContenedorEntidades contenedor;
    private MainFrame frame;

    public ValidarConstanciasPanel(MainFrame frame, ContenedorEntidades contenedor) {

        this.frame = frame;
        this.contenedor = contenedor;

        setLayout(new BorderLayout());

        // =========================================
        // PANEL IZQUIERDO – CONSTANCIAS POR VALIDAR
        // =========================================
        JPanel panelIzq = new JPanel();
        panelIzq.setLayout(new BoxLayout(panelIzq, BoxLayout.Y_AXIS));
        panelIzq.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblPorValidar = new JLabel("Constancias por validar");
        lblPorValidar.setFont(lblPorValidar.getFont().deriveFont(24f));
        lblPorValidar.setAlignmentX(CENTER_ALIGNMENT);

        txtPorValidar = crearTextArea();
        JScrollPane scrollIzq = new JScrollPane(txtPorValidar);

        panelIzq.add(lblPorValidar);
        panelIzq.add(Box.createVerticalStrut(10));
        panelIzq.add(scrollIzq);


        // =========================================
        // PANEL DERECHO – CONSTANCIAS VALIDADAS
        // =========================================
        JPanel panelDer = new JPanel();
        panelDer.setLayout(new BoxLayout(panelDer, BoxLayout.Y_AXIS));
        panelDer.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblValidadas = new JLabel("Constancias Validadas");
        lblValidadas.setFont(lblValidadas.getFont().deriveFont(24f));
        lblValidadas.setAlignmentX(CENTER_ALIGNMENT);

        txtValidadas = crearTextArea();
        JScrollPane scrollDer = new JScrollPane(txtValidadas);

        panelDer.add(lblValidadas);
        panelDer.add(Box.createVerticalStrut(10));
        panelDer.add(scrollDer);


        // ========================================================
        // CONTENEDOR DE LOS DOS PANELES (IZQUIERDA / DERECHA)
        // ========================================================
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, panelIzq, panelDer);
        splitPane.setResizeWeight(0.5); // mitad y mitad

        add(splitPane, BorderLayout.CENTER);


        // =========================================
        // PANEL INFERIOR – SELECTOR + BOTONES
        // =========================================
        JPanel panelInferior = new JPanel();
        panelInferior.setLayout(new BoxLayout(panelInferior, BoxLayout.Y_AXIS));
        panelInferior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        JLabel lblClave = new JLabel("Seleccione clave:");
        lblClave.setAlignmentX(CENTER_ALIGNMENT);

        comboClaves = new JComboBox<>();
        comboClaves.setMaximumSize(new Dimension(200, 30));
        comboClaves.setAlignmentX(CENTER_ALIGNMENT);

        JButton btnValidar = new JButton("Validar Constancia");
        btnValidar.setAlignmentX(CENTER_ALIGNMENT);
        btnValidar.addActionListener(e -> validarConstancia());

        JButton btnRegresar = new JButton("Regresar");
        btnRegresar.setAlignmentX(CENTER_ALIGNMENT);
        btnRegresar.addActionListener(e -> frame.mostrarVista("menu", contenedor));

        panelInferior.add(lblClave);
        panelInferior.add(comboClaves);
        panelInferior.add(Box.createVerticalStrut(10));
        panelInferior.add(btnValidar);
        panelInferior.add(Box.createVerticalStrut(5));
        panelInferior.add(btnRegresar);

        add(panelInferior, BorderLayout.SOUTH);

        // Cargar datos iniciales
        actualizarListas();
    }

    private JTextArea crearTextArea() {
        JTextArea a = new JTextArea();
        a.setEditable(false);
        a.setLineWrap(true);
        a.setWrapStyleWord(true);
        a.setFont(getFont().deriveFont(14f));
        return a;
    }

    // ======================================================
    // ACTUALIZA AMBAS LISTAS Y EL COMBOBOX AUTOMÁTICAMENTE
    // ======================================================
    private void actualizarListas() {
        txtPorValidar.setText("");
        txtValidadas.setText("");
        comboClaves.removeAllItems();

        StringBuilder sbPorValidar = new StringBuilder();
        StringBuilder sbValidadas = new StringBuilder();

        for (GestionarConstancias g : contenedor.getConstancias()) {

            // Por validar
            for (Constancia c : g.getConstanciasPorValidar()) {
                sbPorValidar.append("Curso: ").append(c.getCurso().getNombre())
                        .append(" | Estudiante: ").append(c.getEstudiante().getNombre())
                        .append(" | Clave: ").append(c.getClave())
                        .append("\n");
                comboClaves.addItem(c.getClave());
            }

            // Validadas
            for (Constancia c : g.getConstanciasValidadas()) {
                sbValidadas.append("Curso: ").append(c.getCurso().getNombre())
                        .append(" | Estudiante: ").append(c.getEstudiante().getNombre())
                        .append(" | Clave: ").append(c.getClave())
                        .append("\n");
            }
        }

        txtPorValidar.setText(sbPorValidar.length() == 0 ? "No hay constancias pendientes." : sbPorValidar.toString());
        txtValidadas.setText(sbValidadas.length() == 0 ? "No hay constancias validadas." : sbValidadas.toString());
    }


    // ======================================================
    // VALIDACIÓN Y ACTUALIZACIÓN AUTOMÁTICA
    // ======================================================
    private void validarConstancia() {

        if (comboClaves.getSelectedItem() == null) {
            JOptionPane.showMessageDialog(this, "No hay constancias para validar.");
            return;
        }

        String claveSel = comboClaves.getSelectedItem().toString();

        for (GestionarConstancias g : contenedor.getConstancias()) {
            for (Constancia c : new ArrayList<>(g.getConstanciasPorValidar())) {

                if (c.getClave().equals(claveSel)) {

                    int res = new ValidarConstancias().ValidarConstancia(g, c);

                    if (res == 1)
                        JOptionPane.showMessageDialog(this, "Validada correctamente.");
                    else if (res == 2)
                        JOptionPane.showMessageDialog(this, "Ya estaba validada. Fue eliminada de la lista.");
                    else
                        JOptionPane.showMessageDialog(this, "Constancia inválida.");

                    actualizarListas();
                    return;
                }
            }
        }
    }
}
