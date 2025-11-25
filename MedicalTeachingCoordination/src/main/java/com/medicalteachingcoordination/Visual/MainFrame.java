package com.medicalteachingcoordination.Visual;

import javax.swing.*;

import com.medicalteachingcoordination.Misc.Usuario;

import java.awt.*;
import java.util.ArrayList;

public class MainFrame extends JFrame {

    private JPanel cards;

    public MainFrame(ArrayList<Usuario> usuarios) {
        setTitle("Mi aplicación");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        cards = new JPanel(new CardLayout());

        // agregar vistas
        cards.add(new Login(this, usuarios), "login");
        cards.add(new Menu(this, usuarios.get(0)), "menu");
        add(cards);
    }

    public void mostrarVista(String nombre, Usuario usuario) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
    }
}

    
        
