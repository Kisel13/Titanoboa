package com.kisel.boa.parser.ast;

import com.kisel.boa.lib.Value;
import com.kisel.boa.lib.Variables;

/**
 *
 * @author Kisel13
 */
public final class AssignmentStatement implements Statement {

    public final String variable;
    public final Expression expression;

    public AssignmentStatement(String variable, Expression expression) {
        this.variable = variable;
        this.expression = expression;
    }
    
    @Override
    public void execute() {
        final Value result = expression.eval();
        Variables.set(variable, result);
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return String.format("%s = %s", variable, expression);
    }
}
