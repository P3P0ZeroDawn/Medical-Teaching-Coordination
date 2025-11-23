package com.medicalteachingcoordination.Visual;

import javax.swing.*;

import com.medicalteachingcoordination.Misc.Usuario;

import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JPanel cards;

    public MainFrame(ArrayList<Usuario> usuarios) {
        setTitle("Mi aplicación");
        setSize(500, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cards = new JPanel(new CardLayout());

        // agregar vistas
        cards.add(new Login(this, usuarios), "login");

        add(cards);
    }

    public void mostrarVista(String nombre) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
    }
}

    
        
