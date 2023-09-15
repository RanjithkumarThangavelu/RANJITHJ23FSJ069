package edu.disease.asn1;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * The Class Disease1Test.
 */
class Disease1Test {

	/**
	 * Test get disease id.
	 */
	@Test
	public void testGetDiseaseId() {
		Disease1 disease = new Disease1();
		UUID uuid = UUID.randomUUID();
		disease.setDiseaseId(uuid);
		assertEquals(uuid, disease.getDiseaseId());
	}

	/**
	 * Test get name.
	 */
	@Test
	public void testGetName() {
		Disease1 disease = new Disease1();
		String name = "COVID-19";
		disease.setName(name);
		assertEquals(name, disease.getName());
	}

	/**
	 * Test hash code.
	 */
	@Test
	public void testHashCode() {
		Disease1 disease1 = new Disease1();
		Disease1 disease2 = new Disease1();
		UUID uuid = UUID.randomUUID();
		disease1.setDiseaseId(uuid);
		disease2.setDiseaseId(uuid);
		assertEquals(disease1.hashCode(), disease2.hashCode());
	}

	/**
	 * Test equals same object.
	 */
	@Test
	public void testEqualsSameObject() {
		Disease1 disease = new Disease1();
		assertTrue(disease.equals(disease));
	}

	/**
	 * Test equals null object.
	 */
	@Test
	public void testEqualsNullObject() {
		Disease1 disease = new Disease1();
		assertFalse(disease.equals(null));
	}

	/**
	 * Test equals different class.
	 */
	@Test
	public void testEqualsDifferentClass() {
		Disease1 disease = new Disease1();
		assertFalse(disease.equals(new Object()));
	}

	/**
	 * Test equals same id.
	 */
	@Test
	public void testEqualsSameId() {
		Disease1 disease1 = new Disease1();
		Disease1 disease2 = new Disease1();
		UUID uuid = UUID.randomUUID();
		disease1.setDiseaseId(uuid);
		disease2.setDiseaseId(uuid);
		assertTrue(disease1.equals(disease2));
	}

	/**
	 * Test equals different id.
	 */
	@Test
	public void testEqualsDifferentId() {
		Disease1 disease1 = new Disease1();
		Disease1 disease2 = new Disease1();
		UUID uuid1 = UUID.randomUUID();
		UUID uuid2 = UUID.randomUUID();
		disease1.setDiseaseId(uuid1);
		disease2.setDiseaseId(uuid2);
		assertFalse(disease1.equals(disease2));
	}
}
