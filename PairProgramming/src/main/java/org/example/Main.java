package org.example;

import org.example.pojo.Log;
import org.example.service.DBService;
import org.example.service.LogService;
import org.example.util.FileUtil;

import java.io.File;
import java.sql.SQLException;
import java.util.*;
import java.util.logging.Logger;

public class Main {

    private static final String directoryPath = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\PairProgramming\\src\\main\\resources";
    private static final LogService logService = new LogService();
    private static final Logger logger = Logger.getLogger("Main.class");
    private static List<Log> logs = new ArrayList<>();

    public static void main(String[] args) {

        try {
            //  READ DATA OF LOGS FROM A DIRECTORY AND STORE IT IN A LIST OF LOG
            File directory = new File(directoryPath);
            List<Thread> threads = new ArrayList<>();
            for (File file : Objects.requireNonNull(directory.listFiles((dir,name)->name.endsWith(".log")))) {
                Thread thread = new Thread(() -> processLogFile(file));
                thread.start();
                threads.add(thread);
            }

            for (Thread thread : threads) {
                thread.join();
            }

            //  COUNT FREQUENCY OF ERRORS,INFOS AND WARNINGS FROM THE LIST OF LOGS
            Map<String, Long> frequencyOfMessageTypes = logService.getFrequencyOfMessageTypes(logs);

            //  CREATING A CONNECTION WITH DATABASE
            DBService.setConnection("jdbc:mysql://localhost:3306/pairprogramming", "root", "N@rsik47");
            //  CREATING A TABLE IN THE DATABASE
//        DBService.executeUserQuery(
//                "create table log(" +
//                "id int primary key auto_increment," +
//                "time_stamp timestamp default current_timestamp," +
//                "error_count long," +
//                "warning_count long," +
//                "info_count long" +
//                ");"
//        );

            //  STORE THE FREQUENCY DATA IN DB
            String query = "insert into log(error_count,warning_count,info_count) values(" +
                    frequencyOfMessageTypes.get("ERROR") + "," +
                    frequencyOfMessageTypes.get("WARNING") + "," +
                    frequencyOfMessageTypes.get("INFO") +
                    ");";
            DBService.executeUserQuery(query);

            //  CLOSING THE CONNECTION
            DBService.con.close();

        } catch (Exception e) {
            logger.severe(e.getMessage());
        }

    }

    private static synchronized void processLogFile(File file) {
        List<Log> currentFile;
        if (file.getName().endsWith(".log")) {
            currentFile = FileUtil.getLogsData(file.getAbsolutePath());
            if (!logs.containsAll(currentFile)) {
                logger.info("reading completed from a file from the Thread:" + Thread.currentThread().getName());
                logs.addAll(currentFile);
            }
        }
    }
}