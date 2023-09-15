package edu.disease.asn2;

import java.util.Objects;
import java.util.UUID;

import edu.disease.asn1.Exposure1;

/**
 * The Class Patient2.
 */
public class Patient2 {

	/** The patientid. */
	private UUID patientid;

	/** The firstname. */
	private String firstname;

	/** The lastname. */
	private String lastname;

	/** The exposure. */
	private Exposure1[] exposure;

	/** The diseaseids. */
	private UUID[] diseaseids;

	/**
	 * Instantiates a new patient 2.
	 *
	 * @param maxDiseases the max diseases
	 * @param maxExposure the max exposure
	 */
	public Patient2(int maxDiseases, int maxExposure) {
		if (maxDiseases <= 0 || maxExposure <= 0) {
			throw new IllegalArgumentException("The value cannont be used to initiate the array");
		}
		this.diseaseids = new UUID[maxDiseases];
		this.exposure = new Exposure1[maxExposure];

	}

	/**
	 * Compare to.
	 *
	 * @param other the other
	 * @return the int
	 */
	public int compareTo(Patient2 other) {
		int lastNameComparison = compareNames(this.lastname, other.lastname);

		if (lastNameComparison != 0) {
			return lastNameComparison;
		}

		return compareNames(this.firstname, other.firstname);
	}

	/**
	 * Compare names.
	 *
	 * @param name1 the name 1
	 * @param name2 the name 2
	 * @return the int
	 */
	private int compareNames(String name1, String name2) {
		if (name1 == null && name2 == null) {
			return 0;
		} else if (name1 == null) {
			return -1;
		} else if (name2 == null) {
			return 1;
		} else {
			return name1.compareToIgnoreCase(name2);
		}
	}

	/**
	 * Adds the disease id.
	 *
	 * @param diseaseId the disease id
	 * @param index     the index
	 */
	public void addDiseaseId(UUID diseaseId, int index) {
		this.diseaseids[index] = diseaseId;

	}

	/**
	 * Adds the exposure.
	 *
	 * @param exposure the exposure
	 * @param index    the index
	 */
	public void addExposure(Exposure1 exposure, int index) {
		this.exposure[index] = exposure;
	}

	/**
	 * Gets the patientid.
	 *
	 * @return the patientid
	 */
	public UUID getPatientid() {
		return patientid;
	}

	/**
	 * Sets the patientid.
	 *
	 * @param uuid the new patientid
	 */
	public void setPatientid(UUID uuid) {
		this.patientid = uuid;
	}

	/**
	 * Gets the firstname.
	 *
	 * @return the firstname
	 */
	public String getFirstname() {
		return firstname;
	}

	/**
	 * Sets the firstname.
	 *
	 * @param firstname the new firstname
	 */
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	/**
	 * Gets the lastname.
	 *
	 * @return the lastname
	 */
	public String getLastname() {
		return lastname;
	}

	/**
	 * Sets the lastname.
	 *
	 * @param lastname the new lastname
	 */
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	/**
	 * Gets the exposure.
	 *
	 * @return the exposure
	 */
	public Exposure1[] getExposure() {
		return exposure;
	}

	/**
	 * Gets the diseaseids.
	 *
	 * @return the diseaseids
	 */
	public UUID[] getDiseaseids() {
		return diseaseids;
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(patientid);
	}

	/**
	 * Equals.
	 *
	 * @param obj the obj
	 * @return true, if successful
	 */
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		Patient2 other = (Patient2) obj;
		return Objects.equals(patientid, other.patientid);
	}

	/**
	 * To string.
	 *
	 * @return the string
	 */
	@Override
	public String toString() {
		return "Patient2 [patientid=" + patientid + ", firstname=" + firstname + ", lastname=" + lastname + "]";
	}

}
