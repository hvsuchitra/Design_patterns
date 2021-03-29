package textdecorators;

import textdecorators.util.InputDetails;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class SpellCheckDecorator extends AbstractTextDecorator {
    private InputDetails inputDetails;
    private AbstractTextDecorator sentenceDecorator;

    public SpellCheckDecorator(AbstractTextDecorator sentenceDecorator, InputDetails inputDetails) {
        this.inputDetails = inputDetails;
        this.sentenceDecorator = sentenceDecorator;
        //SpellCheck();
    }

    /*private void SpellCheck() {
    }*/

    /**
     * Searches for SpellCheck words given in the file and adds prefix and suffix to the word
     */

    @Override
    public void processInputDetails() {
        System.out.println("SpellCheck");
        List<String> words = inputDetails.getFileText();
        //System.out.println(words);
        Set<String> spellCheckWords = inputDetails.getMisspelledList();
        for (int i = 0; i < words.size(); i++) {
            Iterator<String> itr = spellCheckWords.iterator();

            while (itr.hasNext()) {
                if (words.get(i).toLowerCase().contains(itr.next().toLowerCase())) {
                    String newWord = words.get(i);
                    if(words.get(i).endsWith("."))
                    {
                        String withoutPeriod = newWord.substring(0, newWord.length() - 1);
                        newWord = newWord.replace(newWord, PrefixSuffix.SPELLCHECK_ + withoutPeriod + PrefixSuffix._SPELLCHECK+".");
                    }
                    else
                    {
                        newWord = newWord.replace(newWord, PrefixSuffix.SPELLCHECK_ + newWord + PrefixSuffix._SPELLCHECK);
                    }
                    words.set(i, newWord);


                }

            }
        }
        //System.out.println(words);
        if (null != sentenceDecorator) {
            sentenceDecorator.processInputDetails();
        }

    }

    @Override
    public String toString() {
        return "SpellCheckDecorator{" +
                "inputDetails=" + inputDetails +
                ", sentenceDecorator=" + sentenceDecorator +
                '}';
    }
}
