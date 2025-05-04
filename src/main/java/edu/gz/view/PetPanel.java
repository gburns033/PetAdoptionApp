package edu.gz.view;

import javax.swing.*;
import java.awt.*;

/**
 * PetPanel class represents the main panel displaying the list of pets.
 * It includes a table for displaying pet data, buttons for performing actions,
 * and a combo box for sorting the pet list.
 */
public class PetPanel extends JPanel {

	private JTable petTable;
	private JButton addButton;
	private JButton adoptButton;
	private JButton removeButton;
	private JButton viewButton;
	private JButton saveButton;
	private JComboBox<String> sortComboBox;

	/**
	 * Constructs the PetPanel, initializing the layout, components,
	 * and adding them to the panel.
	 */
	public PetPanel() {
		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel(new FlowLayout());
		sortComboBox = new JComboBox<>(new String[] { "None", "Name", "Age", "Type", "Species" });
		topPanel.add(new JLabel("Sort by:"));
		topPanel.add(sortComboBox);
		add(topPanel, BorderLayout.NORTH);

		petTable = new JTable();
		add(new JScrollPane(petTable), BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel(new FlowLayout());
		addButton = new JButton("Add");
		adoptButton = new JButton("Adopt");
		removeButton = new JButton("Remove");
		viewButton = new JButton("View Details");
		saveButton = new JButton("Save");

		bottomPanel.add(addButton);
		bottomPanel.add(adoptButton);
		bottomPanel.add(removeButton);
		bottomPanel.add(viewButton);
		bottomPanel.add(saveButton);

		add(bottomPanel, BorderLayout.SOUTH);
	}

	/**
	 * Gets the JTable for displaying pet data.
	 *
	 * @return JTable representing the pet list
	 */
	public JTable getPetTable() {
		return petTable;
	}

	/**
	 * Gets the "Add" button for adding new pets to the shelter.
	 *
	 * @return JButton representing the "Add" button
	 */
	public JButton getAddButton() {
		return addButton;
	}

	/**
	 * Gets the "Adopt" button for adopting a pet from the shelter.
	 *
	 * @return JButton representing the "Adopt" button
	 */
	public JButton getAdoptButton() {
		return adoptButton;
	}

	/**
	 * Gets the "Remove" button for removing a pet from the shelter.
	 *
	 * @return JButton representing the "Remove" button
	 */
	public JButton getRemoveButton() {
		return removeButton;
	}

	/**
	 * Gets the "View Details" button for viewing more information about a selected pet.
	 *
	 * @return JButton representing the "View Details" button
	 */
	public JButton getViewButton() {
		return viewButton;
	}

	/**
	 * Gets the "Save" button for saving the pet data to a file.
	 *
	 * @return JButton representing the "Save" button
	 */
	public JButton getSaveButton() {
		return saveButton;
	}

	/**
	 * Gets the combo box for selecting sorting criteria for the pet list.
	 *
	 * @return JComboBox representing the sorting options
	 */
	public JComboBox<String> getSortComboBox() {
		return sortComboBox;
	}
}
