package com.pavelbelov.sfgpetclinic.model;

import java.util.Set;

/**
 *  Created by Pavel Belov on 03.09.2021
 */

public class Vet extends Person {

    private Set<Specialty> specialties;

    public Set<Specialty> getSpecialties() {
        return specialties;
    }

    public void setSpecialties(Set<Specialty> specialties) {
        this.specialties = specialties;
    }
}
