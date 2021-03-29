package studentskills.mytree;

import studentskills.util.FileProcessor;
import studentskills.util.MyLogger;
import studentskills.util.Results;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 * Creates tree objects and Reads input and modify files.
 */
public class TreeHelper{
    private Tree replicaOne;
    private Tree replicaTwo;
    private Tree replicaThree;
    //public int bNumber;
    //public String firstName;
    HashMap<Integer,String> idNameMap =new HashMap<Integer, String>();
    StudentRecord newRecord;
    StudentRecord newRecordClone1;
    StudentRecord newRecordClone2;
    private Operations operations;

    //public Map<bNumber, firstName> idNameMap;
    public TreeHelper() {
        this.replicaOne = new Tree();
        this.replicaTwo = new Tree();
        this.replicaThree = new Tree();
    }

    public Tree getReplicaOne() {
        return replicaOne;
    }

    public Tree getReplicaTwo() {
        return replicaTwo;
    }

    public Tree getReplicaThree() {
        return replicaThree;
    }


    public void populateTree(String filePath) throws FileNotFoundException,IOException,CloneNotSupportedException
    {    MyLogger.setDebugValue(3);
        String line;
        //TreeUtils treeUtils = new TreeUtils();
        //System.out.printf("Filepath" + filePath);
        FileProcessor fileProcessor = new FileProcessor(filePath);
        while((line=fileProcessor.poll())!=null)
        {
            //System.out.println("Treehelper");
            Request request=TreeUtils.parseInputRequest(line);
            insertIntoTree(request);
        }
        //MyLogger.writeMessage("\nafter Insert Tree\n", MyLogger.DebugLevel.INSERT_NODE);
        //MyLogger.writeMessage("\nReplica One\n", MyLogger.DebugLevel.INSERT_NODE);
        //replicaOne.inOrder();
        //MyLogger.writeMessage("\nReplica Two\n", MyLogger.DebugLevel.INSERT_NODE);
        //replicaTwo.inOrder();
        //MyLogger.writeMessage("\nReplica Three\n", MyLogger.DebugLevel.INSERT_NODE);
        //replicaThree.inOrder();

    }
    public void insertIntoTree(Request request) throws CloneNotSupportedException
    {

        //System.out.println("map" +idNameMap);
        if(idNameMap.containsKey(request.getbNumber()))
        {
            //System.out.println(request.getbNumber() +" bNumber already exists and it name is "+request.getFirstName());
            StudentRecord existingRecord = replicaOne.search(request.getbNumber());
            //System.out.println("serchedf bNumber"+existingRecord.getbNumber());
            existingRecord.modifyNode(request,Operations.INSERT);
        }
        else
        {
            //System.out.println("new bNumber"+request.getbNumber());

            idNameMap.put(request.getbNumber(), request.getFirstName());
            //System.out.println("after idnamemap "+idNameMap);
            newRecord = new StudentRecord();
            newRecord.setbNumber(request.getbNumber());
            newRecord.setFirstName(request.getFirstName());
            newRecord.setLastName(request.getLastName());
            newRecord.setGpa(request.getGpa());
            newRecord.setMajor(request.getMajor());
            newRecord.setSkills(request.getSkills());
            //System.out.println("after sr bject");
             newRecordClone1 = newRecord.clone();
             newRecordClone2 = newRecord.clone();
            newRecord.observers.add(newRecordClone1);
            newRecord.observers.add(newRecordClone2);
            newRecordClone1.observers.add(newRecord);
            newRecordClone1.observers.add(newRecordClone2);
            newRecordClone2.observers.add(newRecord);
            newRecordClone2.observers.add(newRecordClone1);
            //System.out.println("before insert");
            replicaOne.insert(newRecord);
            replicaTwo.insert(newRecordClone1);
            replicaThree.insert(newRecordClone2);
            //System.out.println("\nreplica three");
            //replicaThree.inOrder(newRecordClone2);
            /*for (int i=0;i<newRecord.observers.size();i++)
            {
                System.out.println("observers nr " +newRecord.observers.get(i));
            }*/
        }
        //System.out.println("map" +idNameMap);



    }

    public void modifyTree(String path) throws FileNotFoundException,IOException,CloneNotSupportedException
    {
        String line;
        //TreeUtils treeUtils = new TreeUtils();
        FileProcessor fileProcessor = new FileProcessor(path);
        while((line=fileProcessor.poll())!=null)
        {
            //System.out.println("\nModifyfile");
            Request request=TreeUtils.parseModificationRequest(line);
            if(request.getReplicaId() == replicaOne.getTreeId())
            {  // System.out.println("before search");
               //modifyHelper(request);
                StudentRecord record = replicaOne.search(request.getbNumber());
                if(record != null)
                {
                    //System.out.println("record is not null");
                    record.modifyNode(request,Operations.MODIFY);

                }

            }
           else if(request.getReplicaId() == replicaTwo.getTreeId())
            {
                StudentRecord record = replicaTwo.search(request.getbNumber());
                if(record != null) {
                    //System.out.println("record is not null");
                    record.modifyNode(request, Operations.MODIFY);
                }

            }
           else
            {
                if(request.getReplicaId() == replicaThree.getTreeId())
                {
                    StudentRecord record = replicaThree.search(request.getbNumber());
                    if(record != null) {
                        //System.out.println("record is not null");
                        record.modifyNode(request, Operations.MODIFY);
                    }
                }
            }
        }
       // MyLogger.setDebugValue(4);
       // MyLogger.writeMessage("\nAfter updating details Modify.txt values\n", MyLogger.DebugLevel.MODIFY_NODE);
       // System.out.println("after mylogger\n");
        //MyLogger.writeMessage("\nAfter ReplicaOne\n", MyLogger.DebugLevel.MODIFY_NODE);
        //replicaOne.inOrder();
        //MyLogger.writeMessage("\nAfter ReplicaTwo\n", MyLogger.DebugLevel.MODIFY_NODE);
        //replicaTwo.inOrder();
        //MyLogger.writeMessage("\nAfter ReplicaThree\n", MyLogger.DebugLevel.MODIFY_NODE);
        //replicaThree.inOrder();
    }

   /* public List<Results> printNodes()
    {
        System.out.println("in printnode");
        List<Results> resultsList = new ArrayList<Results>();
        //resultsList.add();
        System.out.println(resultsList);
        Results rsReplicaOne = new Results();
        //replicaOne.inOrder();

    }*/

    @Override
    public String toString() {
        return "TreeHelper{" +
                "replicaOne=" + replicaOne +
                ", replicaTwo=" + replicaTwo +
                ", replicaThree=" + replicaThree +
                ", idNameMap=" + idNameMap +
                ", newRecord=" + newRecord +
                ", newRecordClone1=" + newRecordClone1 +
                ", newRecordClone2=" + newRecordClone2 +
                ", operations=" + operations +
                '}';
    }
}