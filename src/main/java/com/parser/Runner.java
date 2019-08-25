package com.parser;


import com.parser.file.FileList;
import com.parser.file.FileReader;
import com.parser.file.FileWritter;
import com.parser.log.LogParser;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class Runner {
    private static FileReader fileReader = new FileReader();
    private static FileWritter fileWritter = new FileWritter();
    private static FileList fileList = new FileList();
    private static LogParser logParser = new LogParser();
    private static CmdParser cmdParser = new CmdParser();
    private static BoxParser boxParser = new BoxParser();


    public static void main(String... args) {
        System.out.println("Start parsing");
        if (args.length != 0) {
            List<String> fileList = new ArrayList<>(Arrays.asList(args));
            Runner runner = new Runner();
            fileList.forEach(x -> {
                List<String> z = fileReader.readLinesFromResourceFile(x);
                List<String> y = logParser.cleanLog(z);
                fileWritter.writeInFile(x, y);
            });
        }

        List<String> z = fileList.getFileListInFolder("./jil");
        z.forEach(x -> {
            val y = fileReader.readLinesFromResourceFile(x);
            val cmdList = cmdParser.getCmdList(y);
            val boxList= boxParser.getBoxList(y);
            System.out.println();
        });
    }

}
