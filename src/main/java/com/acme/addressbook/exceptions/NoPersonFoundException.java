package com.acme.addressbook.exceptions;

public class NoPersonFoundException extends RuntimeException {

    public NoPersonFoundException(String msg) {
        super(msg);
    }

}
