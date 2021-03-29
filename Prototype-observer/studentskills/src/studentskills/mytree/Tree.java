package studentskills.mytree;

import studentskills.mytree.TreeUtils;
import studentskills.mytree.StudentRecord;

import java.util.List;

/**
 * Tree insert and search operations
 *
 */

public class Tree{
    private final int treeId;
    private StudentRecord root;
    public Tree()
    {
        TreeUtils treeUtils = new TreeUtils();
        treeId=treeUtils.getTreeId();
        System.out.println("Tree Id  "+ treeId);
    }
    void insert(StudentRecord record)
    {
        //System.out.println("in insert");
        root=recursiveInsert(root,record);

    }

    /**
     *
     * @param root
     * @param record
     * @return
     */
    public StudentRecord recursiveInsert(StudentRecord root,StudentRecord record)
    {
        //System.out.println("in recursive insert");
        if(root==null)
        {
            //System.out.println("root is "+record.getbNumber());
            root=record;
            return root;
        }
       if(record.getbNumber()<root.getbNumber())
        {

            root.left=recursiveInsert(root.getLeft(), record);

        }
       else
       {
           if(record.getbNumber()>root.getbNumber())
           {

               root.right=recursiveInsert(root.getRight(), record);

           }

       }
       return root;
    }

    /**
     *
     * @param bNumber
     * @return
     */
    public StudentRecord search(int bNumber) {
        //System.out.println("in search "+ bNumber);
        return recursiveSearch(root, bNumber);
        //return root;
    }
    private StudentRecord recursiveSearch(StudentRecord root,int bNumber)
    {
        if(root==null || root.getbNumber() == bNumber)
        {
            return root;
        }
        if(root.getbNumber() > bNumber)
        {
            return recursiveSearch(root.getLeft(),bNumber);
        }
        else
        {
            return recursiveSearch(root.getRight(),bNumber);
        }

    }

    /**
     *
     * @param records
     */

    public void addToListInOrder(List<StudentRecord> records)
    {   System.out.println("\nReplica Trees\n");
        inOrder(root, records);
    }

    public void inOrder()
    {
        inOrder(root, null);
    }

    /**
     *
     * @param root
     * @param records
     */
    private void inOrder(StudentRecord root, List<StudentRecord> records)
    {
        if(root!=null)
        {
            inOrder(root.getLeft(), records);
            System.out.print(root.getbNumber()+":"+root.getSkills()+"\n");
            if(records != null) records.add(root);
            inOrder(root.getRight(), records);
        }
    }
    public int getTreeId() {
        return treeId;
    }

    @Override
    public String toString() {
        return "Tree{" +
                "treeId=" + treeId +
                ", root=" + root +
                '}';
    }
}