package studentskills.driver;

import studentskills.mytree.TreeHelper;
import studentskills.util.ErrorUtils;
import studentskills.util.Results;

public class Driver {
    private static final int REQUIRED_NUMBER_OF_CMDLINE_ARGS = 7;

    public static void main(String[] args) throws Exception {
        if ((args.length != 7) || (args[0].equals("${input}")) || (args[1].equals("${modify}")) || (args[2].equals("${out1}")) || (args[3].equals("${out2}"))
                || (args[4].equals("${out3}")) || (args[5].equals("${error}")) || (args[6].equals("${debug}"))) {
            System.err.printf("Error: Incorrect number of arguments. Program accepts %d arguments.", REQUIRED_NUMBER_OF_CMDLINE_ARGS);
            System.exit(0);
        }
        try {
            System.out.println("Hello World! Lets get started with the assignment");
            TreeHelper treeHelper = new TreeHelper();

            treeHelper.populateTree(args[0]);
            treeHelper.modifyTree(args[1]);
            ErrorUtils errorUtils=new ErrorUtils(args[5]);

            Results replicaOneResults = new Results(treeHelper.getReplicaOne());
            replicaOneResults.writeToFile(args[2]);
            Results replicaTwoResults = new Results(treeHelper.getReplicaTwo());
            replicaTwoResults.writeToFile(args[3]);
            Results replicaThreeResults = new Results(treeHelper.getReplicaThree());
            replicaThreeResults.writeToFile(args[4]);

            //results = treeHelper.printNodes();
        }
         catch (Exception ex)
            {
                ErrorUtils.getInstance().addError(ex.getMessage());
                ErrorUtils.getInstance().errorFile(args[5]);
                System.err.println("error message"+ ex.getMessage());
            }

    }
}