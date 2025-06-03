package org.pp1.util;
import org.junit.jupiter.api.Test;
import org.pp1.pojo.Log;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.sql.Timestamp;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

class FileUtilTest {

    @Test
    void testInvalidFilePaths(){
        assertNotNull(FileUtil.getLogsData(""));
        assertDoesNotThrow(()->FileUtil.getLogsData(null));
        assertDoesNotThrow(()->FileUtil.getLogsData("C:\\Programs\\data\\file.log"));
    }

    @Test
    public void testGetLogsData_validFile() throws IOException {
        Path tempFile = Files.createTempFile("logs", ".csv");
        Files.write(tempFile, List.of(
                "timestamp,userId,messageType,message",
                "2025-05-30 10:00:00,101,INFO,Started process",
                "2025-05-30 10:05:00,102,ERROR,Failed operation"
        ));
        List<Log> logs = FileUtil.getLogsData(tempFile.toString());
        assertEquals(2, logs.size());
        Log log1 = logs.getFirst();
        assertEquals(Timestamp.valueOf("2025-05-30 10:00:00"), log1.getTimestamp());
        assertEquals(101, log1.getUserId());
        assertEquals("INFO", log1.getMessageType());
        assertEquals("Started process", log1.getMessage());
        Log log2 = logs.get(1);
        assertEquals(Timestamp.valueOf("2025-05-30 10:05:00"), log2.getTimestamp());
        assertEquals(102, log2.getUserId());
        assertEquals("ERROR", log2.getMessageType());
        assertEquals("Failed operation", log2.getMessage());
        Files.deleteIfExists(tempFile); // Clean up
    }

    @Test
    public void testGetLogsData_fileNotFound() {
        List<Log> logs = FileUtil.getLogsData("non_existent.csv");
        assertNotNull(logs);
        assertTrue(logs.isEmpty());
    }

    @Test
    public void testGetLogsData_malformedData() throws IOException {
        Path tempFile;
        try {
            tempFile = Files.createTempFile("logs_malformed", ".csv");
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        Files.write(tempFile, List.of(
                "timestamp,userId,messageType,message",
                "2025-05-30 10:00:00,101,INFO",
                "2025-05-30 10:10:00,103,DEBUG,Processed"
        ));
        List<Log> logs = FileUtil.getLogsData(tempFile.toString());
        assertTrue(logs.isEmpty());
        Files.deleteIfExists(tempFile);
    }
}