package edu.gz.model;

/**
 * Represents an ExoticAnimal with properties such as unique ID, name, category,
 * sub-species, and age. This class provides getters and setters to access and
 * modify these properties.
 */
public class ExoticAnimal {
	private String uniqueId;
	private String animalName;
	private String category;
	private String subSpecies;
	private int yearsOld;

	/**
	 * Default constructor for ExoticAnimal.
	 * Initializes an instance with default (null/zero) values.
	 */
	public ExoticAnimal() {

	}

	/**
	 * Constructs an ExoticAnimal from an ExoticAnimalAdapter.
	 * Generates the unique ID in the format "exoXXX", and sets the name, category,
	 * sub-species, and age using data from the adapter.
	 *
	 * @param adapter the ExoticAnimalAdapter containing initialization data
	 */
	public ExoticAnimal(ExoticAnimalAdapter adapter) {
		this.uniqueId = String.format("exo%03d", adapter.getId());
		this.animalName = adapter.getName();
		this.category = adapter.getType();
		this.subSpecies = adapter.getSpecies();
		this.yearsOld = adapter.getAge();
	}

	/**
	 * Returns the unique ID of the exotic animal.
	 *
	 * @return the unique ID of the animal
	 */
	public String getUniqueId() {
		return uniqueId;
	}

	/**
	 * Safely extracts and returns the numeric ID from the uniqueId string. Assumes
	 * uniqueId is formatted as "exoXXX", where XXX is a zero-padded integer (e.g.,
	 * "exo001"). If the format is invalid, returns -1.
	 *
	 * @return the integer ID part of the uniqueId string, or -1 if the format is
	 *         invalid
	 */
	public int getId() {
		if (uniqueId != null && uniqueId.startsWith("exo") && uniqueId.length() > 3) {
			try {
				return Integer.parseInt(uniqueId.substring(3));
			} catch (NumberFormatException e) {
				
			}
		}
		
		return -1;
	}

	/**
	 * Returns the name of the exotic animal.
	 *
	 * @return the name of the animal
	 */
	public String getAnimalName() {
		return animalName;
	}

	/**
	 * Returns the category of the exotic animal (e.g., Mammal, Reptile).
	 *
	 * @return the category of the animal
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Returns the sub-species of the exotic animal.
	 *
	 * @return the sub-species of the animal
	 */
	public String getSubSpecies() {
		return subSpecies;
	}

	/**
	 * Returns the age of the exotic animal in years.
	 *
	 * @return the age of the animal
	 */
	public int getYearsOld() {
		return yearsOld;
	}

	/**
	 * Sets the unique ID of the exotic animal.
	 *
	 * @param uniqueId the new unique ID of the animal
	 */
	public void setUniqueId(String uniqueId) {
		this.uniqueId = uniqueId;
	}

	/**
	 * Sets the unique ID of the exotic animal.
	 *
	 * @param id the ID in Pet ID format.
	 */
	public void setUniqueIdFromId(int id) {
		this.uniqueId = String.format("exo%03d", id);
	}

	/**
	 * Sets the name of the exotic animal.
	 *
	 * @param animalName the new name of the animal
	 */
	public void setAnimalName(String animalName) {
		this.animalName = animalName;
	}

	/**
	 * Sets the category of the exotic animal.
	 *
	 * @param category the new category of the animal
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Sets the sub-species of the exotic animal.
	 *
	 * @param subSpecies the new sub-species of the animal
	 */
	public void setSubSpecies(String subSpecies) {
		this.subSpecies = subSpecies;
	}

	/**
	 * Sets the age of the exotic animal in years.
	 *
	 * @param yearsOld the new age of the animal
	 */
	public void setYearsOld(int yearsOld) {
		this.yearsOld = yearsOld;
	}
}
