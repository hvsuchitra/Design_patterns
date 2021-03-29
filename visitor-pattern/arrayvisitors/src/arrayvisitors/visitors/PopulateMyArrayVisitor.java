package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.util.FileProcessor;
import arrayvisitors.exceptions.AppException;

public class PopulateMyArrayVisitor extends AbstractVisitor {

    private String filePath;
    private FileProcessor fileProcessor;

    public PopulateMyArrayVisitor() {

    }

    public PopulateMyArrayVisitor(String filepath) throws AppException {
        //System.out.println(filepath);
        this.filePath = filepath;
        createFileProcessor();
    }

    private final void createFileProcessor() throws AppException {
        try {
            this.fileProcessor = new FileProcessor(this.filePath);
        } catch(Exception e) {
            throw new AppException("Error in file processor, cannot instantiate PopulateMyArrayVisitor", e);
        }
    }

    public void updateInputFilePath(String filePath) throws AppException {
        this.filePath = filePath;
        createFileProcessor();
    }

    /**
     * Reads file and inserts to an array
     * @param myArray
     * @return boolean
     * @throws AppException when the input is invalid
     */

    @Override
    public boolean visit(MyArrayI myArray) throws AppException {
        if(this.fileProcessor != null) {
            String input = "";
            try {
                while((input = fileProcessor.poll()) != null) {
                    int value = Integer.parseInt(input);
                    myArray.insert(value);
                }
                //System.out.println(myArray);
                fileProcessor.close();
                return true;
            } catch (NumberFormatException e) {
                throw new AppException("cannot convert: " + input + " to an Integer", e);
            } catch (Exception e) {
                throw new AppException("Error in file processor", e);
            }
        }
        return false;
    }

    @Override
    public String toString() {
        return "PopulateMyArrayVisitor{" +
                "filePath='" + filePath + '\'' +
                ", fileProcessor=" + fileProcessor +
                '}';
    }
}