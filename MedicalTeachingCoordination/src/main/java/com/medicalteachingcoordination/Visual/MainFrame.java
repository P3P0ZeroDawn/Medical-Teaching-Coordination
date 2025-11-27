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

    public MainFrame
    (
        ArrayList<Usuario> usuarios,
        ArrayList<Asistencia> asistencias,
        ArrayList<Curso> cursos,
        ArrayList<GestionarConstancias> constancias,
        Contador contadorUsuarios
    ) 
        {
        setTitle("Sistema de Coordinación de Enseñanza Médica");
        setSize(800, 600);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        // Evita que la ventana se pueda redimensionar o maximizar
        setResizable(false);
        setLocationRelativeTo(null);

        cards = new JPanel(new CardLayout());

        // agregar vistas
        cards.add(new Login(this, cursos, usuarios), "login");

        add(cards);
    }
    //menu administrativo
    public void mostrarVista(String nombre, Usuario usuario, ArrayList<Usuario> usuarios) {
        this.cards.add(new Menu(this, usuario, usuarios), "menu");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
    }
    //login
    public void mostrarVista(String nombre, ArrayList<Usuario> usuarios) {
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
    }
    //cursos
    public void mostrarVista(String nombre, ArrayList<Curso> cursos, Usuario usuario, ArrayList<Usuario> usuarios) {
        this.cards.add(new Cursos(this, cursos, usuario, usuarios), "cursos");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
    }
    //curso especifico
    public void mostrarVista(String nombre, Curso curso, Usuario usuario, ArrayList<Usuario> usuarios, ArrayList<Curso> cursos) {
        this.cards.add(new CursoEspecifico(this, curso, usuario, usuarios, cursos), "cursoEspecifico");
        CardLayout cl = (CardLayout) cards.getLayout();
        cl.show(cards, nombre);
    }
}

    
        
