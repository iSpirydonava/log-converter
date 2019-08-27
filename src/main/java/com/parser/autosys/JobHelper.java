package com.parser.autosys;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

@Getter
public class JobHelper {

    private  List<String> cmdStringList = new ArrayList<>();
    private List<String> boxStringList = new ArrayList<>();


    public  void splitByJobType(List<String> str, Map<Integer, String> indexes) {
        List<String> cmdList = new ArrayList<>();
        List<String> boxList = new ArrayList<>();

        List<Integer> keys = new ArrayList<>(indexes.keySet());
        Collections.sort(keys);
        for (int i = 0; i < keys.size(); i++) {
            int index = keys.get(i);
            int nextIndex = (keys.size()-1 == i) ? str.size() : keys.get(i + 1);

            if (indexes.get(index).toUpperCase().contains("BOX")) boxList.addAll(str.subList(index, nextIndex));
            else if (indexes.get(index).toUpperCase().contains("CMD")) cmdList.addAll(str.subList(index, nextIndex));
        }

        cmdStringList.addAll(cmdList);
        boxStringList.addAll(boxList);
    }

}
