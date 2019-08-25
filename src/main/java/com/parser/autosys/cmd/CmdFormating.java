package com.parser.autosys.cmd;

import lombok.val;

import java.util.ArrayList;
import java.util.List;

import static com.parser.autosys.Parser.*;

public class CmdFormating {

    public List<String> cmdFormat(List<CmdProperty> list){

        List<String> boxList = new ArrayList<>();
        list.forEach(x->{
            val z= x.getCmdMap();
            String value="" + z.get(JOB_NAME)+ ";"
                    +z.get(JOB_TYPE_NAME)+ ";"
                    +z.get(BOX_NAME)+";"
                    +z.get(COMMAND_NAME)+";"
                    +z.get(MACNINE_NAME)+";"
                    +z.get(OWNER_NAME) + ";"
                    + z.get(PERMISSION_NAME)+ ";"
                    + z.get(DATE_CONDITION_NAME)+ ";"
                    + z.get(CONDITION_NAME)+ ";"
                    + z.get(DESCRIPTION_NAME) + ";"
                    +z.get(STD_OUT_FILE_NAME)+";"
                    +z.get(STD_ERR_FILE_NAME)+";"
                    + z.get(ALARM_IF_FAIL_NAME)+ ";"
                    +z.get(PROFILE_NAME)+";"
                    + z.get(APPLICATION_NAME);
            boxList.add(value);

        });
        return boxList;

    }

}


/*
    insert_job: US.ANA01514.CMD   job_type: CMD
            box_name: US.ANA01010.BOX
            command: $GEN_BIN/run_Talend_job.ksh -j "jSfCoreCustomFldAssetSeedStg"
            machine: Virtual_DEV_Linux
            owner: autosys
            permission: gx,ge,wx
            date_conditions: 0
            condition: s(US.ANA01443.CMD)
            description: "Triggers job jSfCoreCustomFldAssetSeedStg to load data from Spin Source Custom Fields to Snowflake Stage Asset Custom Field"
            std_out_file: "${ANA_LOG}/${AUTO_JOB_NAME}.log"
            std_err_file: "${ANA_LOG}/${AUTO_JOB_NAME}.log"
            alarm_if_fail: 1
            profile: "${HOME}/jobs/ana/env/ana_env_sf.sh"
            application: ANA
*/
