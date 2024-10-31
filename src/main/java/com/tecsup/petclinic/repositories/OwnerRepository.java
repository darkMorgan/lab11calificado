package com.tecsup.petclinic.repositories;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.tecsup.petclinic.entities.Owner;

/**
 *
 * @author jgomezm
 *
 */
@Repository
public interface OwnerRepository
        extends JpaRepository<Owner, Integer> {

    // Fetch pets by name
    List<Owner> findByFirstName(String name);

    // Fetch pets by typeId
    List<Owner> findByLastName(String lastName);

    @Override
    List<Owner> findAll();

}


