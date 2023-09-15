package edu.disease.asn2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.Test;

import edu.disease.asn1.Exposure1;

/**
 * The Class Patient2Test.
 */ 
public class Patient2Test {

	/**
	 * Test compare to same last and first names.
	 */
	@Test
	public void testCompareTo_SameLastAndFirstNames() {
		Patient2 patient1 = new Patient2(3, 2);
		patient1.setFirstname("John");
		patient1.setLastname("Doe");

		Patient2 patient2 = new Patient2(3, 2);
		patient2.setFirstname("John");
		patient2.setLastname("Doe");

		assertEquals(0, patient1.compareTo(patient2));
	}

	/**
	 * Test compare to last name null.
	 */
	@Test
	public void testCompareTo_LastNameNull() {
		Patient2 patient1 = new Patient2(3, 2);
		patient1.setFirstname("John");

		Patient2 patient2 = new Patient2(3, 2);
		patient2.setFirstname("Jane");
		patient2.setLastname("Doe");

		assertEquals(-1, patient1.compareTo(patient2));
	}

	/**
	 * Test compare to different last names.
	 */
	@Test
	public void testCompareTo_DifferentLastNames() {
		Patient2 patient1 = new Patient2(3, 2);
		patient1.setFirstname("John");
		patient1.setLastname("Doe");

		Patient2 patient2 = new Patient2(3, 2);
		patient2.setFirstname("Jane");
		patient2.setLastname("Smith");

		assertTrue(patient1.compareTo(patient2) < 0);
	}

	/**
	 * Test compare to different first names.
	 */
	@Test
	public void testCompareTo_DifferentFirstNames() {
		Patient2 patient1 = new Patient2(3, 2);
		patient1.setFirstname("John");
		patient1.setLastname("Doe");

		Patient2 patient2 = new Patient2(3, 2);
		patient2.setFirstname("Jane");
		patient2.setLastname("Doe");

		assertTrue(patient1.compareTo(patient2) > 0);
	}

	/**
	 * Test add disease id.
	 */
	@Test
	public void testAddDiseaseId() {
		Patient2 patient = new Patient2(3, 2);
		UUID diseaseId = UUID.randomUUID();

		patient.addDiseaseId(diseaseId, 0);
		assertEquals(diseaseId, patient.getDiseaseids()[0]);
	}

	/**
	 * Test add exposure.
	 */
	@Test
	public void testAddExposure() {
		Patient2 patient = new Patient2(3, 2);
		Exposure1 exposure = new Exposure1();

		patient.addExposure(exposure, 0);
		assertEquals(exposure, patient.getExposure()[0]);
	}

	/**
	 * Test get set patient id.
	 */
	@Test
	public void testGetSetPatientId() {
		Patient2 patient = new Patient2(3, 2);
		UUID patientId = UUID.randomUUID();

		patient.setPatientid(patientId);
		assertEquals(patientId, patient.getPatientid());
	}

	/**
	 * Test get set first name.
	 */
	@Test
	public void testGetSetFirstName() {
		Patient2 patient = new Patient2(3, 2);
		patient.setFirstname("John");
		assertEquals("John", patient.getFirstname());
	}

	/**
	 * Test get set last name.
	 */
	@Test
	public void testGetSetLastName() {
		Patient2 patient = new Patient2(3, 2);
		patient.setLastname("Doe");
		assertEquals("Doe", patient.getLastname());
	}

	/**
	 * Test get exposure.
	 */
	@Test
	public void testGetExposure() {
		Patient2 patient = new Patient2(3, 2);
		assertNotNull(patient.getExposure());
		assertEquals(2, patient.getExposure().length);
	}

	/**
	 * Test get disease ids.
	 */
	@Test
	public void testGetDiseaseIds() {
		Patient2 patient = new Patient2(3, 2);
		assertNotNull(patient.getDiseaseids());
		assertEquals(3, patient.getDiseaseids().length);
	}

	/**
	 * Test hash code.
	 */
	@Test
	public void testHashCode() {
		Patient2 patient1 = new Patient2(3, 2);
		UUID patientId1 = UUID.randomUUID();
		patient1.setPatientid(patientId1);

		Patient2 patient2 = new Patient2(3, 2);
		UUID patientId2 = UUID.randomUUID();
		patient2.setPatientid(patientId2);

		assertNotEquals(patient1.hashCode(), patient2.hashCode());

	}

	/**
	 * Test equals.
	 */
	@Test
	public void testEquals() {
		Patient2 patient1 = new Patient2(3, 2);
		UUID patientId1 = UUID.randomUUID();
		patient1.setPatientid(patientId1);

		Patient2 patient2 = new Patient2(3, 2);
		UUID patientId2 = UUID.randomUUID();
		patient2.setPatientid(patientId2);

		assertFalse(patient1.equals(patient2));
		assertTrue(patient1.equals(patient1));

	}

	/**
	 * Test to string.
	 */
	@Test
	public void testToString() {
		Patient2 patient = new Patient2(3, 2);
		patient.setPatientid(UUID.randomUUID());
		patient.setFirstname("John");
		patient.setLastname("Doe");

		String expectedString = "Patient2 [patientid=" + patient.getPatientid() + ", firstname=John, lastname=Doe]";
		assertEquals(expectedString, patient.toString());
	}

}
