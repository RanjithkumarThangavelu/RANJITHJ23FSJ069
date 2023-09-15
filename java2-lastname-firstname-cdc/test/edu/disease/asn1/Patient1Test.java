package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.UUID;

import org.junit.Test;

/**
 * The Class Patient1Test.
 */
public class Patient1Test {

	/**
	 * Test patient equality with patient id.
	 */
	@Test
	public void testPatientEqualityWithPatientId() {
		UUID patientId1 = UUID.randomUUID();
		UUID patientId2 = UUID.randomUUID();

		Patient1 patient1 = new Patient1(patientId1);
		Patient1 patient2 = new Patient1(patientId2);

		assertFalse(patient1.equals(patient2));
		assertTrue(patient1.equals(patient1));
	}

	/**
	 * Test patient equality with firstname and lastname.
	 */
	@Test
	public void testPatientEqualityWithFirstnameAndLastname() {
		Patient1 patient1 = new Patient1("John", "Doe");
		Patient1 patient2 = new Patient1("Jane", "Smith");

		assertFalse(patient1.equals(patient2));
		assertTrue(patient1.equals(patient1));
	}

	/**
	 * Test patient equality with mixed fields.
	 */
	@Test
	public void testPatientEqualityWithMixedFields() {
		UUID patientId = UUID.randomUUID();

		Patient1 patient1 = new Patient1(patientId, "John", "Doe");
		Patient1 patient2 = new Patient1(patientId, "John", "Doe");
		patient1.setDiseaseIds(new UUID[] { UUID.randomUUID() });
		patient2.setDiseaseIds(new UUID[] { UUID.randomUUID() });
		patient1.setExposures(new Exposure1[] { new Exposure1(patientId) });
		patient2.setExposures(new Exposure1[] { new Exposure1(patientId) });

		assertTrue(patient1.equals(patient2));
	}

	/**
	 * Test patient inequality.
	 */
	@Test
	public void testPatientInequality() {
		UUID patientId = UUID.randomUUID();

		Patient1 patient1 = new Patient1(patientId, "John", "Doe");
		Patient1 patient2 = new Patient1(UUID.randomUUID(), "Jane", "Smith");

		assertFalse(patient1.equals(patient2));
	}

	/**
	 * Test equals and hash code with patient id.
	 */
	@Test
	public void testEqualsAndHashCodeWithPatientId() {
		UUID patientId1 = UUID.randomUUID();
		UUID patientId2 = UUID.randomUUID();

		Patient1 patient1 = new Patient1(patientId1);
		Patient1 patient2 = new Patient1(patientId1);
		Patient1 patient3 = new Patient1(patientId2);

		assertTrue(patient1.equals(patient2));
		assertFalse(patient1.equals(patient3));

		assertEquals(patient1.hashCode(), patient2.hashCode());
		assertNotEquals(patient1.hashCode(), patient3.hashCode());
	}

	/**
	 * Test equals and hash code with firstname and lastname.
	 */
	@Test
	public void testEqualsAndHashCodeWithFirstnameAndLastname() {
		Patient1 patient1 = new Patient1("John", "Doe");
		Patient1 patient2 = new Patient1("John", "Doe");
		Patient1 patient3 = new Patient1("Jane", "Doe");

		assertTrue(patient1.equals(patient2));
		assertFalse(patient1.equals(patient3));

		assertEquals(patient1.hashCode(), patient2.hashCode());
		assertNotEquals(patient1.hashCode(), patient3.hashCode());
	}

	/**
	 * Test constructor with valid values.
	 */
	@Test
	public void testConstructorWithValidValues() {
		int[] maxDiseases = { 5 };
		int[] maxExposures = { 3 };

		Patient1 patient = new Patient1(maxDiseases, maxExposures);

		assertNotNull(patient.getDiseaseIds());
		assertNotNull(patient.getExposures());
		assertEquals(maxDiseases[0], patient.getDiseaseIds().length);
		assertEquals(maxExposures[0], patient.getExposures().length);
	}

	/**
	 * Test constructor with invalid values.
	 */
	@Test
	public void testConstructorWithInvalidValues() {
		int[] invalidMaxDiseases = { 0 };
		int[] invalidMaxExposures = { -1 };
		assertThrows(IllegalArgumentException.class, () -> new Patient1(invalidMaxDiseases, invalidMaxExposures));
	}

	/**
	 * Test add disease id.
	 */
	@Test
	public void testAddDiseaseId() {
		UUID id1 = UUID.randomUUID();
		UUID id2 = UUID.randomUUID();
		UUID id3 = UUID.randomUUID();

		int maxDiseases = 3;
		int maxExposures = 5;
		Patient1 patient = new Patient1(new int[] { maxDiseases }, new int[] { maxExposures });

		patient.addDiseaseId(id1);
		assertEquals(id1, patient.getDiseaseIds()[0]);

		patient.addDiseaseId(id2);
		assertEquals(id2, patient.getDiseaseIds()[1]);

		patient.addDiseaseId(id3);
		assertEquals(id3, patient.getDiseaseIds()[2]);
		assertThrows(ArrayIndexOutOfBoundsException.class, () -> patient.addDiseaseId(UUID.randomUUID()));
	}

	/**
	 * Test equals with same object.
	 */
	@Test
	public void testEqualsWithSameObject() {
		Patient1 patient = new Patient1();
		assertTrue(patient.equals(patient));
	}

	/**
	 * Test equals with null object.
	 */
	@Test
	public void testEqualsWithNullObject() {
		Patient1 patient = new Patient1();
		assertFalse(patient.equals(null));
	}

	/**
	 * Test equals with different class.
	 */
	@Test
	public void testEqualsWithDifferentClass() {
		Patient1 patient = new Patient1();
		assertFalse(patient.equals("Not a Patient object"));
	}

	/**
	 * Test equals with equal patient ids.
	 */
	@Test
	public void testEqualsWithEqualPatientIds() {
		UUID patientId = UUID.randomUUID();
		Patient1 patient1 = new Patient1(patientId);
		Patient1 patient2 = new Patient1(patientId);
		assertTrue(patient1.equals(patient2));
	}

	/**
	 * Test equals with different patient ids.
	 */
	@Test
	public void testEqualsWithDifferentPatientIds() {
		Patient1 patient1 = new Patient1(UUID.randomUUID());
		Patient1 patient2 = new Patient1(UUID.randomUUID());
		assertFalse(patient1.equals(patient2));
	}

	/**
	 * Test equals with equal disease ids and exposures.
	 */
	@Test
	public void testEqualsWithEqualDiseaseIdsAndExposures() {
		Exposure1 exposure1 = new Exposure1();
		Exposure1 exposure2 = new Exposure1();
		UUID[] diseaseIds1 = { UUID.randomUUID() };
		UUID[] diseaseIds2 = { UUID.randomUUID() };
		Exposure1[] exposures1 = { exposure1 };
		Exposure1[] exposures2 = { exposure2 };

		Patient1 patient1 = new Patient1();
		Patient1 patient2 = new Patient1();
		Patient1 patient3 = new Patient1();

		patient1.setDiseaseIds(diseaseIds1);
		patient1.setExposures(exposures1);

		patient2.setDiseaseIds(diseaseIds1);
		patient2.setExposures(exposures1);

		patient3.setDiseaseIds(diseaseIds2);
		patient3.setExposures(exposures2);

		assertTrue(patient1.equals(patient2));
		assertFalse(patient1.equals(patient3));
	}

	/**
	 * Test equals with equal first and last names.
	 */
	@Test
	public void testEqualsWithEqualFirstAndLastNames() {
		Patient1 patient1 = new Patient1("John", "Doe");
		Patient1 patient2 = new Patient1("John", "Doe");
		assertTrue(patient1.equals(patient2));
	}

	/**
	 * Test equals with different first names.
	 */
	@Test
	public void testEqualsWithDifferentFirstNames() {
		Patient1 patient1 = new Patient1("John", "Doe");
		Patient1 patient2 = new Patient1("Jane", "Doe");
		assertFalse(patient1.equals(patient2));
	}

	/**
	 * Test equals with different last names.
	 */
	@Test
	public void testEqualsWithDifferentLastNames() {
		Patient1 patient1 = new Patient1("John", "Doe");
		Patient1 patient2 = new Patient1("John", "Smith");
		assertFalse(patient1.equals(patient2));
	}

	/**
	 * Test get set patient id.
	 */
	@Test
	public void testGetSetPatientId() {
		UUID patientId = UUID.randomUUID();
		Patient1 patient = new Patient1();

		patient.setPatientId(patientId);
		assertEquals(patientId, patient.getPatientId());
	}

	/**
	 * Test get set firstname.
	 */
	@Test
	public void testGetSetFirstname() {
		String firstname = "John";
		Patient1 patient = new Patient1();

		patient.setFirstName(firstname);
		assertEquals(firstname, patient.getFirstName());
	}

	/**
	 * Test get set lastname.
	 */
	@Test
	public void testGetSetLastname() {
		String lastname = "Doe";
		Patient1 patient = new Patient1();

		patient.setLastName(lastname);
		assertEquals(lastname, patient.getLastName());
	}

	/**
	 * Test hash code with different fields.
	 */
	@Test
	public void testHashCodeWithDifferentFields() {
		Patient1 patient1 = new Patient1();
		patient1.setPatientId(UUID.randomUUID());
		patient1.setFirstName("John");

		Patient1 patient2 = new Patient1();
		patient2.setLastName("Doe");

		assertNotEquals(patient1.hashCode(), patient2.hashCode());
	}

	/**
	 * Test hash code with null fields.
	 */
	@Test
	public void testHashCodeWithNullFields() {
		Patient1 patient1 = new Patient1();
		patient1.setPatientId(null);

		Patient1 patient2 = new Patient1();
		patient2.setLastName(null);

		assertEquals(patient1.hashCode(), patient2.hashCode());
	}

	/**
	 * Test equals with patient id.
	 */
	@Test
	public void testEqualsWithPatientId() {
		Patient1 patient1 = new Patient1();
		patient1.setPatientId(UUID.randomUUID());

		Patient1 patient2 = new Patient1();
		patient2.setPatientId(patient1.getPatientId());

		assertTrue(patient1.equals(patient2));
	}

	/**
	 * Test equals with disease ids and exposures.
	 */
	@Test
	public void testEqualsWithDiseaseIdsAndExposures() {
		Patient1 patient1 = new Patient1();
		patient1.setDiseaseIds(new UUID[] { UUID.randomUUID() });
		patient1.setExposures(new Exposure1[] { new Exposure1() });

		Patient1 patient2 = new Patient1();
		patient2.setDiseaseIds(patient1.getDiseaseIds());
		patient2.setExposures(patient1.getExposures());

		assertTrue(patient1.equals(patient2));
	}

	/**
	 * Test equals with firstname and lastname.
	 */
	@Test
	public void testEqualsWithFirstnameAndLastname() {
		Patient1 patient1 = new Patient1();
		patient1.setFirstName("John");
		patient1.setLastName("Doe");

		Patient1 patient2 = new Patient1();
		patient2.setFirstName(patient1.getFirstName());
		patient2.setLastName(patient1.getLastName());

		assertTrue(patient1.equals(patient2));
	}

	/**
	 * Test equals with different fields.
	 */
	@Test
	public void testEqualsWithDifferentFields() {
		Patient1 patient1 = new Patient1();
		patient1.setPatientId(UUID.randomUUID());

		Patient1 patient2 = new Patient1();
		patient2.setFirstName("John");

		assertFalse(patient1.equals(patient2));
	}

	/**
	 * Test to string.
	 */
	@Test
	public void testToString() {
		UUID patientId = UUID.randomUUID();
		String firstName = "John";
		String lastName = "Doe";
		UUID[] diseaseIds = { UUID.randomUUID(), UUID.randomUUID() };
		Exposure1[] exposures = { new Exposure1() };

		Patient1 patient = new Patient1();
		patient.setPatientId(patientId);
		patient.setFirstName(firstName);
		patient.setLastName(lastName);
		patient.setDiseaseIds(diseaseIds);
		patient.setExposures(exposures);

		String expected = "[ PatentId :" + patientId + " firstName : " + firstName + " lastName : " + lastName
				+ " DiseaseId : " + diseaseIds + " Exposures : ]" + exposures;

		assertEquals(expected, patient.toString());

	}

	/**
	 * Test add exposure with full exposures array.
	 */
	@Test
	public void testAddExposureWithFullExposuresArray() {
		Patient1 patient = new Patient1();
		Exposure1 exposure1 = new Exposure1();
		Exposure1 exposure2 = new Exposure1();
		patient.setExposures(new Exposure1[] { exposure1, exposure2 });

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> patient.addExposure(new Exposure1()));
	}

	/**
	 * Test constructor with firstname and lastname.
	 */
	@Test
	public void testConstructorWithFirstnameAndLastname() {
		String firstName = "John";
		String lastName = "Doe";
		Patient1 patient = new Patient1(firstName, lastName);

		assertEquals(firstName, patient.getFirstName());
		assertEquals(lastName, patient.getLastName());
	}

	/**
	 * Test add disease id successful.
	 */
	@Test
	public void testAddDiseaseIdSuccessful() {
		UUID id1 = UUID.randomUUID();
		UUID id2 = UUID.randomUUID();
		int maxDiseases = 3;
		int maxExposures = 5;
		Patient1 patient = new Patient1(new int[] { maxDiseases }, new int[] { maxExposures });

		patient.addDiseaseId(id1);
		assertEquals(id1, patient.getDiseaseIds()[0]);

		patient.addDiseaseId(id2);
		assertEquals(id2, patient.getDiseaseIds()[1]);
	}

	/**
	 * Test add disease id array full.
	 */
	@Test
	public void testAddDiseaseIdArrayFull() {
		UUID id1 = UUID.randomUUID();
		int maxDiseases = 1;
		int maxExposures = 5;
		Patient1 patient = new Patient1(new int[] { maxDiseases }, new int[] { maxExposures });
		patient.addDiseaseId(id1);

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> patient.addDiseaseId(UUID.randomUUID()));
	}

	/**
	 * Test add exposure array full.
	 */
	@Test
	public void testAddExposureArrayFull() {
		Exposure1 exposure1 = new Exposure1(UUID.randomUUID());
		int maxDiseases = 3;
		int maxExposures = 1;
		Patient1 patient = new Patient1(new int[] { maxDiseases }, new int[] { maxExposures });
		patient.addExposure(exposure1);

		assertThrows(ArrayIndexOutOfBoundsException.class, () -> patient.addExposure(new Exposure1(UUID.randomUUID())));
	}

	/**
	 * Test constructor with exposure.
	 */
	@Test
	public void testConstructorWithExposure() {
		Exposure1 exposure = new Exposure1(UUID.randomUUID());
		Patient1 patient = new Patient1(exposure);

		assertEquals(1, patient.getExposures().length);
	}

	/**
	 * Test constructor with valid max values.
	 */
	@Test
	public void testConstructorWithValidMaxValues() {
		int[] maxDiseases = { 5 };
		int[] maxExposures = { 3 };
		Patient1 patient = new Patient1(maxDiseases, maxExposures);

		assertNotNull(patient.getDiseaseIds());
		assertNotNull(patient.getExposures());
		assertEquals(maxDiseases[0], patient.getDiseaseIds().length);
		assertEquals(maxExposures[0], patient.getExposures().length);
	}

	/**
	 * Test constructor with invalid max values.
	 */
	@Test
	public void testConstructorWithInvalidMaxValues() {
		int[] invalidMaxDiseases = { 0 };
		int[] invalidMaxExposures = { -1 };

		assertThrows(IllegalArgumentException.class, () -> new Patient1(invalidMaxDiseases, invalidMaxExposures));
	}

}