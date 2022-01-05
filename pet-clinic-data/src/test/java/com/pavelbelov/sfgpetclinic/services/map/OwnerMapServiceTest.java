package com.pavelbelov.sfgpetclinic.services.map;

import com.pavelbelov.sfgpetclinic.model.Owner;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.junit.jupiter.api.Assertions.*;

class OwnerMapServiceTest {

    OwnerMapService ownerMapService;
    Long ownerId = 1L;
    String ownerLastName = "Pinkman";

    @BeforeEach
    void setUp() {

        ownerMapService = new OwnerMapService(new PetTypeMapService(), new PetMapService());
        ownerMapService.save(Owner.builder()
                .id(ownerId)
                .lastName(ownerLastName)
                .build());
    }

    @Test
    void findAll() {
        Set<Owner> owners = ownerMapService.findAll();
        assertEquals(1,owners.size());
    }

    @Test
    void deleteById() {

        ownerMapService.deleteById(ownerId);
        assertNull(ownerMapService.findById(ownerId));
    }

    @Test
    void delete() {
        ownerMapService.delete(ownerMapService.findById(ownerId));
        assertNull(ownerMapService.findById(ownerId));

    }

    @Test
    void findById() {

        Owner testOwner = ownerMapService.findById(ownerId);
        assertEquals(ownerId,testOwner.getId());

    }

    @Test
    void saveExistingId() {
        Long id = 2L;
        Owner testOwner = Owner.builder().id(id).lastName("Doe").build();
        Owner savedOwner = ownerMapService.save(testOwner);
        assertEquals(id,savedOwner.getId());
    }

    @Test
    void saveNoId() {
        Owner testOwner = Owner.builder().lastName("Long").build();
        Owner savedOwner = ownerMapService.save(testOwner);
        assertNotNull(savedOwner.getId());
    }

    @Test
    void findByLastName() {
        Owner testOwner1 = Owner.builder().id(3L).lastName("White").build();
        Owner testOwner2 = Owner.builder().id(4L).lastName("Smith").build();
        ownerMapService.save(testOwner1);
        ownerMapService.save(testOwner2);
        assertEquals("White",ownerMapService.findByLastName("White").getLastName());
    }

    @Test
    void findByLastNameNull() {
        Owner testOwner = ownerMapService.findByLastName("Foo");
        assertNull(testOwner);
    }

    @Test
    void findAllByLastName() {
        ownerMapService.save(Owner.builder().id(2L).lastName("Foo").build());
        ownerMapService.save(Owner.builder().id(3L).lastName("Bar").build());
        ownerMapService.save(Owner.builder().id(4L).lastName(ownerLastName).build());

        List<Owner> owners = ownerMapService.findAllByLastName(ownerLastName);
        assertEquals(2,owners.size());
        assertEquals(1L,owners.get(0).getId());
        assertEquals(4L,owners.get(1).getId());
    }

    @Test
    void findAllByLastNameEmpty() {
        List<Owner> owners = ownerMapService.findAllByLastName("No Such Last Name");
        assertEquals(0,owners.size());
    }

}