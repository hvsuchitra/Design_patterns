package studentskills.mytree;

import java.util.HashSet;
import java.util.Set;

public class Request{
    private int bNumber;
    private String firstName;
    private String lastName;
    private double gpa;
    private String major;
    private Set skills; //=new HashSet<String>();

    private int replicaId;
    private String originalValue;
    private String newValue;
    /*public Request(int bNumber,String firstName,String lastName,double gpa,String major,Set skills)
    {
        this.bNumber=bNumber;
        this.firstName=firstName;
        this.lastName=lastName;
        this.gpa=gpa;
        this.major=major;
        this.skills=skills;
        System.out.println("in Request");
    }*/

    //System.out.println("in Request");
    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public int getbNumber()
    {
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

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }

    public Set<String> getSkills() {
        return skills;
    }

    public void setSkills(Set skills) {
        this.skills = skills;
    }

    public void setNewValue(String newValue) {
        this.newValue = newValue;
    }

    public String getNewValue() {
        return newValue;
    }

    public String getOriginalValue() {
        return originalValue;
    }

    public void setOriginalValue(String originalValue) {
        this.originalValue = originalValue;
    }

    public int getReplicaId() {
        return replicaId;
    }

    public void setReplicaId(int replicaId) {
        this.replicaId = replicaId;
    }

    @Override
    public String toString() {
        return "Request{" +
                "bNumber=" + bNumber +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gpa=" + gpa +
                ", major='" + major + '\'' +
                ", skills=" + skills +
                ", replicaId=" + replicaId +
                ", originalValue='" + originalValue + '\'' +
                ", newValue='" + newValue + '\'' +
                '}';
    }
}