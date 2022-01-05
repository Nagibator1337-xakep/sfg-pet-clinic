package com.pavelbelov.sfgpetclinic.services.springdatajpa;

import com.pavelbelov.sfgpetclinic.model.Owner;
import com.pavelbelov.sfgpetclinic.repositories.OwnerRepository;
import com.pavelbelov.sfgpetclinic.repositories.PetRepository;
import com.pavelbelov.sfgpetclinic.repositories.PetTypeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class OwnerSDJpaServiceTest {

    public static final String LAST_NAME = "Belov";

    @Mock
    OwnerRepository ownerRepository;

    @Mock
    PetRepository petRepository;

    @Mock
    PetTypeRepository petTypeRepository;

    @InjectMocks
    OwnerSDJpaService service;

    Owner returnOwner;


    @BeforeEach
    void setUp() {
        returnOwner = Owner.builder().id(1L).lastName(LAST_NAME).build();
    }

    @Test
    void findAll() {
        Set<Owner> returnOwnerSet = new HashSet<>();
        returnOwnerSet.add(Owner.builder().id(1L).build());
        returnOwnerSet.add(Owner.builder().id(2L).build());

        when(ownerRepository.findAll()).thenReturn(returnOwnerSet);

        Set<Owner> owners = service.findAll();

        assertNotNull(owners);
        assertEquals(2,owners.size());

        verify(ownerRepository).findAll();
    }

    @Test
    void findById() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.of(returnOwner));

        Owner owner = service.findById(1L);

        assertNotNull(owner);
    }

    @Test
    void findByIdNotFound() {
        when(ownerRepository.findById(anyLong())).thenReturn(Optional.empty());

        Owner owner = service.findById(1L);

        assertNull(owner);
    }

    @Test
    void save() {
        Owner ownerToSave = Owner.builder().id(1L).build();

        when(ownerRepository.save(any())).thenReturn(returnOwner);

        Owner savedOwner = service.save(ownerToSave);

        assertNotNull(savedOwner);
        assertEquals(LAST_NAME,savedOwner.getLastName());
        assertEquals(1,savedOwner.getId());

        verify(ownerRepository).save(any());
    }

    @Test
    void delete() {
        service.delete(returnOwner);

        // default times is 1
        verify(ownerRepository,times(1)).delete(any());
    }

    @Test
    void deleteById() {
        service.deleteById(1L);

        verify(ownerRepository).deleteById(anyLong());
    }

    @Test
    void findByLastName() {
        when(ownerRepository.findByLastName(any())).thenReturn(returnOwner);
        Owner belov = service.findByLastName(LAST_NAME);
        assertEquals(LAST_NAME,belov.getLastName());
        verify(ownerRepository).findByLastName(any());
    }

    @Test
    void findAllByLastName() {
        List<Owner> returnOwnerList = new ArrayList<>();
        returnOwnerList.add(Owner.builder().id(1L).lastName(LAST_NAME).build());
        returnOwnerList.add(Owner.builder().id(2L).lastName(LAST_NAME).build());

        when(ownerRepository.findAllByLastName(LAST_NAME)).thenReturn(returnOwnerList);

        List<Owner> owners = service.findAllByLastName(LAST_NAME);

        assertNotNull(owners);
        assertEquals(2,owners.size());
        assertEquals(1L,owners.get(0).getId());
        assertEquals(2L,owners.get(1).getId());

        verify(ownerRepository).findAllByLastName(any());
    }
}