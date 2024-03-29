package com.parser.autosys;

import lombok.Getter;
import lombok.val;

import java.util.*;
import java.util.stream.Collectors;

@Getter
public class Parser {

    public final static String JOB_NAME = "insert_job";
    public final static String BOX_NAME = "box_name";
    public final static String COMMAND = "command";
    public final static String CONDITION = "condition";
    public final static String JOB_TYPE_NAME = "job_type";
    public final static String COMMAND_NAME = "command";
    public final static String MACNINE_NAME = "machine";
    public final static String OWNER_NAME = "owner";
    public final static String PERMISSION_NAME = "permission";
    public final static String DATE_CONDITION_NAME = "date_conditions";
    public final static String CONDITION_NAME = "condition";
    public final static String DESCRIPTION_NAME = "description";
    public final static String STD_OUT_FILE_NAME = "std_out_file";
    public final static String STD_ERR_FILE_NAME = "std_err_file";
    public final static String ALARM_IF_FAIL_NAME = "alarm_if_fail";
    public final static String PROFILE_NAME = "profile";
    public final static String APPLICATION_NAME = "application";
    public final static String START_TIME_NAME = "start_times";


    public static Map<String, String> splitPropertyStringsByDoublePoints(List<String> str, String job_type) {
        Map<String, String> map = new HashMap<>();
        str.forEach(x -> {
            val y = (x.contains(START_TIME_NAME) || x.contains(DESCRIPTION_NAME))
                    ? x.replace(":", "-").replaceFirst("-", ":").split(":")
                    : x.split(":");
            if (y.length > 2) {
                map.put(y[0].trim(), y[1].replace(JOB_TYPE_NAME, "").trim());
                map.put(JOB_TYPE_NAME, y[2]);
            } else {
                if (y.length == 1) {
                    System.out.println("ERROR " + y[0]);
                } else
                    map.put(y[0].trim(), y[1].trim());
            }
        });
        return map;
    }

    public static List<String> filterValues(List<String> str) {
        return str.stream().map(x -> x.trim())
                .filter(x -> !x.contains("/*")
                        && !x.isEmpty()
                        && !x.contains("//"))
                .collect(Collectors.toList());
    }

    public static Map<Integer, String> getJobNameIndexList(List<String> str) {
        Map<Integer, String> indexList = new HashMap<>();
        str.forEach(x -> {
            if (x.contains(JOB_NAME)) {
                String[] jobType = x.split(JOB_TYPE_NAME + ":");
                val value = jobType[1];
                indexList.put(str.indexOf(x), value.toUpperCase());
            }
        });
        return indexList;
    }


    public static List<String> getJobList(List<String> str) {
        return filterValues(str);

    }
}
