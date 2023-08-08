package com.kisel.boa.parser;

/**
 *
 * @author Kisel13
 */
public final class ParseException extends RuntimeException {
    
    public ParseException() {
        super();
    }
    
    public ParseException(String string) {
        super(string);
    }
}