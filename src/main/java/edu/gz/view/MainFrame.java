package edu.gz.view;

import edu.gz.controller.PetPanelController;
import edu.gz.model.*;
import edu.gz.utils.JsonLoader;
import edu.gz.utils.ShelterManager;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * The main application frame for the "Adopt Me - Pet Adoption Center" GUI.
 * This class initializes the GUI window, loads pet data from JSON files, and
 * sets up the pet panel view with appropriate data.
 */
public class MainFrame extends JFrame {

	private PetPanel petPanel;

	/**
	 * Constructs the main application frame, initializes the GUI components,
	 * loads data from JSON files, and displays the window.
	 */
	public MainFrame() {
		super("Adopt Me - Pet Adoption Center");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(800, 600);
		setLocationRelativeTo(null);

		petPanel = new PetPanel();
		new PetPanelController(petPanel);
		add(petPanel, BorderLayout.CENTER);

		loadPetAndExoticData();

		setVisible(true);
	}

	/**
	 * Loads both regular and exotic pet data from JSON files using {@link JsonLoader},
	 * then populates the {@link PetPanel} table with the loaded data.
	 */
	private void loadPetAndExoticData() {
		ShelterManager manager = JsonLoader.loadPets("/pets.json");
		JsonLoader.loadExoticPets("/exotic_animals.json");

		List<Pet> allPets = new ArrayList<>();
		for (Map.Entry<String, Shelter<? extends Pet>> entry : manager.getAllShelters().entrySet()) {
			allPets.addAll(entry.getValue().getAllPets());
		}

		PetTableModel model = new PetTableModel(allPets);
		petPanel.getPetTable().setModel(model);
	}
}
