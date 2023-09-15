package edu.disease.asn2;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;

import java.util.UUID;

import org.junit.Test;

import edu.disease.asn1.Exposure1;

/**
 * The Class DiseaseControlManagerImplementTest.
 */
public class DiseaseControlManagerImplementTest {

	/**
	 * Test add disease.
	 */
	@Test
	public void testAddDisease() {
		DiseaseControlManagerImplement manager = new DiseaseControlManagerImplement(5, 5);
		Disease2 disease = manager.addDisease("Influenza", true);
		assertNotNull(disease);
		assertEquals("Influenza", disease.getName());
		disease = manager.addDisease("Asthma", false);
		assertNotNull(disease);
		assertEquals("Asthma", disease.getName());
		assertThrows(IllegalStateException.class, () -> {
			for (int i = 0; i < 6; i++) {
				manager.addDisease("Test Disease " + i, true);
			}
		});
	}

	/**
	 * Test get disease.
	 */
	@Test
	public void testGetDisease() {
		DiseaseControlManagerImplement manager = new DiseaseControlManagerImplement(5, 5);
		Disease2 disease = manager.addDisease("Influenza", true);
		UUID diseaseId = disease.getDiseaseId();

		Disease2 retrievedDisease = manager.getDisease(diseaseId);
		assertNotNull(retrievedDisease);
		assertEquals(diseaseId, retrievedDisease.getDiseaseId());

	}

	/**
	 * Test get patient.
	 */
	@Test
	public void testGetPatient() {
		DiseaseControlManagerImplement manager = new DiseaseControlManagerImplement(5, 5);

		Patient2 patient = manager.addPatient("John", "Doe", 3, 2);
		UUID patientId = patient.getPatientid();

		Patient2 retrievedPatient = manager.getPatient(patientId);
		assertNotNull(retrievedPatient);
		assertEquals(patientId, retrievedPatient.getPatientid());
	}

	/**
	 * Test add disease to patient.
	 */
	@Test
	public void testAddDiseaseToPatient() {
		DiseaseControlManagerImplement manager = new DiseaseControlManagerImplement(5, 5);

		Disease2 disease = manager.addDisease("Influenza", true);
		UUID diseaseId = disease.getDiseaseId();

		Patient2 patient = manager.addPatient("John", "Doe", 3, 2);
		UUID patientId = patient.getPatientid();

		manager.addDiseaseToPatient(patientId, diseaseId);

		assertEquals(diseaseId, patient.getDiseaseids()[0]);
		
		assertThrows(IllegalArgumentException.class, () -> manager.addDiseaseToPatient(patientId, UUID.randomUUID()));

		assertThrows(IllegalArgumentException.class, () -> manager.addDiseaseToPatient(UUID.randomUUID(), diseaseId));
	}

	/**
	 * Test add exposure to patient.
	 */
	@Test
	public void testAddExposureToPatient() {
		DiseaseControlManagerImplement manager = new DiseaseControlManagerImplement(5, 5);

		Patient2 patient = manager.addPatient("John", "Doe", 3, 2);
		UUID patientId = patient.getPatientid();

		Exposure1 exposure = new Exposure1();

		manager.addExposureToPatient(patientId, exposure);

		assertEquals(exposure, patient.getExposure()[0]);

		assertThrows(IllegalArgumentException.class, () -> manager.addExposureToPatient(UUID.randomUUID(), exposure));
	}

}
