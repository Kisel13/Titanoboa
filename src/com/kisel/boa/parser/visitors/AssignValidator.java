package com.kisel.boa.parser.visitors;

import com.kisel.boa.parser.ast.AssignmentStatement;
import com.kisel.boa.lib.Variables;

/**
 *
 * @author Kisel13
 */
public final class AssignValidator extends AbstractVisitor {

    @Override
    public void visit(AssignmentStatement s) {
        super.visit(s);
        if (Variables.isExists(s.variable)) {
            throw new RuntimeException("Cannot assign value to constant");
        }
    }
}
