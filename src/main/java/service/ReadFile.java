package service;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.Scanner;

import entity.Array;

import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.LogManager;

public class ReadFile {
    private static final Logger logger = LogManager.getLogger(ReadFile.class);
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
                    logger.warn("line consist incorrect data. Line: {}", line);
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
                logger.info("array appended with next values: {}", Arrays.toString(splitted));


            }

        }
        catch(FileNotFoundException e) {
            logger.error("File not found. File path: {}", file.getAbsolutePath());
            e.printStackTrace();
        }
        return array;
    }
}
