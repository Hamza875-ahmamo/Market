package org.softsofi.exeception;

public class InvoiceNotFoundExeception extends RuntimeException{
    public InvoiceNotFoundExeception(String message) {
        super(message);
    }
}
