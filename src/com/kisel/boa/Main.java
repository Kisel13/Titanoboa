package com.kisel.boa;

import com.kisel.boa.lib.modules.std; // Импортируем модуль std
import com.kisel.boa.parser.Lexer;
import com.kisel.boa.parser.Parser;
import com.kisel.boa.parser.Token;
import com.kisel.boa.parser.ast.Statement;
import com.kisel.boa.parser.visitors.AssignValidator;
import com.kisel.boa.parser.visitors.FunctionAdder;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public final class Main {

    public static void main(String[] args) throws IOException {
        if (args.length < 1) {
            System.exit(1);
        }

        // Инициализируем модуль std
        new std().init();

        final String input = new String(Files.readAllBytes(Paths.get(args[0])), "UTF-8");
        final List<Token> tokens = new Lexer(input).tokenize();
        for (Token token : tokens) {
            //System.out.println(token);
        }

        final Statement program = new Parser(tokens).parse();
        //System.out.println(program.toString());
        program.accept(new FunctionAdder());
        program.accept(new AssignValidator());
        program.execute();
    }
}