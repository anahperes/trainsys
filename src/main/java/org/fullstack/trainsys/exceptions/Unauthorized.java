package org.fullstack.trainsys.exceptions;

public class Unauthorized extends RuntimeException{
    public Unauthorized(String message) {
        super(message);
    }
}
