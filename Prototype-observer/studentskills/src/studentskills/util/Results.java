package studentskills.util;

import studentskills.mytree.StudentRecord;
import studentskills.mytree.StudentSkills;
import studentskills.mytree.Tree;
import studentskills.mytree.TreeHelper;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Results class will write the three replicas to the file.
 */
public class Results implements FileDisplayInterface{

    private Tree tree;

    public Results(Tree tree) {
        this.tree = tree;
    }

    public void writeToFile(String outFilePath) throws IOException {
        List<StudentRecord> records = new ArrayList<>();
        tree.addToListInOrder(records);
        FileWriter fileWriter = new FileWriter((new File(outFilePath)));
        for(StudentRecord record : records){
            fileWriter.write(record.toString());
        }
        fileWriter.close();
    }

    @Override
    public String toString() {
        return "Results{" +
                "tree=" + tree +
                '}';
    }
}