package com.medicalteachingcoordination.Visual;

import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel cards;
    private ContenedorEntidades contenedor;

    public MainFrame(ContenedorEntidades contenedor) {
        this.contenedor = contenedor;

        setTitle("Sistema de Coordinación de Enseñanza Médica");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Evita que la ventana se pueda redimensionar o maximizar
        setResizable(false);
        setLocationRelativeTo(null);

        cards = new JPanel(new CardLayout());

        // agregar vistas
        cards.add(new Login(this, contenedor), "login");

        add(cards);
    }

    // cualquier vista
    public void mostrarVista(String nombre) {
        if (!existePanel(nombre)) {
            switch (nombre) {
                case "menu":
                    cards.add(new Menu(this, contenedor), "menu");
                    break;
                case "cursos":
                    cards.add(new Cursos(this, contenedor), "cursos");
                    break;
                case "cursoEspecifico":
                    cards.add(new CursoEspecifico(this, contenedor), "cursoEspecifico");
                    break;
            }
        }
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
    }

    // Checa si existe el panel
    private boolean existePanel(String nombre) {
        for (Component c : cards.getComponents()) {
            if (nombre.equals(c.getName())) {
                return true;
            }
        }
        return false;
    }
}
