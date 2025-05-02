package edu.gz.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

public class PetTableModel extends AbstractTableModel {
	private final String[] columnNames = { "ID", "Name", "Type", "Species", "Age", "Adopted" };
	private List<Pet> pets;

	public PetTableModel(List<Pet> pets) {
		this.pets = pets;
	}

	@Override
	public int getRowCount() {
		return pets.size();
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	@Override
	public Object getValueAt(int rowIndex, int columnIndex) {
		Pet pet = pets.get(rowIndex);
		return switch (columnIndex) {
			case 0 -> pet.getId();
			case 1 -> pet.getName();
			case 2 -> pet.getType();
			case 3 -> pet.getSpecies();
			case 4 -> pet.getAge();
			case 5 -> pet.isAdopted();
			default -> null;
		};
	}

	public void setPets(List<Pet> pets) {
		this.pets = pets;
		fireTableDataChanged();
	}
}
