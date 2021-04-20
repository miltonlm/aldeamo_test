package com.aldeamo.bartender.bartender;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


/**
 * Entity for the bartender model.
 * This will be initialized by data.sql on the resources folder using Spring initializing system.
 * */
@Entity
@Table(name = "arrays")
public class Bartender {

    /**
     * The id of the record.
     * */
    @Id
    private Long id;

    /**
     * Input array joined by a ",".
     * */
    @Column(name = "input_array")
    private String inputArray;

    /**
     * Gets the id.
     * @return The id.
     * */
    public Long getId() {
        return id;
    }

    /**
     * Sets the id.
     * @param id The id to set.
     * */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Gets the input array.
     * @return The input array.
     * */
    public String getInputArray() {
        return inputArray;
    }

    /**
     * Sets the input array.
     * @param inputArray The input array to set.
     * */
    public void setInputArray(String inputArray) {
        this.inputArray = inputArray;
    }
}
