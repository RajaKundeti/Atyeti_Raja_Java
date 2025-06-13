package org.pp1.service;

import org.pp1.pojo.Log;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class LogService {

    public Map<String, Long>  getFrequencyOfMessageTypes(List<Log> logList){
        return logList.stream()
                .collect(Collectors.groupingBy(Log::getMessageType,Collectors.counting()));
    }
}
