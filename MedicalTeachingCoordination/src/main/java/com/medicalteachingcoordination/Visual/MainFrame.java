package com.medicalteachingcoordination.Visual;

import javax.swing.*;

import com.medicalteachingcoordination.Curso.Curso;
import com.medicalteachingcoordination.Curso.GestionarConstancias;
import com.medicalteachingcoordination.Misc.Asistencia;
import com.medicalteachingcoordination.Misc.Contador;
import com.medicalteachingcoordination.Misc.Usuario;

import java.awt.*;
import java.util.ArrayList;

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
        cards.add(new Menu(this, contenedor), "menu");
        cards.add(new Cursos(this, contenedor), "cursos");
        cards.add(new CursoEspecifico(this, contenedor), "cursoEspecifico");

        add(cards);
    }

    // cualquier vista
    public void mostrarVista(String nombre) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
    }
}
