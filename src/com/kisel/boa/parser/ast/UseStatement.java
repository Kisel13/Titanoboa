package com.kisel.boa.parser.ast;

import com.kisel.boa.lib.modules.Module;

/**
 *
 * @author Kisel13
 */
public final class UseStatement implements Statement {

    private static final String PACKAGE = "com.annimon.ownlang.lib.modules.";
    
    public final Expression expression;
    
    public UseStatement(Expression expression) {
        this.expression = expression;
    }
    
    @Override
    public void execute() {
    try {
        final String moduleName = expression.eval().asString();
        final Module module = (Module) Class.forName(PACKAGE + moduleName).newInstance();
        module.init();
    } catch (Exception ex) {
        // В случае ошибки, например, если модуль не найден, вы можете вывести сообщение
        System.err.println("Error loading module: " + ex.getMessage());
    }

    // Теперь добавляем автоматический импорт модуля std
    try {
        final Module stdModule = (Module) Class.forName(PACKAGE + "std").newInstance();
        stdModule.init();
    } catch (Exception ex) {
        // В случае ошибки, например, если модуль std не найден, вы можете вывести сообщение
        System.err.println("Error loading std module: " + ex.getMessage());
    }
    }
    
    @Override
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String toString() {
        return "use " + expression;
    }
}