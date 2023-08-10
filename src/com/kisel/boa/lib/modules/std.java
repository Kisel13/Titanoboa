package com.kisel.boa.lib.modules;

import com.kisel.boa.lib.StringValue;
import com.kisel.boa.lib.Function;
import com.kisel.boa.lib.NumberValue;
import com.kisel.boa.lib.ArrayValue;
import com.kisel.boa.lib.Value;
import com.kisel.boa.lib.Functions;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Random;

/**
 *
 * @author Kisel13
 */
public final class std implements Module {

    @Override
    public void init() {
        Functions.set("newarray", new Function() {

            @Override
            public Value execute(Value... args) {
                return createArray(args, 0);
            }
            
            private ArrayValue createArray(Value[] args, int index) {
                final int size = (int) args[index].asNumber();
                final int last = args.length - 1;
                ArrayValue array = new ArrayValue(size);
                if (index == last) {
                    for (int i = 0; i < size; i++) {
                        array.set(i, NumberValue.ZERO);
                    }
                } else if (index < last) {
                    for (int i = 0; i < size; i++) {
                        array.set(i, createArray(args, index + 1));
                    }
                }
                return array;
            }
        });
        Functions.set("rand", new Rand());
        Functions.set("trim", args -> {
            if (args.length != 1) {
                throw new IllegalArgumentException("trim function expects a single string argument");
            }
            String original = args[0].asString();
            String trimmed = original.trim();
            return new StringValue(trimmed);
        });
        Functions.set("echo", args -> {
            final StringBuilder sb = new StringBuilder();
            for (Value arg : args) {
                sb.append(arg.asString());
                sb.append(" ");
            }
            System.out.println(sb.toString());
            return NumberValue.ZERO;    
        });
        Functions.set("input", args -> {
            if (args.length == 1) {
                System.out.print(args[0].asString());
            }
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                String input = reader.readLine();
                return new StringValue(input);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return new StringValue("");
        });
        Functions.set("len", args -> {
            if (args.length == 1 && args[0] instanceof StringValue) {
                StringValue stringValue = (StringValue) args[0];
                return new NumberValue(stringValue.asString().length());
            } else {
                throw new RuntimeException("len function expects a single string argument");
            }
        });
        Functions.set("toString", args -> {
            if (args.length == 1) {
                return new StringValue(args[0].asString());
            } else {
                throw new RuntimeException("toString function expects a single argument");
            }
        });
        Functions.set("toInt", args -> {
            if (args.length == 1) {
                return new NumberValue(args[0].asNumber());
            } else {
                throw new RuntimeException("toInt function expects a single argument");
            }
        });
        Functions.set("wait", args -> {
            System.out.println("Press Enter to continue...");
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            try {
                reader.readLine();
            } catch (IOException ex) {
                ex.printStackTrace();
            }
            return NumberValue.ZERO;
        });
        Functions.set("exit", args -> {
            System.exit(0);
            return NumberValue.ZERO;
        });
        Functions.set("about", args -> {
            System.out.println("Это, Titanoboa - язык програмирования понятный и для машины, и для человека. Это делает язык быстрым, и в то же время понятным. Автор - Kisel13.");
            return NumberValue.ZERO;
        });
        Functions.set("sleep", args -> {
            if (args.length == 1) {
                try {
                    Thread.sleep((long) args[0].asNumber());
                } catch (InterruptedException ex) {
                    Thread.currentThread().interrupt();
                }
            }
            return NumberValue.ZERO;
        });
        Functions.set("thread", args -> {
            if (args.length == 1) {
                // Создаём новый поток по имени функции
                new Thread(() -> {
                    Functions.get(args[0].asString()).execute();
                }).start();
            }
            return NumberValue.ZERO;
        });
    }

    private static class Rand implements Function {
    
        private static final Random RND = new Random();

        @Override
        public Value execute(Value... args) {
            if (args.length == 0) return new NumberValue(RND.nextDouble());
            
            int from = 0;
            int to = 100;
            if (args.length == 1) {
                to = (int) args[0].asNumber();
            } else if (args.length == 2) {
                from = (int) args[0].asNumber();
                to = (int) args[1].asNumber();
            }
            return new NumberValue(RND.nextInt(to - from) + from);
        }
    }
}
