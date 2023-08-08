package com.kisel.boa.parser.ast;

/**
 *
 * @author Kisel13
 */
public final class PrintStatement implements Statement {
    
    public final Expression expression;

    public PrintStatement(Expression expression) {
        this.expression = expression;
    }

    @Override
    public void execute() {
        System.out.println(expression.eval());
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "print " + expression;
    }
}
