package com.pavelbelov.sfgpetclinic.repositories;

import com.pavelbelov.sfgpetclinic.model.PetType;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by Pavel Belov on 30.09.2021
 */
public interface PetTypeRepository extends CrudRepository<PetType, Long> {
}
