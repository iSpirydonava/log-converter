package com.parser.autosys.cmd;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import static com.parser.autosys.Parser.getJobNameIndexList;


public class CmdParser  {


    public List<CmdProperty> getCmd(List<String> str) {
        List<CmdProperty> cmdList = new ArrayList<>();
        List<Integer> indexList= new ArrayList<>(getJobNameIndexList(str).keySet());
        Collections.sort(indexList);
        for (int x = 0; x < indexList.size(); x++) {
            List<String> y;

            if (x + 1 < indexList.size())
                y = str.subList(indexList.get(x), indexList.get(x + 1));
            else y = str.subList(indexList.get(x), str.size());
            cmdList.add(new CmdProperty(y));
        }
        return cmdList;
    }

}
