package com.pavelbelov.sfgpetclinic.bootstrap;

import com.pavelbelov.sfgpetclinic.model.*;
import com.pavelbelov.sfgpetclinic.services.*;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;


import java.time.LocalDate;
import java.util.HashSet;

/**
 * Created by Pavel Belov on 07.09.2021
 */
@Component
@Transactional
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
        cat.setName("Cat");
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

        Owner owner3 = Owner.builder()
                .firstName("Alexey")
                .lastName("Navalny")
                .address("6, Frank Stolverk st.")
                .city("Pokrov")
                .telephone("+74924364105").build();

        Pet alexsPet = Pet.builder()
                .petType(savedDogPetType)
                .birthDate(LocalDate.of(2021,2,20))
                .name("Putin")
                .owner(owner3).build();

        owner3.getPets().add(alexsPet);

        ownerService.save(owner3);

        Visit catVisit1 = new Visit();
        catVisit1.setPet(pavelsPet);
        catVisit1.setDate(LocalDate.of(2021,10,14));
        catVisit1.setDescription("Antibiotics shot 1");

        visitService.save(catVisit1);

        Visit catVisit2 = new Visit();
        catVisit2.setPet(pavelsPet);
        catVisit2.setDate(LocalDate.of(2021,10,21));
        catVisit2.setDescription("Antibiotics shot 2");

        visitService.save(catVisit2);

        Visit catVisit3 = new Visit();
        catVisit3.setPet(antonsPet1);
        catVisit3.setDate(LocalDate.of(2021,10,21));
        catVisit3.setDescription("Regular checkup");

        visitService.save(catVisit3);

        System.out.println("Loaded owners...");

        Vet vet1 = new Vet();
        vet1.setFirstName("Gregory");
        vet1.setLastName("House");
        vet1.getSpecialities().add(savedGP);
        vet1.getSpecialities().add(savedSurgeon);

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("John");
        vet2.setLastName("Dorian");
        vet2.getSpecialities().add(savedSurgeon);
        vet2.getSpecialities().add(savedDentist);

        vetService.save(vet2);

        System.out.println("Loaded vets...");
    }
}
