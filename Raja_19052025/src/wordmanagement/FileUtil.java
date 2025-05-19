package wordmanagement;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileUtil {

    public static List<String> readFile(String path){
        List<String> wordList = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new java.io.FileReader(path))){
            String line = null;
            while((line = br.readLine())!= null){
                wordList.addAll(Arrays.asList(line.split(" ")));
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        return wordList;
    }
}
