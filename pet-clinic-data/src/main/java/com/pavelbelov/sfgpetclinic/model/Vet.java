package com.pavelbelov.sfgpetclinic.model;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

/**
 *  Created by Pavel Belov on 03.09.2021
 */
@Entity
@Table(name = "vets")
public class Vet extends Person {

    // By default, the FetchType is LAZY which means it is only loading when it's called, EAGER fetch type
    // loads all the data at initialization (as far as I understand)
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "vet_specialities",
            joinColumns = @JoinColumn(name = "vet_id"),
            inverseJoinColumns = @JoinColumn(name = "speciality_id"))
    private Set<Speciality> specialities = new HashSet<>();

    public Set<Speciality> getSpecialities() {
        return specialities;
    }

    public void setSpecialities(Set<Speciality> specialities) {
        this.specialities = specialities;
    }
}
