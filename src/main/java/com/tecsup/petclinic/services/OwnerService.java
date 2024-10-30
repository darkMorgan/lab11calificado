package com.tecsup.petclinic.services;

import java.util.List;
import com.tecsup.petclinic.entities.Owner;

public interface OwnerService {

    /**
     *
     * @param owner
     * @return
     */
    Owner create(Owner owner);

    /**
     *
     * @param owner
     * @return
     */
    Owner update(Owner owner);

    /**
     *
     * @param id
     */
    void delete(Integer id);

    /**
     *
     * @param id
     * @return
     */
    Owner findById(Integer id);

    /**
     *
     * @param lastName
     * @return
     */
    List<Owner> findByLastName(String lastName);

    /**
     *
     * @return
     */
    List<Owner> findAll();
}
