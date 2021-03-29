package textdecorators;

import textdecorators.util.InputDetails;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class MostFreqWordDecorator extends AbstractTextDecorator{
    private AbstractTextDecorator keywordDecorator;
    private InputDetails inputDetails;
    public MostFreqWordDecorator(AbstractTextDecorator keywordDecorator,InputDetails inputDetails)
    {
        this.inputDetails=inputDetails;
        this.keywordDecorator=keywordDecorator;
        //mostFeqWordDecorator();
    }

    /*private void mostFeqWordDecorator() {
    }
     */
    /**
     * This method finds the most frequent word in the given file
     */

    @Override
    public void processInputDetails() {
        System.out.println("MostFrequent\n");
        List<String> words =inputDetails.getFileText();
        Map<String, Long> counts = inputDetails.getFileText().stream()
                .collect(Collectors.groupingBy(e -> e.toLowerCase(), Collectors.counting()));
        Map.Entry<String, Long> maxEntry = null;

        for (Map.Entry<String, Long> entry : counts.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        String freqWord=maxEntry.getKey();
        for(int i=0;i<words.size();i++)
        {
            if(words.get(i).toLowerCase().equals(freqWord.toLowerCase()))
            {
                String newWord=words.get(i);
                if(words.get(i).endsWith("."))
                {
                    String withoutPeriod = newWord.substring(0, newWord.length() - 1);
                    newWord = newWord.replace(newWord, PrefixSuffix.MOST_FREQUENT_ + withoutPeriod + PrefixSuffix._MOST_FREQUENT+".");
                }
                else
                {
                    newWord = newWord.replace(newWord, PrefixSuffix.MOST_FREQUENT_ + newWord + PrefixSuffix._MOST_FREQUENT);
                }
                words.set(i, newWord);
            }
        }
       // System.out.println(words);

        if (null != keywordDecorator) {
            keywordDecorator.processInputDetails();
        }
    }

    @Override
    public String toString() {
        return "MostFreqWordDecorator{" +
                "keywordDecorator=" + keywordDecorator +
                ", inputDetails=" + inputDetails +
                '}';
    }
}

