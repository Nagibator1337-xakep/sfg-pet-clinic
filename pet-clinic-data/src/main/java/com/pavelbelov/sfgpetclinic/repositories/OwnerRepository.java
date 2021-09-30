package com.pavelbelov.sfgpetclinic.repositories;

import com.pavelbelov.sfgpetclinic.model.Owner;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel Belov on 30.09.2021
 */
public interface OwnerRepository extends CrudRepository<Owner, Long> {

}
