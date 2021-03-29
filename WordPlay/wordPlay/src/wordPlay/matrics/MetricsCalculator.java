package wordPlay.metrics;
import wordPlay.util.FileProcessor;
import wordPlay.util.FileDisplayInterface;
import wordPlay.util.Results;
import wordPlay.util.StdoutDisplayInterface;

public class MetricsCalculator {

    private double noOfWords;
    private double noOfSentences;
    private double wordsLength;
    public String OutPath;
    public String inputPath;
    /**
     * MetricsCalculator checks the boundary conditions and throws error if any conditions are not
     * statisfied and calls the calculateMetric.
     *
     */
    public MetricsCalculator(String inputFilePath,String outputPath) {
        try {
            OutPath=outputPath;
            inputPath=inputFilePath;
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
                wordsLength = calculateMetric(word, lastWordCheck);
                // System.out.println(wordsLength);
                if (lastWordCheck) {
                    index = 0;
                }
                index = index + 1;
                word = fileProcessor.poll();
            }
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
    }
    /**
     * calculateMetric calculates the wordslength
     * 
     * @return double wordslength
     */
    public double calculateMetric (String word,boolean lastWordCheck)
    {
        noOfWords = noOfWords + 1;
        if (lastWordCheck) {
            noOfSentences = noOfSentences + 1;
        }
        wordsLength = wordsLength + word.length();
        return wordsLength;
    }

        /*public void wordMetricWrite()
        {
            //FileDisplayInterface fileDisplayInterface = new Results();
            double avgNoWords = noOfWords / noOfSentences;
            double avgWordLength = (wordsLength) / noOfWords;
            String metricOutput = "";
            avgNoWords = Math.round(avgNoWords * 100.0) / 100.0;
            avgWordLength = Math.round(avgWordLength * 100.0) / 100.0;
            metricOutput = metricOutput + "AVG_NUM_WORDS_PER_SENTENCE = " + avgNoWords + "\n";
            metricOutput = metricOutput + "AVG_WORD_LENGTH =" + avgWordLength;
            Results result = new Results(OutPath,metricOutput);
        }*/
    /**
     * wordMetricStdOutput calculates the avg number of words per sentence and avg word length
     *
     */
    public void wordMetricStdOutput ()
    {
        //StdoutDisplayInterface stdoutDisplayInterface = new Results();
        double avgNoWords = noOfWords / noOfSentences;
        double avgWordLength = (wordsLength) / noOfWords;
        String metricOutput = "";
        avgNoWords = Math.round(avgNoWords * 100.0) / 100.0;
        avgWordLength = Math.round(avgWordLength * 100.0) / 100.0;
        metricOutput = metricOutput + "AVG_NUM_WORDS_PER_SENTENCE = " + avgNoWords + "\n";
        metricOutput = metricOutput + "AVG_WORD_LENGTH =" + avgWordLength;
        Results result = new Results(OutPath,metricOutput);
        //stdoutDisplayInterface.writeToStdout(metricOutput);
    }
    @Override
    public String toString()
    {
        return String.format("inputpath is" + inputPath + "outputpath is" +OutPath);
    }

}
