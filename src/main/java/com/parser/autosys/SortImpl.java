package com.parser.autosys;

import com.parser.autosys.box.BoxProperty;
import com.parser.autosys.cmd.CmdProperty;
import lombok.val;

import java.util.Comparator;
import java.util.List;

import static com.parser.autosys.Parser.BOX_NAME;
import static com.parser.autosys.Parser.JOB_NAME;

public class SortImpl {

    private List<CmdProperty> list;

    public SortImpl(List<CmdProperty> list) {
        this.list = list;
    }

    public static List<CmdProperty> sortCmdByNumber(List<CmdProperty> list) {
        Comparator<CmdProperty> comparator = Comparator.comparing(obj -> {
            val s = obj.getCmdMap().get(JOB_NAME);
            String s1 = "0";
            if (s == null) System.out.println("ERROR " + "null " + obj.getCmdMap().get(BOX_NAME));
            else {
                if (!s.isEmpty() && s.contains("US.ANA")) {
                    s1 = s.replaceAll("US\\.ANA", "")
                            .replaceAll(".[CMD,BOX]{1}", "")
                            .trim();
                } else System.out.println("ERROR " + s);
            }
            val p = Integer.valueOf(s1);
            return p;

        });
        list.sort(comparator);
        return list;
    }

    public static List<BoxProperty> sortBoxByNumber(List<BoxProperty> list) {
        Comparator<BoxProperty> comparator = Comparator.comparing(obj -> {
            return Integer.valueOf(
                    obj.getBoxMap().get(JOB_NAME)
                            .replaceAll("US.ANA", "")
                            .replaceAll(".[CMD,BOX]{1}", "")
                            .trim());
        });
        list.sort(comparator);
        return list;
    }


}
