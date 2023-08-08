package com.kisel.boa.parser.ast;

import com.kisel.boa.lib.ArrayValue;
import com.kisel.boa.lib.Value;
import java.util.List;

/**
 *
 * @author Kisel13
 */
public final class ArrayExpression implements Expression {
    
    public final List<Expression> elements;

    public ArrayExpression(List<Expression> arguments) {
        this.elements = arguments;
    }
    
    @Override
    public Value eval() {
        final int size = elements.size();
        final ArrayValue array = new ArrayValue(size);
        for (int i = 0; i < size; i++) {
            array.set(i, elements.get(i).eval());
        }
        return array;
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return elements.toString();
    }
}
