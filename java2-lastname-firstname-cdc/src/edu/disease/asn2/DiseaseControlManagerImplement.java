package edu.disease.asn2;

import java.util.UUID;

import edu.disease.asn1.Exposure1;

/**
 * The Class DiseaseControlManagerImplement.
 */
public class DiseaseControlManagerImplement implements DiseaseControlManager {

	/** The diseases. */
	private Disease2[] diseases;

	/** The patients. */
	private Patient2[] patients;

	/**
	 * Instantiates a new disease control manager implement.
	 *
	 * @param maxDiseases the max diseases
	 * @param maxPatients the max patients
	 */
	public DiseaseControlManagerImplement(int maxDiseases, int maxPatients) {
		if (maxDiseases <= 0 || maxPatients <= 0) {
			throw new IllegalArgumentException("Max diseases and Patient must be greater than 0");
		}
		this.diseases = new Disease2[maxDiseases];
		this.patients = new Patient2[maxPatients];

	}
 
	/**
	 * Adds the disease.
	 *
	 * @param name       the name
	 * @param infectious the infectious
	 * @return the disease 2
	 */
	@Override
	public Disease2 addDisease(String name, boolean infectious) {
		int index = findEmptyDiseaseSlot();
		if (index == -1) {
			throw new IllegalStateException("Array is full");
		}

		Disease2 newDisease = createDiseaseInstance(infectious);
		newDisease.setName(name);
		newDisease.setDiseaseId(UUID.randomUUID());

		diseases[index] = newDisease;
		return newDisease;
	}

	/**
	 * Find empty disease slot.
	 *
	 * @return the int
	 */
	private int findEmptyDiseaseSlot() {
		for (int i = 0; i < diseases.length; i++) {
			if (diseases[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Creates the disease instance.
	 *
	 * @param infectious the infectious
	 * @return the disease 2
	 */
	private Disease2 createDiseaseInstance(boolean infectious) {
		return infectious ? new InfectiousDisease() : new NonInfectiousDisease();
	}

	/**
	 * Adds the patient.
	 *
	 * @param firstName    the first name
	 * @param lastName     the last name
	 * @param maxDiseases  the max diseases
	 * @param maxExposures the max exposures
	 * @return the patient 2
	 */
	@Override
	public Patient2 addPatient(String firstName, String lastName, int maxDiseases, int maxExposures) {
		int index = findEmptyPatientSlot();
		if (index == -1) {
			throw new IllegalStateException("Array is full");
		}

		Patient2 patient = new Patient2(maxDiseases, maxExposures);
		patient.setFirstname(firstName);
		patient.setLastname(lastName);
		patient.setPatientid(UUID.randomUUID());

		patients[index] = patient;
		return patient;
	}

	/**
	 * Find empty patient slot.
	 *
	 * @return the int
	 */
	private int findEmptyPatientSlot() {
		for (int i = 0; i < patients.length; i++) {
			if (patients[i] == null) {
				return i;
			}
		}
		return -1;
	}

	/**
	 * Gets the disease.
	 *
	 * @param diseaseId the disease id
	 * @return the disease
	 */
	@Override
	public Disease2 getDisease(UUID diseaseId) {
		for (Disease2 disease : diseases) {
			if (disease.getDiseaseId().equals(diseaseId)) {
				return disease;
			}
		}
		return null;
	}

	/**
	 * Gets the patient.
	 *
	 * @param patientId the patient id
	 * @return the patient
	 */
	@Override
	public Patient2 getPatient(UUID patientId) {
		for (Patient2 patient : patients) {
			if (patient.getPatientid().equals(patientId)) {
				return patient;
			}
		}
		return null;
	}

	/**
	 * Adds the disease to patient.
	 *
	 * @param patientId the patient id
	 * @param diseaseId the disease id
	 */
	@Override
	public void addDiseaseToPatient(UUID patientId, UUID diseaseId) {

		for (Patient2 patient : patients) {
			if (patient.getPatientid().equals(patientId)) {
				for (Disease2 disease : diseases) {
					if (disease.getDiseaseId().equals(diseaseId)) {
						patient.addDiseaseId(disease.getDiseaseId(), 0);
						return;
					} else {
						throw new IllegalArgumentException("DiseaseId is not associated with diseaseList");
					}
				}
			} else {
				throw new IllegalArgumentException("PatientId is not associated with patientList");
			}
		}

	}

	/**
	 * Adds the exposure to patient.
	 *
	 * @param patientId the patient id
	 * @param exposure  the exposure
	 */
	@Override
	public void addExposureToPatient(UUID patientId, Exposure1 exposure) {
		for (Patient2 patient : patients) {
			if (patient.getPatientid().equals(patientId)) {
				patient.addExposure(exposure, 0);
				return;
			} else {
				throw new IllegalArgumentException("PatientId is not associated with patientList");
			}
		}
	}

}
