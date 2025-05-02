package edu.gz.controller;

import edu.gz.model.Pet;
import edu.gz.model.PetTableModel;
import edu.gz.utils.ShelterManager;
import edu.gz.view.PetPanel;

import javax.swing.*;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

public class PetPanelController {

	private PetPanel petPanel;
	private ShelterManager shelterManager = ShelterManager.getInstance();

	public PetPanelController(PetPanel petPanel) {
		this.petPanel = petPanel;

		petPanel.getAddButton().addActionListener(new AddButtonListener());
		petPanel.getAdoptButton().addActionListener(new AdoptButtonListener());
		petPanel.getRemoveButton().addActionListener(new RemoveButtonListener());
		petPanel.getViewButton().addActionListener(new ViewButtonListener());
		petPanel.getSaveButton().addActionListener(new SaveButtonListener());
	}

	private class AddButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {
//			showAddPetDialog();
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
		}
	}

	private class ViewButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

	private class SaveButtonListener implements ActionListener {
		@Override
		public void actionPerformed(ActionEvent e) {

		}
	}

//	public Pet showAddPetDialog() {
//		JTextField nameField = new JTextField();
//		JTextField ageField = new JTextField();
//		JTextField speciesField = new JTextField();
//		
//		String[] speciesOptions = { "Dog", "Cat", "Rabbit", "Exotic (Other)" };
//		JComboBox<String> speciesComboBox = new JComboBox<>(speciesOptions);
//		
//		JTextField exoticField = new JTextField();
//		JLabel exoticLabel = new JLabel("Specify exotic species:");
//		
//		exoticField.setVisible(false);
//		exoticLabel.setVisible(false);
//		
//		JPanel exoticPanel = new JPanel(new GridLayout(0, 1));
//		exoticPanel.add(exoticLabel);
//		exoticPanel.add(exoticField);
//		
//		speciesComboBox.addActionListener(e -> {
//			boolean isExotic = "Exotic".equals(speciesComboBox.getSelectedItem());
//			exoticField.setVisible(isExotic);
//			exoticLabel.setVisible(isExotic);
//			exoticPanel.revalidate();
//			exoticPanel.repaint();
//		});
//		
//		JPanel panel = new JPanel();
//		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
//		panel.add(new JLabel("Name:"));
//		panel.add(nameField);
//	    panel.add(new JLabel("Age:"));
//	    panel.add(ageField);
//	    panel.add(new JLabel("Type:"));
//	    panel.add(speciesComboBox);
//	    panel.add(exoticPanel);
//	    panel.add(new JLabel("Species:"));
//	    panel.add(speciesField);
//	    
//	    while (true) {
//	    	int result = JOptionPane.showConfirmDialog(null, panel, "Add New Pet", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
//	    	
//	    	if (result != JOptionPane.OK_OPTION) {
//	    		return null;
//	    	}
//	    	
//	    	String name = nameField.getText().trim();
//	    	String ageText = ageField.getText().trim();
//	        String type = (String) speciesComboBox.getSelectedItem();
//	        String species = speciesField.getText().trim();
//	        
//	        if (name.isEmpty()) {
//	        	JOptionPane.showMessageDialog(null, "Name cannot be empty.");
//	        	continue;
//	        }
//	        
//	        int age;
//	        try {
//	        	age = Integer.parseInt(ageText);
//	        	
//	        	if (age < 0) {
//	        		throw new NumberFormatException();
//	        	}
//	        } catch (NumberFormatException e) {
//	        	JOptionPane.showMessageDialog(null, "Age must be 0 or above.");
//	        	continue;
//	        }
//	        
//	        if ("Exotic".equals(type)) {
//	        	String exoticType = exoticField.getText().trim();
//	        	if (exoticType.isEmpty()) {
//	        		JOptionPane.showMessageDialog(null, "Exotic species cannot be empty.");
//	        		continue;
//	        	}
//	        	
//	        	type = exoticType;
//	        }
//	        
//	        if (species.isEmpty()) {
//	        	JOptionPane.showMessageDialog(null, "Species cannot be empty.");
//	        	continue;
//	        }
//	        
//	        //return new Pet(id, name, type, species, false);
//	    }
//	}

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
				String petType = shelterManager.getPetById(petId).getType();
				boolean isAdopted = false;

				switch (petType) {
				case "Dog":
					isAdopted = shelterManager.adoptDog(petId);
					break;
				case "Cat":
					isAdopted = shelterManager.adoptCat(petId);
					break;
				case "Rabbit":
					isAdopted = shelterManager.adoptRabbit(petId);
					break;
				case "Exotic":
					isAdopted = shelterManager.adoptExotic(petId);
					break;
				default:
					JOptionPane.showMessageDialog(null, "Invalid pet type.");
				}
				if (isAdopted) {
					PetTableModel model = new PetTableModel(shelterManager.getAllPets());
					petPanel.getPetTable().setModel(model);
				} else {
					JOptionPane.showMessageDialog(null, "Pet has already been adopted.");
				}
			} catch (NumberFormatException ex) {
				JOptionPane.showMessageDialog(null, "Please enter a valid pet ID.");
			}
		}
	}
}
