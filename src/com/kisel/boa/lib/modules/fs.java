package com.kisel.boa.lib.modules;

import com.kisel.boa.lib.StringValue;
import com.kisel.boa.lib.NumberValue;
import com.kisel.boa.lib.Functions;
import java.io.*;

public final class fs implements Module {

    @Override
    public void init() {
        Functions.set("readFile", args -> {
            if (args.length != 1) throw new IllegalArgumentException("Ожидается один аргумент");
            String filename = args[0].asString();
            return new StringValue(readFile(filename));
        });

        Functions.set("writeFile", args -> {
            if (args.length != 2) throw new IllegalArgumentException("Ожидается два аргумента");
            String filename = args[0].asString();
            String content = args[1].asString();
            writeFile(filename, content);
            return NumberValue.ONE;
        });

        Functions.set("deleteFile", args -> {
            if (args.length != 1) throw new IllegalArgumentException("Ожидается один аргумент");
            String filename = args[0].asString();
            deleteFile(filename);
            return NumberValue.ONE;
        });

        Functions.set("renameFile", args -> {
            if (args.length != 2) throw new IllegalArgumentException("Ожидается два аргумента");
            String oldName = args[0].asString();
            String newName = args[1].asString();
            renameFile(oldName, newName);
            return NumberValue.ONE;
        });

        Functions.set("moveFile", args -> {
            if (args.length != 2) throw new IllegalArgumentException("Ожидается два аргумента");
            String source = args[0].asString();
            String destination = args[1].asString();
            moveFile(source, destination);
            return NumberValue.ONE;
        });

        Functions.set("copyFile", args -> {
            if (args.length != 2) throw new IllegalArgumentException("Ожидается два аргумента");
            String source = args[0].asString();
            String destination = args[1].asString();
            copyFile(source, destination);
            return NumberValue.ONE;
        });

        Functions.set("createDirectory", args -> {
            if (args.length != 1) throw new IllegalArgumentException("Ожидается один аргумент");
            String dirname = args[0].asString();
            createDirectory(dirname);
            return NumberValue.ONE;
        });

        Functions.set("deleteDirectory", args -> {
            if (args.length != 1) throw new IllegalArgumentException("Ожидается один аргумент");
            String dirname = args[0].asString();
            deleteDirectory(dirname);
            return NumberValue.ONE;
        });
    }

    private String readFile(String filename) {
        StringBuilder content = new StringBuilder();
        try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
            String line;
            while ((line = reader.readLine()) != null) {
                content.append(line).append("\n");
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return content.toString();
    }

    private void writeFile(String filename, String content) {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
            writer.write(content);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void deleteFile(String filename) {
        File file = new File(filename);
        if (file.exists()) {
            file.delete();
        }
    }

    private void renameFile(String oldName, String newName) {
        File oldFile = new File(oldName);
        File newFile = new File(newName);
        if (oldFile.exists()) {
            oldFile.renameTo(newFile);
        }
    }

    private void moveFile(String source, String destination) {
        File sourceFile = new File(source);
        File destFile = new File(destination);
        if (sourceFile.exists()) {
            sourceFile.renameTo(destFile);
        }
    }

    private void copyFile(String source, String destination) {
        try (InputStream inStream = new FileInputStream(source);
             OutputStream outStream = new FileOutputStream(destination)) {

            byte[] buffer = new byte[1024];
            int length;
            while ((length = inStream.read(buffer)) > 0) {
                outStream.write(buffer, 0, length);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    private void createDirectory(String dirname) {
        File directory = new File(dirname);
        if (!directory.exists()) {
            directory.mkdir();
        }
    }

    private void deleteDirectory(String dirname) {
        File directory = new File(dirname);
        if (directory.exists()) {
            deleteRecursive(directory);
        }
    }

    private void deleteRecursive(File file) {
        if (file.isDirectory()) {
            for (File subfile : file.listFiles()) {
                deleteRecursive(subfile);
            }
        }
        file.delete();
    }
}
