package com.parser.autosys.box;

import com.parser.autosys.Parser;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static com.parser.autosys.box.BoxProperty.JOB_TYPE_BOX;


public class BoxParser extends Parser {


    private List<BoxProperty> getBox(List<String> str, List<Integer> indexList) {
        List<BoxProperty> boxList = new ArrayList<>();
        for (int x = 0; x < indexList.size(); x++) {
            List<String> y;

            if (x + 1 < indexList.size())
                y = str.subList(indexList.get(x), indexList.get(x + 1));
            else y = str.subList(indexList.get(x), str.size());
            boxList.add(new BoxProperty(y));
        }
        return boxList;
    }



    public List<BoxProperty> getBoxList(List<String> str) {
        val values = filterValues(str);
        val indexList = getJobNameIndexList(values, JOB_TYPE_BOX);
        val box = getBox(values, indexList);

        return box;
    }



}
