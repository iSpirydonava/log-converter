package com.parser.autosys.box;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static com.parser.autosys.Parser.*;

public class BoxFormatting {
    public List<String> boxFormat(List<BoxProperty> list){

        List<String> boxList = new ArrayList<>();
        list.forEach(x->{
           val z= x.getBoxMap();
           String value="" + z.get(JOB_NAME)+ ";"
                   +z.get(JOB_TYPE_NAME)+ ";"
                   +z.get(OWNER_NAME) + ";"
                   + z.get(PERMISSION_NAME)+ ";"
                   + z.get(DATE_CONDITION_NAME)+ ";"
                   + z.get(CONDITION_NAME)+ ";"
                   + z.get(DESCRIPTION_NAME) + ";"
                   + z.get(ALARM_IF_FAIL_NAME)+ ";"
                   + z.get(APPLICATION_NAME);
           boxList.add(value);

        });
        return boxList;

    }

}


