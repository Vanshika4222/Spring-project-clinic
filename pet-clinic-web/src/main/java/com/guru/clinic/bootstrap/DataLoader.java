package com.guru.clinic.bootstrap;

import com.guru.clinic.model.Owner;
import com.guru.clinic.model.PetType;
import com.guru.clinic.model.Vet;
import com.guru.clinic.service.OwnerService;
import com.guru.clinic.service.PetTypeService;
import com.guru.clinic.service.VetService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

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
        dog.setName("dog");

        petTypeService.save(dog);

        PetType cat = new PetType();
        dog.setName("cat");

        petTypeService.save(cat);

        Owner owner1 = new Owner();
        owner1.setFirstName("Alex");
        owner1.setLastName("Oreo");
        owner1.setAddress("101 Wickham");
        owner1.setCity("Boston");
        owner1.setTelephone("12121212");

        ownerService.save(owner1);

        Owner owner2 = new Owner();
        owner2.setFirstName("Bob");
        owner2.setLastName("Twix");
        owner2.setAddress("101 Wickham");
        owner2.setCity("Boston");
        owner2.setTelephone("12121212");


        ownerService.save(owner2);

        System.out.println("Owners loaded");

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
