package textdecorators.util;

import textdecorators.exceptions.AppException;
import textdecorators.util.FileDisplayInterface;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class InputDetails implements FileDisplayInterface {
    private ArrayList<String> fileText = new ArrayList<>();
    private Set<String> misspelledList = new HashSet<>();
    private Set<String> keywordList =new HashSet<>();
    private StringBuilder outputBuffer = new StringBuilder("");
    private String inputPath;
    private String outPath;
    private String misspelled;
    private String keywords;
    public static final String WORD_PATTERN = "^[a-zA-Z0-9\\.,\\s]+$";
    public InputDetails(String inputPath,String outPath,String misspelled,String keywords) {
        this.inputPath = inputPath;
        this.outPath = outPath;
        this.misspelled = misspelled;
        this.keywords = keywords;
        processFiles();
    }

    /**
     * Creates instances of FileProcessor
     * @throws AppException
     */

    private final void processFiles() throws AppException {
        try {
            FileProcessor inputFile = new FileProcessor(this.inputPath);
            FileProcessor misspellFile = new FileProcessor(this.misspelled);
            FileProcessor keywordFile = new FileProcessor(this.keywords);
            processInputFile(inputFile,misspellFile,keywordFile);
        }
        catch (Exception e)
        {
            throw new AppException("Error in file processor", e);
        }
    }

    /**
     * Processes inputFile, Misspelled File, Keywords File into Arraylist, Hashsets
     * @param inputFile
     * @param misspellFile
     * @param keywordFile
     * @throws IOException
     */
    public void processInputFile(FileProcessor inputFile,FileProcessor misspellFile,FileProcessor keywordFile) throws IOException {
        //FileProcessor inputFile = new FileProcessor(this.inputPath);
        //FileProcessor misspellFile = new FileProcessor(this.misspelled);
        //FileProcessor keywordFile = new FileProcessor(this.keywords);
        try {


            String text;
            System.out.println("In processInputFile");
            //String textFile = null;
            while ((text = inputFile.poll()) != null) {
                String[] words = text.split("\\s+");
                String finalWord;
                //text=fileProcessor.poll();
                for (int i = 0; i < words.length; i++) {
                    Pattern pattern = Pattern.compile(WORD_PATTERN);
                    Matcher m = pattern.matcher(words[i]);
                    if (!m.matches()) {
                        System.out.println("Invalid Word");
                        throw new AppException("Invalid Word");
                    }

                    fileText.add(words[i]);
                }
                fileText.add("\n");

           /* if(text.endsWith("."))
            {
                System.out.println("");
            }*/

            }

            while ((text = misspellFile.poll()) != null) {
                String[] words = text.split("\\s+");
                String finalWord;
                //text=fileProcessor.poll();
                for (int i = 0; i < words.length; i++) {
                    String word=words[i].toLowerCase();
                    Pattern pattern = Pattern.compile(WORD_PATTERN);
                    Matcher m = pattern.matcher(words[i]);
                    if (!m.matches()) {
                        System.out.println("Invalid Word in Misspelled file");
                        throw new AppException("Invalid Word");
                    }

                    misspelledList.add(word);
                }
            }
            while ((text = keywordFile.poll()) != null) {
                String[] words = text.split("\\s+");
                String finalWord;
                //text=fileProcessor.poll();
                for (int i = 0; i < words.length; i++) {
                    String word=words[i].toLowerCase();
                    Pattern pattern = Pattern.compile(WORD_PATTERN);
                    Matcher m = pattern.matcher(words[i]);
                    if (!m.matches()) {
                        System.out.println("Invalid Word in Keyword file");
                        throw new AppException("Invalid Word");
                    }

                    keywordList.add(word);
                }

            }
            System.out.println(fileText);
            System.out.println(misspelledList);
            System.out.println(keywordList);

        /*for(int i=0;i<fileText.size();i++)
        {
            System.out.println(fileText.get(i));
        }*/
        }
        catch (Exception e)
        {
            throw new AppException("Error Processing the files",e);
        }

    }

    public String getInputPath() {
        return inputPath;
    }

    public String getOutPath() {
        return outPath;
    }

    public ArrayList<String> getFileText() {
        return fileText;
    }

    public Set<String> getKeywordList() {
        return keywordList;
    }

    public Set<String> getMisspelledList() {
        return misspelledList;
    }


    public void setInputPath(String inputPath) {
        this.inputPath = inputPath;
    }

    public void setOutPath(String outPath) {
        this.outPath = outPath;
    }

    @Override
    public String toString() {
        return "InputDetails{" +
                "fileText=" + fileText +
                ", misspelledList=" + misspelledList +
                ", keywordList=" + keywordList +
                ", outputBuffer=" + outputBuffer +
                ", inputPath='" + inputPath + '\'' +
                ", outPath='" + outPath + '\'' +
                ", misspelled='" + misspelled + '\'' +
                ", keywords='" + keywords + '\'' +
                '}';
    }

    /**
     * Method to write the output to the file
     */
    @Override
    public void writeToFile() {
        //FileWriter fileWriter = null;
        try {

            FileWriter fileWriter = new FileWriter((new File(outPath)));

            //File outputFile = new File(outPath);
            //fileWriter = new FileWriter(outputFile);
            for(String word: fileText) {
                fileWriter.write(word+" ");
            }
            fileWriter.flush();
            fileWriter.close();
        }
        catch (IOException e) {
            throw new RuntimeException("Error creating file at location " + outPath, e);
        }

    }
}
