package com.pavelbelov.sfgpetclinic.services;

import java.util.Set;

/**
 * Created by Pavel Belov on 05.09.2021
 */
public interface CrudService<T, ID> {

    Set<T> findAll();

    T findById(ID id);

    T save(T object);

    void delete(T object);

    void deleteById(ID id);

}
