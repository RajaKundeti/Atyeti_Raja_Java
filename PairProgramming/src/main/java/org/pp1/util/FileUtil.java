package org.pp1.util;
import org.pp1.pojo.Log;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Supplier;
import java.util.logging.Logger;

public class FileUtil {

    static final Logger logger = Logger.getLogger("FileUtil.class");

    public static List<Log> getLogsData(String filePath) {
        List<Log> logs = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            br.readLine();
            String[] data;
            String line;
            while((line = br.readLine()) != null){
                data = line.split(",");
                Log log = new Log();
                log.setTimestamp(Timestamp.valueOf(data[0]));
                log.setUserId(Integer.parseInt(data[1]));
                log.setMessageType(data[2]);
                log.setMessage(data[3]);
                logs.add(log);
            }
        }catch (Exception e){
            logger.severe(e.getClass().getCanonicalName());
        }
        return logs;
    }
}
