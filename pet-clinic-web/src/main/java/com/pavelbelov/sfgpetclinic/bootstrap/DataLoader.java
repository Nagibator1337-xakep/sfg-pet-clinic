package com.pavelbelov.sfgpetclinic.bootstrap;

import com.pavelbelov.sfgpetclinic.model.Owner;
import com.pavelbelov.sfgpetclinic.model.Vet;
import com.pavelbelov.sfgpetclinic.services.OwnerService;
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

    public DataLoader(OwnerService ownerService, VetService vetService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
    }

    @Override
    public void run(String... args) throws Exception {

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
