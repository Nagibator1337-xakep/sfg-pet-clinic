package com.pavelbelov.sfgpetclinic.services.springdatajpa;

import com.pavelbelov.sfgpetclinic.model.Speciality;
import com.pavelbelov.sfgpetclinic.repositories.SpecialityRepository;
import com.pavelbelov.sfgpetclinic.services.SpecialitiyService;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Pavel Belov on 06.10.2021
 */
@Service
@Profile("springdatajpa")
public class SpecialtySDJpaService implements SpecialitiyService {

    private final SpecialityRepository specialityRepository;

    public SpecialtySDJpaService(SpecialityRepository specialityRepository) {
        this.specialityRepository = specialityRepository;
    }

    @Override
    public Set<Speciality> findAll() {
        Set<Speciality> specialities = new HashSet<>();
        specialityRepository.findAll().forEach(specialities::add);
        return specialities;
    }

    @Override
    public Speciality findById(Long id) {
        return specialityRepository.findById(id).orElse(null);
    }

    @Override
    public Speciality save(Speciality speciality) {
        return specialityRepository.save(speciality);
    }

    @Override
    public void delete(Speciality speciality) {
        specialityRepository.delete(speciality);
    }

    @Override
    public void deleteById(Long id) {
        specialityRepository.deleteById(id);
    }
}
