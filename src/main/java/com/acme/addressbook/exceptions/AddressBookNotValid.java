package com.acme.addressbook.exceptions;

public class AddressBookNotValid extends RuntimeException {

    public AddressBookNotValid(String msg) {
        super(msg);
    }

    public AddressBookNotValid(String msg, Throwable cause) {
        super(msg, cause);
    }

}
