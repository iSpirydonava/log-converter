package com.parser.autosys;

import com.parser.autosys.box.BoxFormatting;
import com.parser.autosys.box.BoxProperty;
import com.parser.autosys.cmd.CmdFormating;
import com.parser.autosys.cmd.CmdProperty;
import lombok.val;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import static com.parser.autosys.Parser.BOX_NAME;
import static com.parser.autosys.Parser.JOB_NAME;
import static com.parser.autosys.SortImpl.sortBoxByNumber;

public class JoinHelper {
    private BoxFormatting boxFormatting = new BoxFormatting();
    private CmdFormating cmdFormating = new CmdFormating();

    public List<String> joinCmdAbdBox(List<CmdProperty> cmdList, List<BoxProperty> boxPropertyList) {
        List<String> all = new ArrayList<>();
        all.add("BOX, BOX CONDITION, CMD, CMD CONDITION");
        cmdList.forEach(cmd -> {
            boxPropertyList.forEach(box -> {
                if (cmd.getCmdMap().get(BOX_NAME).equals(box.getBoxMap().get(JOB_NAME))) {
                    all.add(boxFormatting.boxWithCondition(box) + ","+ cmdFormating.cmdWithCondition(cmd));
                }
            });
        });
        return all;
    }

}
