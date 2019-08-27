package com.parser.autosys.box;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.parser.autosys.Parser.getJobNameIndexList;


public class BoxParser {

    public List<BoxProperty> getBoxList(List<String> str) {
        List<BoxProperty> boxList = new ArrayList<>();
        List<Integer> indexList= new ArrayList<>(getJobNameIndexList(str).keySet());
        Collections.sort(indexList);
        for (int x = 0; x < indexList.size(); x++) {
            List<String> y;

            if (x + 1 < indexList.size())
                y = str.subList(indexList.get(x), indexList.get(x + 1));
            else y = str.subList(indexList.get(x), str.size());
            boxList.add(new BoxProperty(y));
        }

        return boxList;
    }


}
