package edu.gz.view;

import javax.swing.*;
import java.awt.*;

public class PetPanel extends JPanel {

	private JTable petTable;
	private JButton addButton;
	private JButton adoptButton;
	private JButton removeButton;
	private JButton viewButton;
	private JButton saveButton;
	private JComboBox<String> sortComboBox;

	public PetPanel() {
		setLayout(new BorderLayout());

		JPanel topPanel = new JPanel(new FlowLayout());
		sortComboBox = new JComboBox<>(new String[] { "Name", "Age", "Species" });
		topPanel.add(new JLabel("Sort by:"));
		topPanel.add(sortComboBox);
		add(topPanel, BorderLayout.NORTH);

		petTable = new JTable();
		add(new JScrollPane(petTable), BorderLayout.CENTER);

		JPanel bottomPanel = new JPanel(new FlowLayout());
		addButton = new JButton("Add");
		adoptButton = new JButton("Adopt");
		removeButton = new JButton("Remove");
		saveButton = new JButton("Save");

		bottomPanel.add(addButton);
		bottomPanel.add(adoptButton);
		bottomPanel.add(removeButton);
		bottomPanel.add(saveButton);

		add(bottomPanel, BorderLayout.SOUTH);
	}

	public JTable getPetTable() {
		return petTable;
	}

	public JButton getAddButton() {
		return addButton;
	}

	public JButton getAdoptButton() {
		return adoptButton;
	}

	public JButton getRemoveButton() {
		return removeButton;
	}

	public JButton getViewButton() {
		return viewButton;
	}

	public JButton getSaveButton() {
		return saveButton;
	}

	public JComboBox<String> getSortComboBox() {
		return sortComboBox;
	}
}
