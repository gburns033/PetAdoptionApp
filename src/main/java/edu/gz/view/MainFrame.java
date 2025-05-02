package edu.gz.view;

import edu.gz.utils.JsonLoader;
import edu.gz.model.*;

import javax.swing.JFrame;

import java.awt.BorderLayout;
import java.util.List;

public class MainFrame extends JFrame {

	private PetPanel petPanel;

	public MainFrame() {
		super("Adopt Me - Pet Adoption Center");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

		petPanel = new PetPanel();
		add(petPanel, BorderLayout.CENTER);

		loadPetData();

		setVisible(true);
	}

	private void loadPetData() {
		List<Pet> petList = JsonLoader.loadPets("/pets.json");
		PetTableModel model = new PetTableModel(petList);
		petPanel.getPetTable().setModel(model);
	}
}
