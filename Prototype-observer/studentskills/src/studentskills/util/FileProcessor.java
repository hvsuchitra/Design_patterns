package studentskills.util;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.File;
import java.io.IOException;
import java.io.FileNotFoundException;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.InvalidPathException;

import java.util.Arrays;
import java.util.Queue;
import java.util.LinkedList;


public final class FileProcessor {
    private BufferedReader reader;
    private Queue<String> words;

    /**
     *
     * @param inputFilePath
     * @throws InvalidPathException
     * @throws SecurityException
     * @throws FileNotFoundException
     * @throws IOException
     */
    public FileProcessor(String inputFilePath)
            throws InvalidPathException, SecurityException, FileNotFoundException, IOException {

        if (!Files.exists(Paths.get(inputFilePath))) {
            throw new FileNotFoundException("invalid input file or input file in incorrect location");
        }

        reader = new BufferedReader(new FileReader(new File(inputFilePath)));
        //System.out.println("in fp" + reader.readLine());
    }

    /**
     * Returns each line of the file
     * @return
     * @throws IOException
     */

    public String poll() throws IOException {
        return reader.readLine();
    }


    public void close() throws IOException {
        reader.close();
    }

    @Override
    public String toString() {
        return "FileProcessor{" +
                "reader=" + reader +
                ", words=" + words +
                '}';
    }
}
