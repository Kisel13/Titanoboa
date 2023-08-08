package com.kisel.boa.parser.ast;

import com.kisel.boa.lib.NumberValue;
import com.kisel.boa.lib.StringValue;
import com.kisel.boa.lib.Value;

/**
 *
 * @author Kisel13
 */
public final class ValueExpression implements Expression {
    
    public final Value value;
    
    public ValueExpression(double value) {
        this.value = new NumberValue(value);
    }
    
    public ValueExpression(String value) {
        this.value = new StringValue(value);
    }

    @Override
    public Value eval() {
        return value;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return value.asString();
    }
}
