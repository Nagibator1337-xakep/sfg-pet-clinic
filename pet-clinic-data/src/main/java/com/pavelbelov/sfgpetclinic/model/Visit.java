package com.pavelbelov.sfgpetclinic.model;

import java.time.LocalDate;

/**
 * Created by Pavel Belov on 13.09.2021
 */
public class Visit extends BaseEntity {

    private LocalDate date;
    private String description;
    private Pet pet;

    /**
     * Creates a new instance of Visit for the current date
     */
    public Visit() {
        this.date = LocalDate.now();
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Pet getPet() {
        return pet;
    }

    public void setPet(Pet pet) {
        this.pet = pet;
    }
}
