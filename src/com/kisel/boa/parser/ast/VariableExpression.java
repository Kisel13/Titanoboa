package com.kisel.boa.parser.ast;

import com.kisel.boa.lib.Value;
import com.kisel.boa.lib.Variables;

/**
 *
 * @author Kisel13
 */
public final class VariableExpression implements Expression {
    
    public final String name;
    
    public VariableExpression(String name) {
        this.name = name;
    }

    @Override
    public Value eval() {
        if (!Variables.isExists(name)) throw new RuntimeException("Variable does not exists: " + name);
        return Variables.get(name);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return name;
    }
}
