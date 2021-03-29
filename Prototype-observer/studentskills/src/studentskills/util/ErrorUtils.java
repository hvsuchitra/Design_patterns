package studentskills.util;

import studentskills.mytree.StudentRecord;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class ErrorUtils{
    private String filePath;
    private static ErrorUtils errorUtils;
    private List<String> errorMsg;

    public ErrorUtils(String path) {
        this.filePath = path;
        this.errorMsg = new ArrayList<String>();
    }

    public static ErrorUtils getInstance() {
        return errorUtils;
    }

    public void addError(String err) {
        errorMsg.add(err);
        System.out.println("in error");
    }
    public void errorFile(String errorFile) throws IOException {
            FileWriter fileWriter = new FileWriter((new File(errorFile)));
            for(String  errMsg : errorMsg){
                fileWriter.write(errMsg);
            }
            fileWriter.close();

        }

    public String getFilePath() {
        return filePath;
    }
}


