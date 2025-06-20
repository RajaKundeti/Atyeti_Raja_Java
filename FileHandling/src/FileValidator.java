import java.io.File;
import java.util.function.Consumer;
import java.util.logging.Logger;

public class FileValidator {

    private final Logger logger = Logger.getLogger("FileValidator.class");

    public void validateFile(String path, Consumer<File> checkData){
        File file = new File(path);
        if(file.exists()){
            logger.severe(file.getAbsolutePath()+" is not exists");
        }
        else if(!file.isFile()){
            logger.severe(file.getAbsolutePath()+" is not a file");
        }
        else if(file.isDirectory()){
            logger.severe(file.getAbsolutePath()+" is a directory");
        }
        else{
            checkFileData(file,checkData);
        }
    }

    private void checkFileData(File file, Consumer<File> checkData) {
        checkData.accept(file);
    }
}
