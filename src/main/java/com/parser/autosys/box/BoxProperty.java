package com.parser.autosys.box;

import com.parser.autosys.Parser;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Getter
public class BoxProperty extends Parser {

    public final static String JOB_TYPE_BOX = "BOX";
    private Map<String, String> boxMap = new HashMap<>();

    public BoxProperty(List<String> str) {
       boxMap.putAll(splitPropertyStringsByDoublePoints(str,JOB_TYPE_BOX));
    }

}
