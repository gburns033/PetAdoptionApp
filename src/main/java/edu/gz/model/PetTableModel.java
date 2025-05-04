package edu.gz.model;

import javax.swing.table.AbstractTableModel;
import java.util.List;

/**
 * A table model for displaying a list of {@link Pet} objects in a Swing {@code JTable}.
 * Provides the necessary methods to integrate pet data into a table format, including
 * column definitions and data retrieval by row and column.
 */
public class PetTableModel extends AbstractTableModel {
	private final String[] columnNames = { "ID", "Name", "Type", "Species", "Age", "Adopted" };
	private List<Pet> pets;

	/**
	 * Constructs a {@code PetTableModel} with the given list of pets.
	 *
	 * @param pets the list of pets to be displayed in the table
	 */
	public PetTableModel(List<Pet> pets) {
		this.pets = pets;
	}

	/**
	 * Returns the number of rows in the table, which corresponds to the number of pets.
	 *
	 * @return the number of rows
	 */
	@Override
	public int getRowCount() {
		return pets.size();
	}

	/**
	 * Returns the number of columns in the table.
	 *
	 * @return the number of columns
	 */
	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	/**
	 * Returns the name of the column at the specified index.
	 *
	 * @param column the index of the column
	 * @return the name of the column
	 */
	@Override
	public String getColumnName(int column) {
		return columnNames[column];
	}

	/**
	 * Returns the value at the specified row and column.
	 * Extracts the corresponding field from the {@link Pet} object.
	 *
	 * @param rowIndex    the row index of the cell
	 * @param columnIndex the column index of the cell
	 * @return the value at the specified cell
	 */
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

	/**
	 * Sets the list of pets to be displayed and refreshes the table data.
	 *
	 * @param pets the new list of pets
	 */
	public void setPets(List<Pet> pets) {
		this.pets = pets;
		fireTableDataChanged();
	}
}
