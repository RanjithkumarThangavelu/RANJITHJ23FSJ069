package edu.disease.asn1;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;

/**
 * The Class Patient1.
 */
public class Patient1 {

	/** The patient id. */
	private UUID patientId;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The exposures. */
	private Exposure1[] exposures;

	/** The disease ids. */
	private UUID[] diseaseIds;

	/**
	 * Instantiates a new patient 1.
	 */
	public Patient1() {

	}

	/**
	 * Instantiates a new patient 1.
	 *
	 * @param es the es
	 */
	public Patient1(Exposure1 es) {
		this.exposures = new Exposure1[] { es };
	}

	/**
	 * Instantiates a new patient 1.
	 *
	 * @param patient the patient
	 */
	public Patient1(UUID patient) {
		this.patientId = patient;
	}

	/**
	 * Instantiates a new patient 1.
	 *
	 * @param patient the patient
	 * @param fname   the fname
	 * @param lname   the lname
	 */
	public Patient1(UUID patient, String fname, String lname) {
		this.patientId = patient;
		this.firstName = fname;
		this.lastName = lname;
	}

	/**
	 * Instantiates a new patient 1.
	 *
	 * @param fname the fname
	 * @param lname the lname
	 */
	public Patient1(String fname, String lname) {
		this.firstName = fname;
		this.lastName = lname;
	}

	/**
	 * Instantiates a new patient 1.
	 *
	 * @param maxDiseases  the max diseases
	 * @param maxExposures the max exposures
	 */
	public Patient1(int[] maxDiseases, int[] maxExposures) {
		if (maxDiseases == null || maxExposures == null || maxDiseases.length != 1 || maxExposures.length != 1
				|| maxDiseases[0] <= 0 || maxExposures[0] <= 0) {
			throw new IllegalArgumentException("Invalid maxDiseases or maxExposures values");
		}

		this.diseaseIds = new UUID[maxDiseases[0]];
		this.exposures = new Exposure1[maxExposures[0]];
	}

	/**
	 * Adds the disease id.
	 *
	 * @param valueToAdd the value to add
	 */
	public void addDiseaseId(UUID valueToAdd) {
		int emptyIndex = -1;
		for (int i = 0; i < diseaseIds.length; i++) {
			if (diseaseIds[i] == null) {
				emptyIndex = i;
				break;
			}
		}

		if (emptyIndex != -1) {
			diseaseIds[emptyIndex] = valueToAdd;
		} else {
			throw new ArrayIndexOutOfBoundsException("diseaseIds array is full");
		}
	}

	/**
	 * Adds the exposure.
	 *
	 * @param exposureToAdd the exposure to add
	 */
	public void addExposure(Exposure1 exposureToAdd) {
		// Find an empty index to add the exposure
		int emptyIndex = -1;
		for (int i = 0; i < exposures.length; i++) {
			if (exposures[i] == null) {
				emptyIndex = i;
				break;
			}
		}

		if (emptyIndex != -1) {
			exposures[emptyIndex] = exposureToAdd;
		} else {
			throw new ArrayIndexOutOfBoundsException("exposures array has reached its maximum capacity ");
		}
	}

	/**
	 * Gets the patient id.
	 *
	 * @return the patient id
	 */
	public UUID getPatientId() {
		return patientId;
	}

	/**
	 * Sets the patient id.
	 *
	 * @param patientId the new patient id
	 */
	public void setPatientId(UUID patientId) {
		this.patientId = patientId;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstname the new first name
	 */
	public void setFirstName(String firstname) {
		this.firstName = firstname;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastname the new last name
	 */
	public void setLastName(String lastname) {
		this.lastName = lastname;
	}

	/**
	 * Gets the exposures.
	 *
	 * @return the exposures
	 */
	public Exposure1[] getExposures() {
		return exposures;
	}

	/**
	 * Sets the exposures.
	 *
	 * @param exposures the new exposures
	 */
	public void setExposures(Exposure1[] exposures) {
		this.exposures = exposures;
	}

	/**
	 * Gets the disease ids.
	 *
	 * @return the disease ids
	 */
	public UUID[] getDiseaseIds() {
		return diseaseIds;
	}

	/**
	 * Sets the disease ids.
	 *
	 * @param diseaseIds the new disease ids
	 */
	public void setDiseaseIds(UUID[] diseaseIds) {
		this.diseaseIds = diseaseIds;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		int result = 17;

		if (patientId != null) {
			result = 31 * result + patientId.hashCode();
		}

		if (firstName != null) {
			result = 31 * result + firstName.hashCode();
		}
		if (lastName != null) {
			result = 31 * result + lastName.hashCode();
		}

		return result;
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
		Patient1 other = (Patient1) obj;

		if (patientId != null) {
			return patientId.equals(other.patientId);
		}

		if (diseaseIds != null && exposures != null) {
			return Arrays.equals(diseaseIds, other.diseaseIds) && Arrays.equals(exposures, other.exposures);
		}

		if (exposures != null) {
			return Arrays.equals(exposures, other.exposures);
		}

		if (firstName != null && lastName != null) {
			return firstName.equals(other.firstName) && lastName.equals(other.lastName);
		}

		return false;
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "[ PatentId :" + this.patientId + " firstName : " + this.firstName + " lastName : " + this.lastName
				+ " DiseaseId : " + this.diseaseIds + " Exposures : ]" + this.exposures;
	}

}