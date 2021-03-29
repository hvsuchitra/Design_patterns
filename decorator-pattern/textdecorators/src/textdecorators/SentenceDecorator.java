package textdecorators;

import textdecorators.util.FileDisplayInterface;
import textdecorators.util.FileProcessor;
import textdecorators.util.InputDetails;
import textdecorators.PrefixSuffix;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SentenceDecorator extends AbstractTextDecorator {
    private InputDetails inputDetails;
    private AbstractTextDecorator atd;
    private FileProcessor fileProcessor;
    private String inputPath;

    public SentenceDecorator(AbstractTextDecorator sentenceDecorator, InputDetails inputDetails) {
        this.atd = sentenceDecorator;
        this.inputDetails = inputDetails;

    }
    /**
     * this method adds prefix and suffix start and end of the sentences
     */

    @Override
    public void processInputDetails() {
        System.out.println("SentenceDecorator");
        List<String> words = inputDetails.getFileText();
        for (int i = 0; i < words.size(); i++) {
            if (i == 0) {
                String newWord = words.get(i);
                newWord = newWord.replace(newWord, PrefixSuffix.BEGIN_SENTENCE__ + newWord);
                words.set(i, newWord);
                //System.out.println(newWord);
            }
           /*if(words.get(i).equals(".")||words.equals(" ."))
           {
               String newWord=words.get(i);
               newWord=newWord.replace(newWord,PrefixSuffix.__END_SENTENCE+newWord);
               words.set(i,newWord);
               System.out.println(newWord);
           }*/
            if (words.get(i).endsWith(".")) {
                String newWord = words.get(i);
                String withoutPeriod = newWord.substring(0, newWord.length() - 1);
                newWord = newWord.replace(newWord, withoutPeriod + PrefixSuffix.__END_SENTENCE + ".");
                words.set(i, newWord);
                //System.out.println(newWord);

                if (words.get(i + 1) != null && !isSpace(words.get(i + 1))) {
                    String nextWord = words.get(i + 1);
                    nextWord = nextWord.replace(nextWord, PrefixSuffix.BEGIN_SENTENCE__ + nextWord);
                    words.set(i + 1, nextWord);
                    //System.out.println(words.get(i + 1));
                }
            }


        }
        System.out.println(words);
        if (null != atd) {
            atd.processInputDetails();
        }


    }

    public static boolean isSpace(String word) {
        return word.matches("\\s+") || word.matches("\\n");

    }

    @Override
    public String toString() {
        return "SentenceDecorator{" +
                "inputDetails=" + inputDetails +
                ", atd=" + atd +
                ", fileProcessor=" + fileProcessor +
                ", inputPath='" + inputPath + '\'' +
                '}';
    }
}