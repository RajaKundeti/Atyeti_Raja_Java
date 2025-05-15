package util;

import pojo.UserLog;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

public class FileUtility {

    public List<UserLog> getUserLogs(String filePath) throws IOException {
        List<UserLog> logs = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(filePath))){
            String line;
            while((line = br.readLine())!= null){
                String[] logData = line.split(",");
                UserLog log = new UserLog();
                log.setTimestamp(Timestamp.valueOf(logData[0].trim()));
                log.setUserId(logData[1].trim());
                log.setAction(logData[2].trim());
                logs.add(log);
            }
        }
        return logs;
    }
}
