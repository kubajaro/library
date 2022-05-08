package com.crud.library.exception;

public class ObjectNotFoundException extends Exception {

    public ObjectNotFoundException(int id) {
        super("Object with id " + id + " doesn't exist");
    }
}
