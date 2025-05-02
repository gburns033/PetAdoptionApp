package edu.gz.view;

import javax.swing.*;
import java.awt.*;

public class MainFrame extends JFrame {

    private PetPanel petPanel;

    public MainFrame() {
        super("Adopt Me - Pet Adoption Center");

        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);

        petPanel = new PetPanel();
        add(petPanel, BorderLayout.CENTER);

        setVisible(true);
    }

    public PetPanel getPetPanel() {
        return petPanel;
    }
}
