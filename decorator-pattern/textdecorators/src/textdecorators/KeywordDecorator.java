package textdecorators;

import textdecorators.util.InputDetails;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class KeywordDecorator extends AbstractTextDecorator{
    private AbstractTextDecorator spellCheckDecorator;
    private InputDetails inputDetails;
    public KeywordDecorator(AbstractTextDecorator spellCheckDecorator,InputDetails inputDetails){
        this.spellCheckDecorator=spellCheckDecorator;
        this.inputDetails=inputDetails;
        //keywordDecorator();
    }

    /*private void keywordDecorator() {
    }*/

    /**
     * Searches for keywords given in the file and adds prefix and suffix to the word
     */
    @Override
    public void processInputDetails() {
        System.out.println("keywordDecorator\n");
        Set<String> keywords =inputDetails.getKeywordList();
        List<String> words = inputDetails.getFileText();
        for (int i = 0; i < words.size(); i++)
        {
            Iterator<String> itr = keywords.iterator();
            while (itr.hasNext()) {
                if (words.get(i).toLowerCase().contains(itr.next().toLowerCase())){
                    String newWord = words.get(i);
                    if(words.get(i).endsWith("."))
                    {
                        String withoutPeriod = newWord.substring(0, newWord.length() - 1);
                        newWord = newWord.replace(newWord, PrefixSuffix.KEYWORD_ + withoutPeriod + PrefixSuffix._KEYWORD+".");
                    }
                    else
                    {
                        newWord = newWord.replace(newWord, PrefixSuffix.KEYWORD_ + newWord + PrefixSuffix._KEYWORD);
                    }
                    words.set(i, newWord);
                }

            }
        }
        if (null != spellCheckDecorator) {
            spellCheckDecorator.processInputDetails();
        }
    }

    @Override
    public String toString() {
        return "KeywordDecorator{" +
                "spellCheckDecorator=" + spellCheckDecorator +
                ", inputDetails=" + inputDetails +
                '}';
    }
}
