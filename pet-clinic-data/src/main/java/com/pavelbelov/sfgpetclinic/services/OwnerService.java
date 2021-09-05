package com.pavelbelov.sfgpetclinic.services;

import com.pavelbelov.sfgpetclinic.model.Owner;

/**
 *  Created by Pavel Belov on 03.09.2021
 */
public interface OwnerService extends CrudService<Owner, Long> {

    Owner findByLastName(String lastName);

}
