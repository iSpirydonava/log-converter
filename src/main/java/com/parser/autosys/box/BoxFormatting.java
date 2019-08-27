package com.parser.autosys.box;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static com.parser.autosys.Parser.*;

public class BoxFormatting {
    public List<String> boxFormat(List<BoxProperty> list) {

        List<String> boxList = new ArrayList<>();
        boxList.add(JOB_NAME + ","
                + JOB_TYPE_NAME + ","
                + OWNER_NAME + ","
                + PERMISSION_NAME + ","
                + DATE_CONDITION_NAME + ","
                + START_TIME_NAME + ","
                + CONDITION_NAME + ","
                + DESCRIPTION_NAME + ","
                + ALARM_IF_FAIL_NAME + ","
                + APPLICATION_NAME);
        list.forEach(x -> boxList.add(boxString(x)));
        return boxList;

    }

    public String boxString(BoxProperty boxProperty) {
        val z = boxProperty.getBoxMap();
        String value = "" + z.get(JOB_NAME) + ","
                + z.get(JOB_TYPE_NAME) + ","
                + z.get(OWNER_NAME) + ","
                + z.get(PERMISSION_NAME).replace(",", ";") + ","
                + z.get(DATE_CONDITION_NAME) + ","
                + z.get(START_TIME_NAME) + ","
                + z.get(CONDITION_NAME) + ","
                + z.get(DESCRIPTION_NAME).replace(",", ";") + ","
                + z.get(ALARM_IF_FAIL_NAME) + ","
                + z.get(APPLICATION_NAME);
        return value;
    }

    public String boxWithCondition(BoxProperty boxProperty) {
        val z = boxProperty.getBoxMap();
        String value = "" + z.get(JOB_NAME) + ","
                + z.get(CONDITION_NAME);
        return value;
    }

}


