package arrayvisitors.driver;

import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.exceptions.AppException;
import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.VisitorI;
import arrayvisitors.visitors.CommonIntsVisitor;
import arrayvisitors.visitors.ElementI;
import arrayvisitors.visitors.MissingIntsVisitor;
import arrayvisitors.visitors.PopulateMyArrayVisitor;
import arrayvisitors.adt.MyArray;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayList;
import arrayvisitors.util.Results;

import java.io.IOException;

public class Driver {
    private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 5;

    public static void main(String[] args) throws AppException, IOException {
        if ((args.length != 5) || (args[0].equals("${input1}")) || (args[1].equals("${input2}")) || (args[2].equals("${commonintout}")) || (args[3].equals("${missingintout}"))
                || (args[4].equals("${debug}"))) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
            System.exit(0);
        }
        try {

            Integer number = Integer.parseInt(args[4]);
            MyLogger.getInstance().setDebugValue(number);
            VisitorI populateMyArrayVisitor = new PopulateMyArrayVisitor(args[0]);
            MyArrayI myArray1 = new MyArray();
            ((ElementI) myArray1).accept(populateMyArrayVisitor);

            ((PopulateMyArrayVisitor) populateMyArrayVisitor).updateInputFilePath(args[1]);
            MyArrayI myArray2 = new MyArray();
            ((ElementI) myArray2).accept(populateMyArrayVisitor);

            MyArrayListI myArrayList = new MyArrayList();
            myArrayList.add(myArray1);
            myArrayList.add(myArray2);

            Results commonIntResults = new Results();
            VisitorI commonIntsVisitor = new CommonIntsVisitor();
            ((ElementI) myArrayList).accept(commonIntsVisitor, commonIntResults);

            Results missingIntResults = new Results();
            VisitorI missingIntsVisitor = new MissingIntsVisitor();
            ((ElementI) myArrayList).accept(missingIntsVisitor, missingIntResults);


            commonIntResults.writeCommonIntsToFile(args[2]);
            missingIntResults.writeMissingIntsToFile(args[3]);
            commonIntResults.CommonIntsToStdout();
            missingIntResults.MissingIntsToStdout();
        }
        catch (AppException msg) {
            System.out.println(msg.getMessage());
        }

    }
}