package edu.disease.asn2;

import java.util.UUID;

public class InfectiousDisease extends Disease2 {

	/**
	 * Instantiates a new infectious disease.
	 */
	public InfectiousDisease() {

	}

	/**
	 * Instantiates a new infectious disease.
	 *
	 * @param name the name
	 */
	public InfectiousDisease(String name) {
		this.name = name;
	}

	/**
	 * Instantiates a new infectious disease.
	 *
	 * @param a the a
	 */
	public InfectiousDisease(UUID a) {
		this.diseaseId = a;
	}

	/**
	 * Instantiates a new infectious disease.
	 *
	 * @param a the a
	 * @param n the n
	 */
	public InfectiousDisease(UUID a, String n) {
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
		return new String[] { "Chickenpox","HIV/AIDS","Influenza", "Common cold" };
	}
}

