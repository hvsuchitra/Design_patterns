package studentskills.mytree;

import studentskills.mytree.Request;
import studentskills.mytree.ObserverI;
import studentskills.mytree.SubjectI;
import java.lang.Cloneable;
import java.util.*;

/**
 * StudentRecord class implements ObserverI,SubjectI and Cloneable interfaces
 * and assignes values to each field.
 */
public class StudentRecord implements ObserverI,SubjectI,Cloneable
{
    private int bNumber;
    private String firstName;
    private String lastName;
    private double gpa;
    private String major;
    private Set<String> skills;
    Request request;
    //List<objectI>
    List<ObserverI> observers = new ArrayList<ObserverI>();
    public StudentRecord left;
    public StudentRecord right;
    public StudentRecord()
    {
        //System.out.println("in student record ");

    }
    public StudentRecord(StudentRecord sRecord)
    {
        //System.out.println("in student record constructor");
        //System.out.println("bnum "+ sRecord.bNumber);
        this.bNumber=sRecord.getbNumber();
        this.firstName=sRecord.getFirstName();
        this.lastName=sRecord.getLastName();
        this.gpa=sRecord.getGpa();
        this.major=sRecord.getMajor();
        this.skills=new HashSet<String>();
        //skills.addAll(sRecord.getSkills());
        this.left=null;
        this.right=null;
        for(String skill : sRecord.getSkills())
        {
            skills.add(skill);
        }
        /*Iterator<String> i = skills.iterator();
        while (i.hasNext())
            System.out.println("Skils inserted in student record : "+i.next());*/
    }

    /**
     * clone function Clones the StudentRecord
     * @return StudentRecord
     * @throws CloneNotSupportedException
     */

    protected StudentRecord clone() throws CloneNotSupportedException {
        //System.out.println("in clone");
        return new StudentRecord(this);
    }

    /**
     * ModifyNode Updates studentRecord fields with new values
     * @param request
     * @param operations
     */

    public void modifyNode(Request request,Operations operations)
    {
        //System.out.println("Node to be modified");
        String insert ="INSERT";

        if(operations==Operations.INSERT)
        {

            //System.out.println("in INSERT operation"+ this.firstName);
            this.firstName = request.getFirstName();
            //System.out.println("after INSERT operation"+ this.firstName);
            //System.out.println("before");
            this.lastName = request.getLastName();
            this.gpa = request.getGpa();
            this.major = request.getMajor();
            //this.skills = request.getSkills();
            //System.out.println("Skils student record : "+ this.getSkills() + " " + request.getSkills());
            this.skills.addAll(request.getSkills());//new HashSet<String>();
            //System.out.println("Skils student record : "+ this.getSkills());
            /*Iterator<String> i = skills.iterator();
            while (i.hasNext())
                System.out.println("Skils inserted in student record : "+i.next() + " "+ request.getSkills());

           /* for(String skill : skills)
            {
                this.skills.add(skill);
            }

            Iterator<String> i = skills.iterator();
            while (i.hasNext())
                System.out.println("Skils inserted in student record : "+i.next());*/

            notifyAll(operations);//define this
        }
        if(operations==Operations.MODIFY)
        {
            //System.out.println("in modify operation "+ getSkills());
            if(request.getOriginalValue().equalsIgnoreCase(getFirstName()))
            {
                this.firstName=request.getNewValue();
                //System.out.println("first name"+this.firstName + request.getNewValue());
                notifyAll(operations);
            }
            if(request.getOriginalValue().equalsIgnoreCase(getLastName()))
            {
                //System.out.println("lastname");
                this.lastName=request.getNewValue();
                notifyAll(operations);
            }
            if(request.getOriginalValue().equalsIgnoreCase(getMajor()))
            {
                this.major=request.getNewValue();
                notifyAll(operations);
            }
            if(request.getOriginalValue().contains("Skill"))
            {  // System.out.println("skill");

                if(this.skills.contains(request.getOriginalValue()))
                {
                    this.skills.remove(request.getOriginalValue());
                    this.skills.add(request.getNewValue());
                }
                /*Iterator<String> i = getSkills().iterator();
                while (i.hasNext())
                    System.out.println("Skills modified in student record : "+i.next());*/
               // System.out.println("Skills modified in student record : "+this.skills);
                notifyAll(operations);
            }

        }


    }

    /**
     * NotifyAll Method notifies each observers for Update
     * @param operation
     */
    @Override
    public void notifyAll(Operations operation)
    {
        //System.out.println(this.major);
        for(ObserverI observer : observers)
            observer.update(operation, this);
    }

    /**
     *
     * @param op
     * @param sRecord
     */

    @Override
    public void update(Operations op, StudentRecord sRecord)
    {
     //copy all the fields from sRecord to current student record except left, right, observers.
        //System.out.println("Update all"+ this.firstName + sRecord.getFirstName());
        this.firstName = sRecord.getFirstName();
        this.lastName = sRecord.getLastName();
        this.major=sRecord.getMajor();
       // System.out.println("to be updated "+this.skills);
        //System.out.println("request updated "+request.getSkills());
        Set<String> newSkill= new HashSet<>();
        newSkill.addAll(sRecord.getSkills());
        this.skills=newSkill;
        //this.skills.removeAll(sRecord.getSkills());
        //System.out.println("updated "+this.skills);
       /* this.skills=new HashSet<>();
        for(String skill : sRecord.getSkills())
        {
            skills.add(skill);
        }*/

    }

    public int getbNumber() {
        return bNumber;
    }

    public void setbNumber(int bNumber) {
        this.bNumber = bNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public String getMajor() {
        return major;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set skills) {
        this.skills = skills;
    }

    public StudentRecord getLeft() {
        return left;
    }

    public void setLeft(StudentRecord left) {
        this.left = left;
    }

    public StudentRecord getRight() {
        return right;
    }

    public void setRight(StudentRecord right) {
        this.right = right;
    }

    public String toString(){
        return getbNumber()+":"+getSkills()+"\n";
    }

}