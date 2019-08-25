package com.parser.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

public class FileWritter {

    public void writeInFile(String filename, List<String> list) {
        //  URI file1 = URI.create("log.csv");
        String name = filename.replace("txt", "csv");
        String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());
        File file = new File(timeStamp + "-" + name);
        Path str = Paths.get(file.toString());


        try {
            Files.write(str, list, Charset.forName("US-ASCII"));
        } catch (IOException e) {
            System.err.println(e);
        }
    }

}
