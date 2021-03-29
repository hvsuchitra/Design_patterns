package wordPlay.util;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
/**
 * Results is used to write to output file and stdout.
 * Results class implements FileDisplayInterface and StdoutDisplayInterface
 *
 */
public class Results implements FileDisplayInterface, StdoutDisplayInterface {

    String Filedata;
    String OutPath;

    public Results(String OutputPath,String data) {
        Filedata = data;
        OutPath = OutputPath;
        writeToFile();
        writeToStdout();
    }
    /**
     * writeToFile() writes the expected output to the output.txt
     *
     */

    @Override
    public void writeToFile() {


        File file = new File(OutPath);

        FileWriter fr = null;
        BufferedWriter br = null;
        try{
            if (!file.exists()) {
                file.createNewFile();
            }
            fr = new FileWriter(file);
            br = new BufferedWriter(fr);
            br.write(Filedata);
        } catch (IOException e) {
            e.printStackTrace();
        }finally{
            try {
                br.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }
    /**
     * writeToStdout() writes the expected output to the Stdout
     *
     */

    @Override
    public void writeToStdout() {
        System.out.println(Filedata+"\n");

    }
    @Override
    public String toString()
    {
        return String.format("filedata is" + Filedata + "outputpath is" +OutPath);
    }
}
