package com.kisel.boa.parser.ast;

/**
 *
 * @author Kisel13
 */
public interface Node {
    
    void accept(Visitor visitor);
}
