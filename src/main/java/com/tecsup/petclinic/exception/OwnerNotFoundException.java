package com.tecsup.petclinic.exception;

/**
 * Excepción lanzada cuando un propietario no se encuentra.
 *
 * @author jgomezm
 *
 */
public class OwnerNotFoundException extends RuntimeException {

    private static final long serialVersionUID = 1L;

    public OwnerNotFoundException(String message) {
        super(message);
    }
}
