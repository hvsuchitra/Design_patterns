package arrayvisitors.util;

import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface FileDisplayInterface {
    void writeToFile(String path, Set<Integer> commonInts) throws IOException;
    void writeToFile(String path, List<Integer> missingInts) throws IOException;
}