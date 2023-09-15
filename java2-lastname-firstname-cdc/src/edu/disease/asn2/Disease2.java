package edu.disease.asn2;

import java.util.UUID;

/**
 * The Class Disease2.
 */
public abstract class Disease2 {

	/**
	 * Gets the examples.
	 *
	 * @return the examples
	 */
	public abstract String[] getExamples();

	/** The disease id. */
	protected UUID diseaseId;

	/** The name. */
	protected String name;

	/**
	 * Instantiates a new disease 2.
	 */
	public Disease2() {

	}

	/**
	 * Instantiates a new disease 2.
	 *
	 * @param diseaseId the disease id
	 */
	public Disease2(UUID diseaseId) {
		this.diseaseId = diseaseId;
	}

	/**
	 * Instantiates a new disease 2.
	 *
	 * @param diseaseId the disease id
	 * @param name      the name
	 */
	public Disease2(UUID diseaseId, String name) {
		this.diseaseId = diseaseId;
		this.name = name;
	}

	/**
	 * Instantiates a new disease 2.
	 *
	 * @param name the name
	 */
	public Disease2(String name) {
		this.name = name;
	}

	/**
	 * Gets the disease id.
	 *
	 * @return the disease id
	 */
	public UUID getDiseaseId() {
		return diseaseId;
	}

	/**
	 * Sets the disease id.
	 *
	 * @param diseaseId the new disease id
	 */
	public void setDiseaseId(UUID diseaseId) {
		this.diseaseId = diseaseId;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		if (name == null) {
			return diseaseId.hashCode();
		} else {
			return diseaseId.hashCode() + name.hashCode();
		}
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (obj == null || getClass() != obj.getClass()) {
			return false;
		}
		Disease2 d = (Disease2) obj;

		if (diseaseId != null ? !diseaseId.equals(d.diseaseId) : d.diseaseId != null) {
			return false;
		}
		return name != null ? name.equals(d.name) : d.name == null;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "[ DiseaseId : " + this.diseaseId + " Name : ]" + this.name;
	}

	/**
	 * The Class InfectiousDisease.
	 */

}