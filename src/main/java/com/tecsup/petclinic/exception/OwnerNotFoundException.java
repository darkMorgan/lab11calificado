package com.tecsup.petclinic.exception;

/**
 * Exception thrown when an owner is not found.
 *
 * @author jgomezm
 *
 */
public class OwnerNotFoundException extends Exception {

    private static final long serialVersionUID = 1L;

    public OwnerNotFoundException(String message) {
        super(message);
        // TODO Auto-generated constructor stub
    }

}
