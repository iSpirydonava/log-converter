package com.parser.file;

import lombok.SneakyThrows;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

public class FileList {
    @SneakyThrows
    public List<String> getFileListInFolder(String folder) {
        return Files.walk(Paths.get(folder))
                .filter(Files::isRegularFile)
                .map(Path::toFile)
                .map(File::getName)
                .filter(x -> x.contains("jil"))
                .map(x-> folder+"/"+x)
                .collect(Collectors.toList());
    }


}
