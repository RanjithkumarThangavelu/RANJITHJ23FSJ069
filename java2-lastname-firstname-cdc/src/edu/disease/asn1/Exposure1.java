package edu.disease.asn1;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

/**
 * The Class Exposure1.
 */
public class Exposure1 {

	/** The patient id. */
	private UUID patientId;

	/** The date time. */
	private java.time.LocalDateTime dateTime;

	/** The exposure type. */
	private String exposureType;

	/**
	 * Instantiates a new exposure 1.
	 */
	public Exposure1() {

	}

	/**
	 * Instantiates a new exposure 1.
	 *
	 * @param a the a
	 */
	public Exposure1(UUID a) {
		this.patientId = a;
	}

	/**
	 * Instantiates a new exposure 1.
	 *
	 * @param patientId    the patient id
	 * @param datetime     the datetime
	 * @param exposureType the exposure type
	 */
	public Exposure1(UUID patientId, LocalDateTime datetime, String exposureType) {
		super();
		this.patientId = patientId;
		this.dateTime = datetime;
		this.exposureType = exposureType;
	}

	/**
	 * Gets the date time.
	 *
	 * @return the date time
	 */
	public java.time.LocalDateTime getDateTime() {
		return dateTime;
	}

	/**
	 * Sets the date time.
	 *
	 * @param dateTime the new date time
	 */
	public void setDateTime(java.time.LocalDateTime dateTime) {
		this.dateTime = dateTime;
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
	 * @param object the new patient id
	 */
	public void setPatientId(UUID object) {
		this.patientId = object;
	}

	/**
	 * Exposure type.
	 *
	 * @return the string
	 */
	public String exposureType() {
		return exposureType;
	}

	/**
	 * Sets the exposure type.
	 *
	 * @param exposureType the new exposure type
	 */
	public void setExposureType(String exposureType) {
		if (exposureType.equals("D") || exposureType.equals("T")) {
			this.exposureType = exposureType;
		} else {
			throw new IllegalArgumentException("Exposure type must be 'D' or 'T'");
		}
	}

	/**
	 * Hash code.
	 *
	 * @return the int
	 */
	@Override
	public int hashCode() {
		return Objects.hash(dateTime, patientId);
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
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Exposure1 other = (Exposure1) obj;
		return Objects.equals(dateTime, other.dateTime) && Objects.equals(patientId, other.patientId);
	}

}