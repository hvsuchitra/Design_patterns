package arrayvisitors.util;

import arrayvisitors.visitors.CommonIntsVisitor;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Set;
import java.util.List;
import java.util.HashSet;
import java.util.ArrayList;

public class Results implements FileDisplayInterface,StdoutDisplayInterface{

    CommonIntsVisitor commonIntsVisitor= new CommonIntsVisitor();
    private Set<Integer> commonInts;
    private List<Integer> missingInts;

    public Results() {
        this.commonInts = new HashSet<Integer>();
        this.missingInts = new ArrayList<Integer>();
    }

    public void addToList(Integer value) {
        commonInts.add(value);
    }

    public void addToSet(Integer value) {
        missingInts.add(value);
    }

    public void writeCommonIntsToFile(String path) throws IOException {
        writeToFile(path,this.getCommonInts());

    }



    public void writeMissingIntsToFile(String path) throws IOException{
        writeToFile(path,this.getMissingInts());
        
    }

    public List<Integer> getCommonInts() {
        return missingInts;
    }

    public Set<Integer> getMissingInts() {
        return commonInts;
    }

    @Override
    public void writeToFile(String path,Set<Integer> commonInts) throws IOException {

        FileWriter fileWriter = new FileWriter((new File(path)));
        for(int commonInt : commonInts){
            fileWriter.write(String.format("%02d",commonInt)+"\n");
        }

        fileWriter.close();
    }

    @Override
    public void writeToFile(String path, List<Integer> missingInts) throws IOException {
        FileWriter fileWriter = new FileWriter((new File(path)));
        for(int missingInt : missingInts)
        {
            fileWriter.write(String.format("%02d",missingInt)+"\n");
        }

        fileWriter.close();
    }



    public void CommonIntsToStdout() {
       // System.out.println(this.getCommonInts());
        WriteToStdout(this.getCommonInts());
    }

    @Override
    public void WriteToStdout(List<Integer> cInts) {
        System.out.println("Common Integers\n"+cInts);
    }

    @Override
    public void WriteToStdout(Set<Integer> MInts) {
        System.out.println("Missing numbers of both Input Files\n"+MInts);
    }

    public void MissingIntsToStdout(){
        //System.out.println(this.getMissingInts());
        WriteToStdout(this.getMissingInts());
    }

    @Override
    public String toString() {
        return "Results{" +
                "commonIntsVisitor=" + commonIntsVisitor +
                ", commonInts=" + commonInts +
                ", missingInts=" + missingInts +
                '}';
    }
}
