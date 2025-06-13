package org.pp2;

import org.pp2.util.JsonFileUtil;

import java.util.HashMap;
import java.util.Map;

public class JsonFileUpdater {

    private static final String path = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\PairProgramming\\src\\main\\resources\\data.json";

    public static void main(String[] args) {

        //  TAKE LIST OF PROPERTIES AND THEIR VALUES
        Map<String, Object>  properties = new HashMap<>();
        properties.put("name","Raja");
        properties.put("sms",false);
        properties.put("database","MySQL");
        properties.put("frontend","Angular");

        //  UPDATE THE PROPERTIES WITH THEIR VALUES IN THE JSON FILE
        JsonFileUtil.updateData(path, properties);


    }

}
