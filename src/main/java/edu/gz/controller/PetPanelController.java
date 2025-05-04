package edu.gz.controller;

import edu.gz.model.*;
import edu.gz.utils.PetDataSaver;
import edu.gz.utils.PetFactory;
import edu.gz.utils.ShelterManager;
import edu.gz.view.PetPanel;

import javax.swing.*;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class PetPanelController {

	private PetPanel petPanel;

	public PetPanelController(PetPanel petPanel) {
		this.petPanel = petPanel;

		petPanel.getSortComboBox().addActionListener(new SortComboBoxListener());

		petPanel.getAddButton().addActionListener(new AddButtonListener());
		petPanel.getAdoptButton().addActionListener(new AdoptButtonListener());
		petPanel.getRemoveButton().addActionListener(new RemoveButtonListener());
		petPanel.getViewButton().addActionListener(new ViewButtonListener());
		petPanel.getSaveButton().addActionListener(new SaveButtonListener());
	}

	private class SortComboBoxListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			JComboBox<String> comboBox = (JComboBox<String>) e.getSource();
			String selected = (String) comboBox.getSelectedItem();
			sortPetTable(selected);
		}
	}

	private class AddButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showAddPetDialog();
		}
	}

	private class AdoptButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showAdoptPetDialog();
		}
	}

	private class RemoveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showRemovePetDialog();
		}
	}
	
	private class ViewButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			showViewDialog();
		}
	}

	private class SaveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
			PetDataSaver petDataSaver = new PetDataSaver();
			petDataSaver.savePets();
			petDataSaver.saveExoticAnimals(ShelterManager.getInstance());
		}
	}

	private void showAddPetDialog() {
		JTextField nameField = new JTextField(15);
		JTextField ageField = new JTextField(15);
		JTextField speciesField = new JTextField(15);

		String[] speciesOptions = { "Dog", "Cat", "Rabbit", "Exotic (Other)" };
		JComboBox<String> speciesComboBox = new JComboBox<>(speciesOptions);

		JLabel exoticTypeLabel = new JLabel("Exotic Type:");
		JTextField exoticTypeField = new JTextField(15);
		Dimension reservedSize = new Dimension(150, exoticTypeField.getPreferredSize().height);
		exoticTypeField.setPreferredSize(reservedSize);

		JPanel panel = new JPanel(new GridBagLayout());

		// Initial "hidden but reserved" state
		exoticTypeField.setEditable(false);
		exoticTypeField.setOpaque(false);
		exoticTypeField.setBorder(null);
		exoticTypeField.setBackground(panel.getBackground());
		exoticTypeLabel.setForeground(panel.getBackground());

		GridBagConstraints gbc = new GridBagConstraints();
		gbc.insets = new Insets(5, 5, 5, 5);
		gbc.anchor = GridBagConstraints.WEST;
		gbc.fill = GridBagConstraints.HORIZONTAL;

		gbc.gridx = 0;
		gbc.gridy = 0;
		panel.add(new JLabel("Name:"), gbc);
		gbc.gridx = 1;
		panel.add(nameField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 1;
		panel.add(new JLabel("Age:"), gbc);
		gbc.gridx = 1;
		panel.add(ageField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 2;
		panel.add(new JLabel("Type:"), gbc);
		gbc.gridx = 1;
		panel.add(speciesComboBox, gbc);

		// Exotic Type
		gbc.gridx = 0;
		gbc.gridy = 3;
		panel.add(exoticTypeLabel, gbc);
		gbc.gridx = 1;
		panel.add(exoticTypeField, gbc);

		gbc.gridx = 0;
		gbc.gridy = 4;
		panel.add(new JLabel("Species (e.g., Siamese, Iguana):"), gbc);
		gbc.gridx = 1;
		panel.add(speciesField, gbc);

		// Listener for showing/hiding exotic type
		speciesComboBox.addActionListener(e -> {
			boolean isExotic = speciesComboBox.getSelectedItem().toString().startsWith("Exotic");

			if (isExotic) {
				exoticTypeField.setEditable(true);
				exoticTypeField.setOpaque(true);
				exoticTypeField.setBackground(Color.WHITE);
				exoticTypeField.setBorder(UIManager.getBorder("TextField.border"));
				exoticTypeLabel.setForeground(null); // Restore default color
			} else {
				exoticTypeField.setEditable(false);
				exoticTypeField.setText("");
				exoticTypeField.setOpaque(false);
				exoticTypeField.setBorder(null);
				exoticTypeField.setBackground(panel.getBackground());
				exoticTypeLabel.setForeground(panel.getBackground());
			}
		});

		boolean inputValid = false;

		while (!inputValid) {
			int result = JOptionPane.showConfirmDialog(null, panel, "Add New Pet", JOptionPane.OK_CANCEL_OPTION,
					JOptionPane.PLAIN_MESSAGE);

			if (result != JOptionPane.OK_OPTION) {
				return;
			}

			String name = nameField.getText().trim();
			String ageText = ageField.getText().trim();
			String type = (String) speciesComboBox.getSelectedItem();
			String species = speciesField.getText().trim();

			if (name.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Name cannot be empty.");
				continue;
			}

			int age;
			try {
				age = Integer.parseInt(ageText);
				if (age < 0)
					throw new NumberFormatException();
			} catch (NumberFormatException e) {
				JOptionPane.showMessageDialog(null, "Age must be 0 or above.");
				continue;
			}

			if (species.isEmpty()) {
				JOptionPane.showMessageDialog(null, "Species cannot be empty.");
				continue;
			}

			if ("Exotic (Other)".equals(type)) {
				String exoticType = exoticTypeField.getText().trim();
				if (exoticType.isEmpty()) {
					JOptionPane.showMessageDialog(null, "Exotic type cannot be empty.");
					continue;
				}
				type = exoticType;
			}

			int newId = ShelterManager.getInstance().generateUniqueId();
			Pet newPet = PetFactory.createPet(type, newId, name, species, age);
			ShelterManager.getInstance().addPetToShelter(newPet);

			JOptionPane.showMessageDialog(null, "Pet added successfully!");
			inputValid = true;

			PetTableModel model = new PetTableModel(ShelterManager.getInstance().getAllPets());
			petPanel.getPetTable().setModel(model);
		}
	}

	private void showAdoptPetDialog() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JTextField idField = new JTextField(10);

		panel.add(new JLabel("Enter Pet ID:"));
		panel.add(idField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Adopt Pet", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			try {
				int petId = Integer.parseInt(idField.getText().trim());
				Pet pet = ShelterManager.getInstance().getPetById(petId);
				
				if (pet == null) {
					JOptionPane.showMessageDialog(null, "Please enter a valid pet ID.");
					return;
				}
				
				String petType = pet.getType();
				
				boolean isAdopted = false;

				switch (petType) {
				case "Dog":
					isAdopted = ShelterManager.getInstance().adoptDog(petId);
					break;
				case "Cat":
					isAdopted = ShelterManager.getInstance().adoptCat(petId);
					break;
				case "Rabbit":
					isAdopted = ShelterManager.getInstance().adoptRabbit(petId);
					break;
				default:
					isAdopted = ShelterManager.getInstance().adoptExotic(petId);
					break;
				}
				if (isAdopted) {
					PetTableModel model = new PetTableModel(ShelterManager.getInstance().getAllPets());
					petPanel.getPetTable().setModel(model);
				} else {
					JOptionPane.showMessageDialog(null, "Pet has already been adopted.");
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid pet ID.");
			}
		}
	}

	private void showRemovePetDialog() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));

		JTextField idField = new JTextField(10);

		panel.add(new JLabel("Enter Pet ID:"));
		panel.add(idField);

		int option = JOptionPane.showConfirmDialog(null, panel, "Adopt Pet", JOptionPane.OK_CANCEL_OPTION);

		if (option == JOptionPane.OK_OPTION) {
			try {
				int petId = Integer.parseInt(idField.getText().trim());
				Pet pet = ShelterManager.getInstance().getPetById(petId);

				if (pet == null) {
					JOptionPane.showMessageDialog(null, "Pet not found with the provided ID.");
					return;
				}

				boolean removed = false;

				if (pet instanceof Dog) {
					removed = ShelterManager.getInstance().removeDog(petId);
				} else if (pet instanceof Cat) {
					removed = ShelterManager.getInstance().removeCat(petId);
				} else if (pet instanceof Rabbit) {
					removed = ShelterManager.getInstance().removeRabbit(petId);
				} else if (pet instanceof ExoticAnimalAdapter) {
					removed = ShelterManager.getInstance().removeExotic(petId);
				}

				if (removed) {
					PetTableModel model = new PetTableModel(ShelterManager.getInstance().getAllPets());
					petPanel.getPetTable().setModel(model);
				} else {
					JOptionPane.showMessageDialog(null, "Pet has already been removed.");
				}

			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid pet ID.");
			}
		}
	}
	
	private void showViewDialog() {
	    JPanel panel = new JPanel();
	    panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
	    
	    JTextField idField = new JTextField(10);

	    panel.add(new JLabel("Enter Pet ID:"));
	    panel.add(idField);
	    
	    int option = JOptionPane.showConfirmDialog(null, panel, "View Pet", JOptionPane.OK_CANCEL_OPTION);

	    if (option == JOptionPane.OK_OPTION) {
	        try {
	            int petId = Integer.parseInt(idField.getText().trim());
	            Pet pet = ShelterManager.getInstance().getPetById(petId);

	            if (pet == null) {
	                JOptionPane.showMessageDialog(null, "Pet not found with the provided ID.");
	                return;
	            }

	            JPanel detailPanel = new JPanel();
	            detailPanel.setLayout(new BoxLayout(detailPanel, BoxLayout.Y_AXIS));

	            detailPanel.add(new JLabel("ID: " + pet.getId()));
	            detailPanel.add(new JLabel("Name: " + pet.getName()));
	            detailPanel.add(new JLabel("Age: " + pet.getAge()));
	            detailPanel.add(new JLabel("Species: " + pet.getSpecies()));
	            detailPanel.add(new JLabel("Type: " + pet.getType()));
	            detailPanel.add(new JLabel("Adopted: " + (pet.isAdopted() ? "Yes" : "No")));

	            JOptionPane.showMessageDialog(null, detailPanel, "Pet Details", JOptionPane.INFORMATION_MESSAGE);

	        } catch (NumberFormatException ex) {
	            JOptionPane.showMessageDialog(null, "Please enter a valid pet ID.");
	        }
	    }
	}

	private void sortPetTable(String selected) {
		List<Pet> pets = ShelterManager.getInstance().getAllPets();

		switch (selected) {
		case "Name":
			Collections.sort(pets);
			break;
		case "Age":
			Collections.sort(pets, new AgeComparator<>());
			break;
		case "Species":
			Collections.sort(pets, new SpeciesComparator<>());
			break;
		case "Type":
			Collections.sort(pets, new TypeComparator<>());
			break;
		case "None":
			break;
		default:
			System.out.println("Unknown sort option: " + selected);
			return;
		}

		PetTableModel model = new PetTableModel(pets);
		petPanel.getPetTable().setModel(model);
	}
}
