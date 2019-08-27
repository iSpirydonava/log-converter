package com.parser;


import com.parser.autosys.JobHelper;
import com.parser.autosys.JoinHelper;
import com.parser.autosys.box.BoxFormatting;
import com.parser.autosys.box.BoxParser;
import com.parser.autosys.box.BoxProperty;
import com.parser.autosys.cmd.CmdFormating;
import com.parser.autosys.cmd.CmdParser;
import com.parser.autosys.cmd.CmdProperty;
import com.parser.file.FileList;
import com.parser.file.FileReader;
import com.parser.file.FileWritter;
import com.parser.log.LogParser;
import lombok.val;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static com.parser.autosys.Parser.*;
import static com.parser.autosys.SortImpl.sortBoxByNumber;
import static com.parser.autosys.SortImpl.sortCmdByNumber;


public class Runner {
    private static FileReader fileReader = new FileReader();
    private static FileWritter fileWritter = new FileWritter();
    private static FileList fileList = new FileList();
    private static LogParser logParser = new LogParser();
    private static CmdParser cmdParser = new CmdParser();
    private static BoxParser boxParser = new BoxParser();
    private static JobHelper jobHelper = new JobHelper();
    private static BoxFormatting boxFormatting = new BoxFormatting();
    private static CmdFormating cmdFormating = new CmdFormating();
    private static JoinHelper joinHelper = new JoinHelper();


    public static void main(String... args) {
        logParsing(args);

        List<String> z = fileList.getFileListInFolder("./jil");

        List<CmdProperty> cmdList = new ArrayList<>();
        List<BoxProperty> boxList = new ArrayList<>();
        List<String> unitList = new ArrayList<>();

        z.forEach(x -> {
            val y = fileReader.readLinesFromResourceFile(x);
            unitList.addAll(getJobList(y));
        });


        val indexes = getJobNameIndexList(unitList);
        jobHelper.splitByJobType(unitList, indexes);
        cmdList.addAll(cmdParser.getCmd(jobHelper.getCmdStringList()));
        boxList.addAll(boxParser.getBoxList(jobHelper.getBoxStringList()));


        val sortCmdList = sortCmdByNumber(cmdList);
        val sortBoxList = sortBoxByNumber(boxList);


        val boxToFile = boxFormatting.boxFormat(sortBoxList);
        fileWritter.writeInFile("box_order.txt", boxToFile);
        val cmdToFile = cmdFormating.cmdFormat(sortCmdList);
        fileWritter.writeInFile("cmd_order.txt", cmdToFile);

        val joinedCMDAndBox = joinHelper.joinCmdAbdBox(sortCmdList, sortBoxList);
        fileWritter.writeInFile("joined_cmd_box.txt", joinedCMDAndBox);
        System.out.println();
    }


    public static void logParsing(String[] args) {
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
    }
}
