package com.guru.clinic.bootstrap;

import com.guru.clinic.model.Owner;
import com.guru.clinic.model.Pet;
import com.guru.clinic.model.PetType;
import com.guru.clinic.model.Vet;
import com.guru.clinic.model.Visit;
import com.guru.clinic.service.OwnerService;
import com.guru.clinic.service.PetService;
import com.guru.clinic.service.VetService;
import com.guru.clinic.service.VisitService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Component
public class DataLoader implements CommandLineRunner {

    private final OwnerService ownerService;
    private final VetService vetService;
    private final PetService petService;
    private final VisitService visitService;

    public DataLoader(OwnerService ownerService, VetService vetService, PetService petService, VisitService visitService) {
        this.ownerService = ownerService;
        this.vetService = vetService;
        this.petService = petService;

        this.visitService = visitService;
    }

    @Override
    public void run(String... args) throws Exception {

        Pet dog = new Pet();
        dog.setName("dog");

        petService.save(dog);

        Pet cat = new Pet();
        cat.setName("cat");

        petService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Oreo");
        owner1.setAddress("101 Wickham");
        owner1.setCity("Boston");
        owner1.setTelephone("12121212");
       // owner1.getPets().add(dog);

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Twix");
        owner2.setAddress("101 Wickham");
        owner2.setCity("Boston");
        owner2.setTelephone("12121212");
        //owner2.getPets().add(cat);


        ownerService.save(owner2);

        System.out.println("Owners loaded");

        Visit catVisit = new Visit();
        catVisit.setPet(cat);
        catVisit.setDescription("paw problems");
        catVisit.setLocalDate(LocalDate.now());
        visitService.save(catVisit);

        Vet vet1 = new Vet();
        vet1.setFirstName("Rick");
        vet1.setLastName("Rock");

        vetService.save(vet1);

        Vet vet2 = new Vet();
        vet2.setFirstName("Morty");
        vet2.setLastName("Mort");

        vetService.save(vet2);

        System.out.println("Vets loaded");
    }
}
