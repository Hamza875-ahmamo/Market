package org.softsofi.exeception;

public class CustomerNotFoundExeception extends RuntimeException {
    public CustomerNotFoundExeception(String message) {
        super(message);
    }

}
