package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure1;

/**
 * The Interface DiseaseControlManager.
 */
public interface DiseaseControlManager {

	/**
	 * Adds the disease.
	 *
	 * @param name       the name
	 * @param infectious the infectious
	 * @return the disease 2
	 */
	public Disease2 addDisease(String name, boolean infectious);

	/**
	 * Gets the disease.
	 *
	 * @param diseaseid the diseaseid
	 * @return the disease
	 */
	public Disease2 getDisease(UUID diseaseid);

	/**
	 * Adds the patient.
	 *
	 * @param firstname   the firstname
	 * @param lastname    the lastname
	 * @param maxDisease  the max disease
	 * @param maxExposure the max exposure
	 * @return the patient 2
	 */
	public Patient2 addPatient(String firstname, String lastname, int maxDisease, int maxExposure);

	/**
	 * Gets the patient.
	 *
	 * @param patientId the patient id
	 * @return the patient
	 */
	public Patient2 getPatient(UUID patientId);

	/**
	 * Adds the disease to patient.
	 *
	 * @param pateindId the pateind id
	 * @param diseaseId the disease id
	 */
	public void addDiseaseToPatient(UUID pateindId, UUID diseaseId);

	/**
	 * Adds the exposure to pateint.
	 *
	 * @param patiendId the patiend id
	 * @param exposure  the exposure
	 */
	public void addExposureToPatient(UUID patiendId, Exposure1 exposure);

}
