package com.pavelbelov.sfgpetclinic.services;

import com.pavelbelov.sfgpetclinic.model.Owner;

import java.util.List;

/**
 *  Created by Pavel Belov on 03.09.2021
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

    List<Owner> findAllByLastName(String lastName);

}
