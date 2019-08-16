package com.parser;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;


public class Runner {
    private List<String> cleanLogList = new ArrayList<>();

    public static void main(String... args) {
        System.out.println("Start parsing");
        List<String> fileList = new ArrayList<>(Arrays.asList(args));
        Runner runner = new Runner();
        fileList.forEach(x -> {
            List<String> z = runner.readLinesFromResourceFile(x);
            List<String> y = runner.cleanLog(z);
            runner.writeInLog(x, y);
        });
    }


    public List<String> readLinesFromResourceFile(String filename) {

        List<String> file = new ArrayList<>();
        Path str = Paths.get(filename);
        try (Stream<String> stream = Files.lines(str)) {
            file.addAll(stream
                    .collect(Collectors.toList()));

        } catch (IOException e) {
            e.printStackTrace();
        }
        return file;
    }

    public List<String> cleanLog(List<String> logList) {
        List<String> x1 = logList.stream()
                .filter(x -> x.matches("^\\d\\d:\\d\\d.*") || x.matches("^WARN.*"))
                .collect(Collectors.toList());

        List<String> x2 = x1.stream().filter(x -> x.contains("COMPARING TABLES:")
                || x.contains("count gathered by COUNT(*)")
                || x.contains("ERROR: Rows count is not equal")
                || x.contains("CHECKSUM for column ")
                || x.contains("WARN")
                || x.contains("METADATA CHECK STARTED")
                || x.contains("Column names and quantity")
                || x.contains("there are additional columns:")
                || x.contains("Number of table(s) left")
                || x.contains("Preliminary execution time"))

                .map(x -> x.contains("COMPARING TABLES:") ? "\n" + "+++++++++++++++++++++++++++++++++++++\n" + x : x)
                .map(x -> x.replace(",", ";"))
                .map(x -> x.contains("ERROR") ? "================\n" + x + "\n================" : x)
                .map(x -> x.replace("[main]", ","))
                .map(x -> x.replace("scala.App - ", ","))
                .collect(Collectors.toList());
        return x2;
    }


    public void writeInLog(String filename, List<String> list) {
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
