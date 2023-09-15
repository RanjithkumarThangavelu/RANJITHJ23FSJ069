package edu.disease.asn2;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import java.util.UUID;

import org.junit.jupiter.api.Test;

/**
 * The Class Disease2Test.
 */
class Disease2Test {

	/**
	 * Test abstract method.
	 */
	@Test
	void testAbstractMethod() {
		Disease2 disease = new Disease2() {
			@Override
			public String[] getExamples() {
				return new String[0];
			}
		};

		assertNotNull(disease.getExamples());
		assertEquals(0, disease.getExamples().length);
	}

	/**
	 * Test disease 2 default constructor.
	 */
	@Test
	public void testDisease2DefaultConstructor() {
		Disease2 disease = new Disease2() {
			@Override
			public String[] getExamples() {
				return null;
			}
		};

		assertNotNull(disease);
	}

	/**
	 * Test disease 2 UUID constructor.
	 */
	@Test
	public void testDisease2UUIDConstructor() {
		UUID diseaseId = UUID.randomUUID();
		Disease2 disease = new Disease2(diseaseId) {
			@Override
			public String[] getExamples() {
				return null;
			}
		};

		assertNotNull(disease);
		assertEquals(diseaseId, disease.getDiseaseId());
	}

	/**
	 * Test disease 2 UUID name constructor.
	 */
	@Test
	public void testDisease2UUIDNameConstructor() {
		UUID diseaseId = UUID.randomUUID();
		String name = "Test Disease";
		Disease2 disease = new Disease2(diseaseId, name) {
			@Override
			public String[] getExamples() {
				return null;
			}
		};

		assertNotNull(disease);
		assertEquals(diseaseId, disease.getDiseaseId());
		assertEquals(name, disease.getName());
	}

	/**
	 * Test constructor with name.
	 */
	@Test
	void testConstructorWithName() {
		String name = "Test Disease";
		Disease2 infectiousDiseaseWithName = new InfectiousDisease(name);

		assertNull(infectiousDiseaseWithName.getDiseaseId());
		assertEquals(name, infectiousDiseaseWithName.getName());
	}

	/**
	 * Test infectious disease examples.
	 */
	@Test
	void testInfectiousDiseaseExamples() {
		Disease2 infectiousDisease = new InfectiousDisease();

		assertNotNull(infectiousDisease.getExamples());
		assertTrue(infectiousDisease.getExamples().length > 0);
	}

	/**
	 * Test non infectious disease examples.
	 */
	@Test
	void testNonInfectiousDiseaseExamples() {
		Disease2 nonInfectiousDisease = new NonInfectiousDisease();

		assertNotNull(nonInfectiousDisease.getExamples());
		assertTrue(nonInfectiousDisease.getExamples().length > 0);
	}

	/**
	 * Test infectious disease constructor.
	 */
	@Test
	void testInfectiousDiseaseConstructor() {
		UUID diseaseId = UUID.randomUUID();
		String name = "COVID-19";
		Disease2 disease = new InfectiousDisease(diseaseId, name);
		assertNotNull(disease);
		assertEquals(diseaseId, disease.getDiseaseId());
		assertEquals(name, disease.getName());
	}

	/**
	 * Test disease 2 name constructor.
	 */
	@Test
	public void testDisease2NameConstructor() {
		String name = "Test Disease";
		Disease2 disease = new Disease2(name) {
			@Override
			public String[] getExamples() {
				return null;
			}
		};

		assertNotNull(disease);
		assertNull(disease.getDiseaseId());
		assertEquals(name, disease.getName());
	}

	/**
	 * Test set disease id.
	 */
	@Test
	public void testSetDiseaseId() {
		Disease2 disease = new Disease2() {
			@Override
			public String[] getExamples() {
				return null;
			}
		};

		UUID diseaseId = UUID.randomUUID();
		disease.setDiseaseId(diseaseId);

		assertEquals(diseaseId, disease.getDiseaseId());
	}

	/**
	 * Test set name.
	 */
	@Test
	public void testSetName() {
		Disease2 disease = new Disease2() {
			@Override
			public String[] getExamples() {
				return null;
			}
		};

		String name = "Test Disease";
		disease.setName(name);

		assertEquals(name, disease.getName());
	}

	/**
	 * Test hash code with different name.
	 */
	@Test
	void testHashCodeWithDifferentName() {
		Disease2 disease1 = new InfectiousDisease(UUID.randomUUID(), "COVID-19");
		Disease2 disease2 = new InfectiousDisease(UUID.randomUUID(), "Influenza");

		assertNotEquals(disease1.hashCode(), disease2.hashCode());
	}

	/**
	 * Test equals with equal objects.
	 */
	@Test
	void testEqualsWithEqualObjects() {
		UUID diseaseId = UUID.randomUUID();
		Disease2 disease1 = new InfectiousDisease(diseaseId, "COVID-19");
		Disease2 disease2 = new InfectiousDisease(diseaseId, "COVID-19");

		assertTrue(disease1.equals(disease2));
		assertTrue(disease2.equals(disease1));
	}

	/**
	 * Test equals with different objects.
	 */
	@Test
	void testEqualsWithDifferentObjects() {
		Disease2 disease1 = new InfectiousDisease(UUID.randomUUID(), "COVID-19");
		Disease2 disease2 = new InfectiousDisease(UUID.randomUUID(), "Influenza");

		assertFalse(disease1.equals(disease2));
		assertFalse(disease2.equals(disease1));
	}

	/**
	 * Test equals with null object.
	 */
	@Test
	void testEqualsWithNullObject() {
		Disease2 disease = new InfectiousDisease(UUID.randomUUID(), "COVID-19");
		assertFalse(disease.equals(null));
	}

	/**
	 * Test equals with same object.
	 */
	@Test
	void testEqualsWithSameObject() {
		Disease2 disease = new InfectiousDisease(UUID.randomUUID(), "COVID-19");
		assertTrue(disease.equals(disease));
	}

	/**
	 * Test non infectious disease constructor.
	 */
	@Test
	void testNonInfectiousDiseaseConstructor() {
		String testName = "Diabetes";
		Disease2 disease = new NonInfectiousDisease(testName);

		assertEquals(testName, disease.getName());
	}

	/**
	 * Test to string.
	 */
	@Test
	void testToString() {
		String testName = "COVID-19";
		UUID testId = UUID.randomUUID();
		Disease2 disease = new InfectiousDisease(testId, testName);

		String expectedString = "[ DiseaseId : " + testId + " Name : ]" + testName;
		assertEquals(expectedString, disease.toString());
	}

	/**
	 * Test non infectious disease constructor with id.
	 */
	@Test
	void testNonInfectiousDiseaseConstructorWithId() {
		UUID testId = UUID.randomUUID();
		Disease2 disease = new NonInfectiousDisease(testId);

		assertEquals(testId, disease.getDiseaseId());
		assertNull(disease.getName());
	}

	/**
	 * Test non infectious disease constructor with name and id.
	 */
	@Test
	void testNonInfectiousDiseaseConstructorWithNameAndId() {
		UUID testId = UUID.randomUUID();
		String testName = "Diabetes";
		Disease2 disease = new NonInfectiousDisease(testId, testName);

		assertEquals(testId, disease.getDiseaseId());
		assertEquals(testName, disease.getName());
	}

	/**
	 * Test infectious disease constructor with id.
	 */
	@Test
	void testInfectiousDiseaseConstructorWithId() {
		UUID testId = UUID.randomUUID();
		Disease2 disease = new InfectiousDisease(testId);

		assertEquals(testId, disease.getDiseaseId());
		assertNull(disease.getName());
	}

	/**
	 * Test hash code with null name.
	 */
	@Test
	void testHashCodeWithNullName() {
		UUID testId = UUID.randomUUID();
		Disease2 disease = new InfectiousDisease(testId);

		int expectedHashCode = testId.hashCode();
		int actualHashCode = disease.hashCode();

		assertEquals(expectedHashCode, actualHashCode);
	}

	/**
	 * Test equals with different class.
	 */
	@Test
	void testEqualsWithDifferentClass() {
		Disease2 disease = new InfectiousDisease(UUID.randomUUID());

		boolean result = disease.equals(new Object());

		assertFalse(result);
	}

	/**
	 * Test equals with different disease id.
	 */
	@Test
	void testEqualsWithDifferentDiseaseId() {
		UUID diseaseId1 = UUID.randomUUID();
		UUID diseaseId2 = UUID.randomUUID();

		Disease2 disease1 = new InfectiousDisease(diseaseId1);
		Disease2 disease2 = new InfectiousDisease(diseaseId2);

		boolean result = disease1.equals(disease2);

		assertFalse(result);
	}

	/**
	 * Test equals with same disease id.
	 */
	@Test
	void testEqualsWithSameDiseaseId() {
		UUID diseaseId = UUID.randomUUID();

		Disease2 disease1 = new InfectiousDisease(diseaseId);
		Disease2 disease2 = new InfectiousDisease(diseaseId);

		boolean result = disease1.equals(disease2);

		assertTrue(result);
	}

}