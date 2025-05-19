package wordmanagement;

import java.util.List;
import java.util.Map;

public class WordCounter {

    private static final String path = "C:\\Users\\RajaNarasimhanKundet\\OneDrive - Atyeti Inc\\Desktop\\Self\\JavaPOC\\Atyeti_Raja_Java\\Raja_19052025\\src\\problem1\\sample_paragraph.txt";

    public static void main(String[] args) {

        List<String> wordsList = FileUtil.readFile(path);

        Map<String, Integer> wordsCount = DuplicateWordCounter.countWords(wordsList);

        DuplicateWordCounter.showDuplicateWords(wordsCount);

    }

}
