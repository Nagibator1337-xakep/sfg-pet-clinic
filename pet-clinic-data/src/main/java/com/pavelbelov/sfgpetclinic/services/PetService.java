package com.pavelbelov.sfgpetclinic.services;

import com.pavelbelov.sfgpetclinic.model.Pet;
import java.util.Set;

/**
 *  Created by Pavel Belov on 03.09.2021
 */

public interface PetService {

    Pet findById(Long id);

    Pet save(Pet pet);

    Set<Pet> findAll();

}
