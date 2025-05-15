import pojo.UserLog;
import service.LogService;
import util.FileUtility;
import java.io.IOException;
import java.util.List;

public class Main {

    private static final LogService logService = new LogService();
    private static final FileUtility fileUtil = new FileUtility();
    private static final String logPath = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Atyeti_Raja_Java\\Raja_15052025\\src\\resources\\logs.txt";

    public static void main(String[] args) throws IOException {

        List<UserLog> logList = fileUtil.getUserLogs(logPath);
        long uniqueUsers = logService.countUniqueUsers(logList);
        System.out.println("No of unique users: "+uniqueUsers);
        String userId = logService.getMaximumUserByAction(logList,"DOWNLOAD");
        System.out.println(userId+" having maximum downloads");

    }
}