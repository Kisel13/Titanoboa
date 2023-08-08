package com.kisel.boa.parser.visitors;

import com.kisel.boa.parser.ast.FunctionDefineStatement;

/**
 *
 * @author Kisel13
 */
public final class FunctionAdder extends AbstractVisitor {

    @Override
    public void visit(FunctionDefineStatement s) {
        super.visit(s);
        s.execute();
    }
}
