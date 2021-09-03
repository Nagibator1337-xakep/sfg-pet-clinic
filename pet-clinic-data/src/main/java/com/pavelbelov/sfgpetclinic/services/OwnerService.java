package com.pavelbelov.sfgpetclinic.services;

import com.pavelbelov.sfgpetclinic.model.Owner;
import java.util.Set;

/**
 *  Created by Pavel Belov on 03.09.2021
 */

public interface OwnerService {

    Owner findByLastName(String lastName);

    Owner findById(Long id);

    Owner save(Owner owner);

    Set<Owner> findAll();

}
