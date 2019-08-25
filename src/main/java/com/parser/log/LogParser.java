package com.parser.log;

import java.util.List;
import java.util.stream.Collectors;

public class LogParser {

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

}
