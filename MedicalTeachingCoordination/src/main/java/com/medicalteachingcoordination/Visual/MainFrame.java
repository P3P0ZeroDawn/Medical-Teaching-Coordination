package com.medicalteachingcoordination.Visual;

import javax.swing.*;

import java.awt.*;

public class MainFrame extends JFrame {

    private JPanel cards;

    public MainFrame(ContenedorEntidades contenedor) {

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
    public void mostrarVista(String nombre, ContenedorEntidades contenedor) {
        cards.removeAll();

        switch (nombre) {
            case "login":
                cards.add(new Login(this, contenedor), "login");
                break;
            case "menu":
                cards.add(new Menu(this, contenedor), "menu");
                break;
            case "cursos":
                cards.add(new Cursos(this, contenedor), "cursos");
                break;
            case "cursoEspecifico":
                cards.add(new CursoEspecifico(this, contenedor), "cursoEspecifico");
                break;

            case "agregarCurso":
                cards.add(new AgregarCurso(this, contenedor), "agregarCurso");
                break;

            case "agregarUsuario":
                cards.add(new AgregarUsuario(this, contenedor), "agregarUsuario");
                break;

            case "agregarEstudianteACurso":
                cards.add(new AgregarEstudianteACurso(this, contenedor), "agregarEstudianteACurso");
                break;

            case "consultarReporte":
                cards.add(new ConsultarReporte(this, contenedor), "consultarReporte");
                break;

            case "subirConstancia":
                cards.add(new SubirConstancia(this, contenedor), "subirConstancia");
                break;

            case "validarConstancias":
                cards.add(new ValidarConstanciasPanel(this, contenedor), "validarConstancias");
                break;
        }
        
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);

        cards.revalidate();
        cards.repaint();
    }
}
