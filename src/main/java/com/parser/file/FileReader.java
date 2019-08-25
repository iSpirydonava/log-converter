package com.parser.file;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FileReader {
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


}
