package wordmanagement;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DuplicateWordCounter {

    public static Map<String, Integer> countWords(List<String> wordsList){
        Map<String, Integer> wordCount = new HashMap<>();
        wordsList.forEach(word-> {
                    if (wordCount.containsKey(word)) {
                        wordCount.put(word, wordCount.get(word)+1);
                    }
                    else{
                        wordCount.put(word, 1);
                    }
                }
        );
        return wordCount;
    }

    public static void showDuplicateWords(Map<String, Integer> words){
        words.forEach((word,count)->{
            if(count > 1)
                System.out.println(word + " : " + count);
        });
    }
}
