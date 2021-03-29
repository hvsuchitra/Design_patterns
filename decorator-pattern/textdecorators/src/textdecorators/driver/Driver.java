package textdecorators.driver;

import textdecorators.*;
import textdecorators.exceptions.AppException;
import textdecorators.util.FileDisplayInterface;
import textdecorators.util.FileProcessor;
import textdecorators.util.InputDetails;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Driver {
    private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

    public static void main(String[] args) throws AppException,IOException {
        if ((args.length != 5) || (args[0].equals("${input}")) || (args[1].equals("${misspelled}")) || (args[2].equals("${keywords}")) || (args[3].equals("${output}"))
                || (args[4].equals("${debug}"))) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
            System.exit(0);
        }
        try{
            String inputPath = args[0];
            String misspelledPath = args[1];
            String keywordPath=args[2];
            if (args[0] == null || args[0].isEmpty()) {
                System.err.println("Input file path is not present");
                System.exit(1);
            }

            if (args[1] == null || args[1].isEmpty()) {
                System.err.println("misspelled path is not present");
                System.exit(1);
            }

            if (args[2] == null || args[2].isEmpty()) {
                System.err.println("keywords file path is not present");
                System.exit(1);
            }
            if (args[3] == null || args[3].isEmpty()) {
                System.err.println("Output file path is not present");
                System.exit(1);
            }
            final Path p1 = Paths.get(inputPath);
            final Path p2 = Paths.get(keywordPath);
            final Path p3 = Paths.get(misspelledPath);
            if(Files.isSameFile(p1,p2))
            {
                System.err.println("Input and keyword File paths provided are equal");
                System.exit(1);

            }
            if(Files.isSameFile(p2,p3))
            {
                System.err.println("Keyword and misspelled File paths provided are equal");
                System.exit(1);
            }
            if(Files.isSameFile(p3,p1))
            {
                System.err.println("Input and Misspelled File paths provided are equal");
                System.exit(1);
            }

            InputDetails inputD = new InputDetails(args[0],args[3],args[1],args[2]);
            AbstractTextDecorator sentenceDecorator = new SentenceDecorator(null,inputD);
            AbstractTextDecorator spellCheckDecorator = new SpellCheckDecorator(sentenceDecorator,inputD);
            AbstractTextDecorator keywordDecorator = new KeywordDecorator(spellCheckDecorator,inputD);
            AbstractTextDecorator mostFreqWordDecorator = new MostFreqWordDecorator(keywordDecorator,inputD);
            mostFreqWordDecorator.processInputDetails();
            ((FileDisplayInterface) inputD).writeToFile();

        }
        catch(AppException msg)
        {
            System.out.println(msg.getMessage());
        }
    }
}
