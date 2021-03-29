package wordPlay.handler;
import wordPlay.util.FileProcessor;

import java.io.File;
import wordPlay.util.FileDisplayInterface;
import wordPlay.util.Results;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.FileWriter;
//import wordPlay.util.StdoutDisplayInterface;


public class WordRotator
{
    private String rotatorOutput="";
    public String outPath;
    public String outputPath;
    public String inputPath;
    /**
     * WordRotator checks the boundary conditions and throws error if any conditions are not
     * statisfied else calls the rotate function for word rotation
     *
     */
    public WordRotator(String inputFilePath,String outputPath)
    throws FileNotFoundException,StringIndexOutOfBoundsException,StringIndexOutOfBoundsException {
        //this.inputFilePath=inputFilePath;
        //this.outputPath=outputPath;
        outPath = outputPath;
        inputPath = inputFilePath;
        //File f = new File(inputPath);

       // FileWriter fr = null;
        //fr = new FileWriter(f);
        //System.out.println(f.length());
            try {
                FileProcessor fileProcessor = new FileProcessor(inputFilePath);
                //fileProcessor.FileProcessor(inputFilePath);
                String word = fileProcessor.poll();

                int index = 1;
                while (word != null) {
                    boolean lastWordCheck = false;
                    if (word.contains(".")) {
                        word = word.substring(0, word.length() - 1);
                        lastWordCheck = true;
                    }
                    // System.out.println(word);
                    if (!word.matches("^[a-zA-Z0-9]*$")) {
                        System.err.println("Input File containing characters other than AlphaNumeric");
                    }
                    String finalString = rotate(word, index, lastWordCheck);
                    // System.out.println(finalString);
                    if (lastWordCheck) {
                        index = 0;
                    }
                    index = index + 1;
                    word = fileProcessor.poll();
                }

            }  catch (StringIndexOutOfBoundsException ex) {
                System.out.println("Empty Line");
                System.exit(0);

            } catch (Exception ex) {
                System.out.println(ex.getMessage());
                System.exit(0);
                //System.out.println();
            }
    }
    /**
     * rotate rotates each word based on it's index values
     *
     * @return rotated String. If it is lastword of the line it adds "." at the end.
     */
    public String rotate(String word,int index,boolean lastWordCheck)
    {
        //System.out.println("in rotate");

        int wordLength = word.length();
        index = index%wordLength;
        char[] result = new char[wordLength];
        int start = wordLength-index;
        int count =0;
        for(int i = start;i< wordLength;i++,count++)
        {
            result[count] = word.charAt(i);
        }

        for(int k=0;count<wordLength;count++,k++)
        {
            result[count] = word.charAt(k);
        }

        rotatorOutput = rotatorOutput+String.valueOf(result);
        if(lastWordCheck)
        {
            rotatorOutput = rotatorOutput+"."+"\n";
        }
        else
        {
            rotatorOutput = rotatorOutput+" ";
        }
        //System.out.println(rotatorOutput);
        return rotatorOutput;
    }
    /**
     * wordRotateWrite calls the Results constructor with 2 arguments outputpath and rotated string
     *
     */
    public void wordRotateWrite()
    {
        Results result = new Results(outPath,this.rotatorOutput);
        //fileDisplayInterface.writeToFile(outputPath,this.rotatorOutput);
    }
    @Override
    public String toString()
    {
        return String.format("inputpath is" + inputPath + "outputpath is" +outPath);
    }

}








