package com.pavelbelov.sfgpetclinic.bootstrap;

import com.pavelbelov.sfgpetclinic.model.Owner;
import com.pavelbelov.sfgpetclinic.model.PetType;
import com.pavelbelov.sfgpetclinic.model.Vet;
import com.pavelbelov.sfgpetclinic.services.OwnerService;
import com.pavelbelov.sfgpetclinic.services.PetTypeService;
import com.pavelbelov.sfgpetclinic.services.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

/**
 * Created by Pavel Belov on 07.09.2021
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetTypeService petTypeService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
    }

    @Override
    public void run(String... args) throws Exception {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Pavel");
        owner1.setLastName("Belov");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Anton");
        owner2.setLastName("Guskov");

        ownerService.save(owner2);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Gregory");
        vet1.setLastName("House");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("John");
        vet2.setLastName("Dorian");

        vetService.save(vet2);

        System.out.println("Loaded vets...");

    }
}
