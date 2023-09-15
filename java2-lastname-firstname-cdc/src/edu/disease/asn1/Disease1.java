package edu.disease.asn1;

import java.util.Objects;
import java.util.UUID;

/**
 * A class representing a disease.
 */
public class Disease1 {

    /** The disease id. */
    private UUID diseaseId;
    
    /** The name. */
    private String name;

    /**
     * Get the disease ID.
     *
     * @return The disease ID.
     */
    public UUID getDiseaseId() {
        return diseaseId;
    }

    /**
     * Set the disease ID.
     *
     * @param diseaseId The disease ID to set.
     */
    public void setDiseaseId(UUID diseaseId) {
        this.diseaseId = diseaseId;
    }

    /**
     * Get the name of the disease.
     *
     * @return The name of the disease.
     */
    public String getName() {
        return name;
    }

    /**
     * Set the name of the disease.
     *
     * @param name The name of the disease to set.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Hash code.
     *
     * @return the int
     */
    @Override
    public int hashCode() {
        return Objects.hash(diseaseId);
    }

    /**
     * Equals.
     *
     * @param obj the obj
     * @return true, if successful
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Disease1 other = (Disease1) obj;
        return Objects.equals(diseaseId, other.diseaseId);
    }
}





