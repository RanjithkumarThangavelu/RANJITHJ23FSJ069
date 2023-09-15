package edu.disease.asn1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertThrows;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;
import java.util.Objects;
import java.util.UUID;

import org.junit.Before;
import org.junit.Test;

/**
 * The Class Exposure1Test.
 */
public class Exposure1Test {

	/** The exposure. */
	private Exposure1 exposure;

	/**
	 * Sets the up.
	 */
	@Before
	public void setUp() {
		final UUID uuid = UUID.randomUUID();
		exposure = new Exposure1(uuid, LocalDateTime.now(), "D");
	}

	/**
	 * Test exposure postive scenario.
	 */
	@Test
	public void testExposurePostiveScenario() {
		assertNotNull(exposure.toString());
		assertNotNull(exposure.getDateTime());
		assertNotNull(exposure.getPatientId());
		assertEquals("D", exposure.exposureType());
		assertNotNull(exposure.hashCode());
		final Exposure1 exposureObj = exposure;
		assertTrue(exposure.equals(exposureObj));
		assertTrue(exposure.equals(exposure));
		assertFalse(exposure.equals(null));

	}

	/**
	 * Test exposure negative scenario.
	 */
	@Test
	public void testExposureNegativeScenario() {

		final Exposure1 exposureObjEquals = new Exposure1(exposure.getPatientId(), exposure.getDateTime(), "T");
		assertTrue(exposure.equals(exposureObjEquals));
		assertFalse(exposure.equals(null));
		exposureObjEquals.setDateTime(null);
		assertFalse(exposure.equals(exposureObjEquals));
		exposure.setPatientId(null);
		exposureObjEquals.setDateTime(exposure.getDateTime());
		assertFalse(exposure.equals(exposureObjEquals));
		exposure.setPatientId(null);
		exposureObjEquals.setDateTime(null);
		assertFalse(exposure.equals(exposureObjEquals));

	}

	/**
	 * Test set exposure type valid type D.
	 */
	@Test
	public void testSetExposureTypeValidTypeD() {
		Exposure1 exposure = new Exposure1();
		exposure.setExposureType("D");
		assertEquals("D", exposure.exposureType());
	}

	/**
	 * Test set exposure type valid type T.
	 */
	@Test
	public void testSetExposureTypeValidTypeT() {
		Exposure1 exposure = new Exposure1();
		exposure.setExposureType("T");
		assertEquals("T", exposure.exposureType());
	}

	/**
	 * Test set exposure type invalid type.
	 */
	@Test
	public void testSetExposureTypeInvalidType() {
		Exposure1 exposure = new Exposure1();
		assertThrows(IllegalArgumentException.class, () -> exposure.setExposureType("InvalidType"));
	}

	/**
	 * Test hash code.
	 */
	@Test
	public void testHashCode() {
		LocalDateTime dateTime = LocalDateTime.now();
		UUID patientId = UUID.randomUUID();
		Exposure1 exposure1 = new Exposure1();
		Exposure1 exposure2 = new Exposure1();
		exposure1.setDateTime(dateTime);
		exposure1.setPatientId(patientId);
		exposure2.setDateTime(dateTime);
		exposure2.setPatientId(patientId);
		assertEquals(Objects.hash(dateTime, patientId), exposure1.hashCode());
		assertEquals(exposure1.hashCode(), exposure2.hashCode());
	}
}
