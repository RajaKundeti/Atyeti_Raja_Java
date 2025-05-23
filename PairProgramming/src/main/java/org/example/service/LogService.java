package org.example.service;

import org.example.pojo.Log;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogService {

    public Map<String, Long>  getFrequencyOfMessageTypes(List<Log> logList){
        return logList.stream()
                .collect(Collectors.groupingBy(Log::getMessageType,Collectors.counting()));
    }
}
