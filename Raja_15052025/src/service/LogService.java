package service;
import pojo.UserLog;

import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogService {

    public long countUniqueUsers(List<UserLog> logs){
        return logs.stream().distinct().count();
    }

    public String getMaximumUserByAction(List<UserLog> logs, String action) {
        Map<String, Long> groupedByUserId = logs.stream().filter(u->u.getAction().equals(action)).collect(Collectors.groupingBy(UserLog::getUserId, Collectors.counting()));
        return groupedByUserId
                .entrySet()
                .stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey)
                .orElse(null);
    }
}
