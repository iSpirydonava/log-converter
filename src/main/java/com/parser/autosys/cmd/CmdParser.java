package com.parser.autosys.cmd;

import com.parser.autosys.Parser;
import lombok.val;

import java.util.ArrayList;
import java.util.List;


public class CmdParser extends Parser {

    private List<Cmd> getCmd(List<String> str, List<Integer> indexList) {
        List<Cmd> cmdList = new ArrayList<>();
        for (int x = 0; x < indexList.size(); x++) {
            List<String> y;

            if (x + 1 < indexList.size())
                y = str.subList(indexList.get(x), indexList.get(x + 1));
            else y = str.subList(indexList.get(x), str.size());
            cmdList.add(new Cmd(y));
        }
        return cmdList;
    }


    public List<Cmd> getCmdList(List<String> str) {
        val values = filterValues(str);
        val indexList = getJobNameIndexList(values, JOB_TYPE_CMD);
        val cmd = getCmd(values, indexList);

        return cmd;
    }



}
