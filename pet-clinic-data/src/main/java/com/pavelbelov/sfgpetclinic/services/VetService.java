package com.pavelbelov.sfgpetclinic.services;

import com.pavelbelov.sfgpetclinic.model.Vet;
import java.util.Set;

/**
 *  Created by Pavel Belov on 03.09.2021
 */

public interface VetService {

    Vet findById(Long id);

    Vet save(Vet vet);

    Set<Vet> findAll();

}
