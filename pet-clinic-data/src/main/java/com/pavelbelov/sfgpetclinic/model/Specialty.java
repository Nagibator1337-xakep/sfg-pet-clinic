package com.pavelbelov.sfgpetclinic.model;

/**
 * Created by Pavel Belov on 13.09.2021
 */
public class Specialty extends BaseEntity {

    private String description;

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
