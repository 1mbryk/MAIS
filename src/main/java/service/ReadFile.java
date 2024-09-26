package service;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

import entity.Array;

public class ReadFile {
    File file;
    public ReadFile(String filePath) {
        file = new File(filePath);
    }

    public Array read()
    {
        Array array = new Array();
        try{
            Scanner scanner = new Scanner(file);
            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                try {
                    Integer parse = Integer.valueOf(line);
                    array.append(parse);
                }
                catch (NumberFormatException e) {
                    System.out.println(e.getMessage());
                }
            }

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }
}
