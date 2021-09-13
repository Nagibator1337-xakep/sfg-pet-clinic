package com.pavelbelov.sfgpetclinic.model;

/**
 *  Created by Pavel Belov on 03.09.2021
 */

public class PetType extends BaseEntity {

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
