package com.pavelbelov.sfgpetclinic.services.map;

import com.pavelbelov.sfgpetclinic.model.Vet;
import com.pavelbelov.sfgpetclinic.services.CrudService;
import com.pavelbelov.sfgpetclinic.services.VetService;

import java.util.Set;

/**
 * Created by Pavel Belov on 05.09.2021
 */
public class VetServiceMap extends AbstractMapService<Vet, Long> implements VetService {
    @Override
    public Set<Vet> findAll() {
        return super.findAll();
    }

    @Override
    public void deleteById(Long id) {
        super.deleteById(id);
    }

    @Override
    public void delete(Vet vet) {
        super.delete(vet);
    }

    @Override
    public Vet save(Vet vet) {
        return super.save(vet.getId(), vet);
    }

    @Override
    public Vet findById(Long id) {
        return super.findById(id);
    }
}
