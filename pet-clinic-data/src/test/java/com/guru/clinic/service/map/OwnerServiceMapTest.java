package com.guru.clinic.service.map;

import com.guru.clinic.model.Owner;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

class OwnerServiceMapTest {

    final long ownerId = 1L;
    final String lastName = "Smith";
    OwnerServiceMap ownerServiceMap;

    @BeforeEach
    void setUp() {
        ownerServiceMap = new OwnerServiceMap(new PetTypeServiceMap(), new PetServiceMap());

        ownerServiceMap.save(Owner.builder()
                                  .id(ownerId)
                                  .lastName(lastName)
                                  .build());
    }

    @Test
    void findAll() {
        final Set<Owner> owners = ownerServiceMap.findAll();

        assertEquals(1, owners.size());
    }

    @Test
    void findById() {
        final Owner owner = ownerServiceMap.findById(ownerId);

        assertEquals(ownerId, owner.getId());
    }

    @Test
    void saveShouldNotReturnNull() {
        final Owner savedOwner = ownerServiceMap.save(Owner.builder()
                                                           .id(2L)
                                                           .build());

        assertNotNull(savedOwner);
    }

    @Test
    void saveWithNoIdShouldNotReturnNull() {
        final Owner owner = ownerServiceMap.save(Owner.builder()
                                                      .build());

        assertNotNull(owner);
    }

    @Test
    void delete() {
        ownerServiceMap.delete(ownerServiceMap.findById(ownerId));

        assertEquals(0, ownerServiceMap.findAll()
                                       .size());
    }

    @Test
    void deleteById() {
        ownerServiceMap.deleteById(ownerId);

        assertEquals(0, ownerServiceMap.findAll()
                                       .size());
    }

    @Test
    void findByLastName() {
        final Owner owner = ownerServiceMap.findByLastName("Smith");

        assertNotNull(owner);
    }
}