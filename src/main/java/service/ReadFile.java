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
        Validation val = new Validation();
        try{
            Scanner scanner = new Scanner(file);

            String line;
            while (scanner.hasNextLine()) {
                line = scanner.nextLine();
                if (!val.validateInputDate(line)){
                    continue;
                }
                String[] splitted;
                if (line.contains(", ")){
                    splitted = line.split(", ");
                }
                else if (line.contains(" - ")){
                    splitted = line.split(" - ");
                }
                else{
                    splitted = line.split("");
                }
                for (String str : splitted){
                    array.append(Integer.valueOf(str));
                }


            }

        }
        catch(FileNotFoundException e) {
            e.printStackTrace();
        }
        return array;
    }
}
