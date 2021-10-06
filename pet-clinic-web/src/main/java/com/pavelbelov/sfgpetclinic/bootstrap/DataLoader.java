package com.pavelbelov.sfgpetclinic.bootstrap;

import com.pavelbelov.sfgpetclinic.model.*;
import com.pavelbelov.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;

/**
 * Created by Pavel Belov on 07.09.2021
 */
@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetTypeService petTypeService;
    private final SpecialitiyService specialitiesService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService,
                      VetService vetService,
                      PetTypeService petTypeService,
                      SpecialitiyService specialitiesService,
                      VisitService visitService) {

        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petTypeService = petTypeService;
        this.specialitiesService = specialitiesService;
        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        int count = petTypeService.findAll().size();

        if (count == 0) {
            loadData();
        }

    }

    private void loadData() {
        PetType dog = new PetType();
        dog.setName("Dog");
        PetType savedDogPetType = petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("Cat");
        PetType savedCatPetType = petTypeService.save(cat);

        Speciality generalPractitioner = new Speciality();
        generalPractitioner.setDescription("General Practitioner");
        Speciality savedGP = specialitiesService.save(generalPractitioner);

        Speciality surgeon = new Speciality();
        surgeon.setDescription("Surgeon");
        Speciality savedSurgeon = specialitiesService.save(surgeon);

        Speciality dentist = new Speciality();
        dentist.setDescription("Dentist");
        Speciality savedDentist = specialitiesService.save(dentist);

        Owner owner1 = new Owner();
        owner1.setId(1L);
        owner1.setFirstName("Pavel");
        owner1.setLastName("Belov");
        owner1.setAddress("ul. Pushkina, d. Kolotushkina");
        owner1.setCity("Moscow");
        owner1.setTelephone("+7(999)123-45-67");

        Pet pavelsPet = new Pet();
        pavelsPet.setPetType(savedCatPetType);
        pavelsPet.setOwner(owner1);
        pavelsPet.setBirthDate(LocalDate.of(2011,6,15));
        pavelsPet.setName("Pronya");
        owner1.getPets().add(pavelsPet);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setId(2L);
        owner2.setFirstName("Anton");
        owner2.setLastName("Antonov");
        owner2.setAddress("ul. Kolotushkina, d. Pushkina");
        owner2.setCity("Saint-Petersburg");
        owner2.setTelephone("+7(911)987-65-43");

        Pet antonsPet1 = new Pet();
        Pet antonsPet2 = new Pet();
        antonsPet1.setPetType(savedCatPetType);
        antonsPet1.setOwner(owner2);
        antonsPet1.setBirthDate(LocalDate.of(2012,6,15));
        antonsPet1.setName("Semyon");

        antonsPet2.setPetType(savedCatPetType);
        antonsPet2.setOwner(owner2);
        antonsPet2.setBirthDate(LocalDate.of(2013,6,15));
        antonsPet2.setName("Musya");

        owner2.getPets().add(antonsPet1);
        owner2.getPets().add(antonsPet2);

        ownerService.save(owner2);

        Visit catVisit = new Visit();
        catVisit.setPet(pavelsPet);
        catVisit.setDate(LocalDate.of(2021,10,21));
        catVisit.setDescription("Antibiotics shot");

        visitService.save(catVisit);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setId(1L);
        vet1.setFirstName("Gregory");
        vet1.setLastName("House");
        vet1.getSpecialities().add(savedGP);
        vet1.getSpecialities().add(savedSurgeon);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setId(2L);
        vet2.setFirstName("John");
        vet2.setLastName("Dorian");
        vet2.getSpecialities().add(savedSurgeon);
        vet2.getSpecialities().add(savedDentist);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
