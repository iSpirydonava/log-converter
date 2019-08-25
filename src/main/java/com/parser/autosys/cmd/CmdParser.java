package com.parser.autosys.cmd;

import com.parser.autosys.Parser;
import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static com.parser.autosys.cmd.CmdProperty.JOB_TYPE_CMD;


public class CmdParser extends Parser {

    private List<CmdProperty> getCmd(List<String> str, List<Integer> indexList) {
        List<CmdProperty> cmdList = new ArrayList<>();
        for (int x = 0; x < indexList.size(); x++) {
            List<String> y;

            if (x + 1 < indexList.size())
                y = str.subList(indexList.get(x), indexList.get(x + 1));
            else y = str.subList(indexList.get(x), str.size());
            cmdList.add(new CmdProperty(y));
        }
        return cmdList;
    }


    public List<CmdProperty> getCmdList(List<String> str) {
        val values = filterValues(str);
        val indexList = getJobNameIndexList(values, JOB_TYPE_CMD);
        val cmd = getCmd(values, indexList);

        return cmd;
    }



}
