package com.parser.autosys.cmd;


import com.parser.autosys.Parser;
import lombok.Getter;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Getter
public class CmdProperty extends Parser {

    public final static String JOB_TYPE_CMD = "CMD";
    private Map<String, String> cmdMap = new HashMap<>();


    public CmdProperty(List<String> str) {
        cmdMap.putAll(splitPropertyStringsByDoublePoints(str, JOB_TYPE_CMD));
    }



}
