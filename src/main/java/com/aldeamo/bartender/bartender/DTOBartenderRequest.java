package com.aldeamo.bartender.bartender;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


/**
 * DTO used to receive the values from the client.
 * */
public class DTOBartenderRequest {

    @NotNull(message = "recordId value must not be null")
    @Min(value = 1, message = "recordId value must be between 1 and 5")
    @Max(value = 5, message = "recordId value must be between 1 and 5")
    long recordId;
    @NotNull(message = "iterations must not be null")
    int iterations;

    /**
     * Gets the record id.
     * @return Record id.
     * */
    public long getRecordId() {
        return recordId;
    }

    /**
     * Sets the record id.
     * @param recordId The record id to set.
     * */
    public void setRecordId(long recordId) {
        this.recordId = recordId;
    }

    /**
     * Gets the iterations.
     * @return The iterations.
     * */
    public int getIterations() {
        return iterations;
    }

    /**
     * Sets the iterations.
     * @param iterations The iterations to set.
     * */
    public void setIterations(int iterations) {
        this.iterations = iterations;
    }
}
