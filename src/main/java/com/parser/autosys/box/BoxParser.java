package com.parser.autosys.box;

import com.parser.autosys.Parser;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static com.parser.autosys.box.BoxProperty.JOB_TYPE_BOX;


public class BoxParser extends Parser {


    private List<BoxProperty> getBoxList(List<String> str, Map<Integer, String> indexList) {
        List<BoxProperty> boxList = new ArrayList<>();
        val indexes = new ArrayList<>(indexList.keySet());
        for (int i = 0; i < indexes.size(); i++) {
            if (indexList.get(indexes.get(i)).equals("BOX")) {

            }
        }

        return boxList;
    }


    public List<BoxProperty> getBoxList(List<String> str) {
        val values = filterValues(str);
        val indexList = getJobNameIndexList(values);
        val box = getBoxList(values, indexList);

        return box;
    }


}
