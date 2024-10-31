package com.tecsup.petclinic.services;

import java.util.List;

import com.tecsup.petclinic.entities.Owner;
import com.tecsup.petclinic.exception.OwnerNotFoundException;

/**
 *
 * @author jgomezm
 *
 */
public interface OwnerService {

    /**
     * Crea un nuevo propietario.
     *
     * @param owner
     * @return el propietario creado
     */
    Owner create(Owner owner);

    /**
     * Actualiza un propietario existente.
     *
     * @param owner
     * @return el propietario actualizado
     */
    Owner update(Owner owner);

    /**
     * Elimina un propietario por ID.
     *
     * @param id
     * @throws OwnerNotFoundException si el propietario no se encuentra
     */
    void delete(Integer id) throws OwnerNotFoundException;

    /**
     * Encuentra un propietario por ID.
     *
     * @param id
     * @return el propietario encontrado
     * @throws OwnerNotFoundException si el propietario no se encuentra
     */
    Owner findById(Integer id) throws OwnerNotFoundException; // Cambiado de Long a Integer

    /**
     * Encuentra propietarios por su primer nombre.
     *
     * @param firstName
     * @return lista de propietarios que coinciden con el primer nombre
     */
    List<Owner> findByFirstName(String firstName);

    /**
     * Encuentra propietarios por su apellido.
     *
     * @param lastName
     * @return lista de propietarios que coinciden con el apellido
     */
    List<Owner> findByLastName(String lastName);

    /**
     * Encuentra todos los propietarios.
     *
     * @return lista de todos los propietarios
     */
    List<Owner> findAll();
}
