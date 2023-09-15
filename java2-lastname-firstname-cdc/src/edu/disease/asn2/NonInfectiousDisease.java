package edu.disease.asn2;

import java.util.UUID;

public class NonInfectiousDisease extends Disease2 {

	/**
	 * Instantiates a new non infectious disease.
	 */
	public NonInfectiousDisease() {

	}

	/**
	 * Instantiates a new non infectious disease.
	 *
	 * @param name the name
	 */
	public NonInfectiousDisease(String name) {
		this.name = name;
	}

	/**
	 * Instantiates a new non infectious disease.
	 *
	 * @param a the a
	 */
	public NonInfectiousDisease(UUID a) {
		this.diseaseId = a;
	}

	/**
	 * Instantiates a new non infectious disease.
	 *
	 * @param a the a
	 * @param n the n
	 */
	public NonInfectiousDisease(UUID a, String n) {
		this.name = n;
		this.diseaseId = a;
	}

	/**
	 * Gets the examples.
	 *
	 * @return the examples
	 */
	@Override
	public String[] getExamples() {
		return new String[] { "Diabetes", "Heart disease", "Cancer", "Alzheimer's disease" };
	}
}
