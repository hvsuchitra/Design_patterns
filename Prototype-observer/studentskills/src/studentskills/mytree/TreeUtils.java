package studentskills.mytree;

import studentskills.util.ErrorUtils;

import java.io.IOException;
import java.util.Set;
import java.util.HashSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TreeUtils {
    static int treeId = 0;

    public static int getTreeId() {
        return treeId++;
    }

    /**
     * Parses the input file
     * @param input
     * @return
     * @throws IOException
     */

    public static Request parseInputRequest(String input) throws IOException {
        //System.out.println("parse input"+ input);
        Pattern linePattern = Pattern.compile("[0-9]+:[A-Za-z]+,[A-Za-z]+,[0-9].[0-9],[A-Za-z]+,[A-Za-z0-9]{0,9}");
        Matcher m = linePattern.matcher(input);
        if (m.find()) {
            String fields[] = input.split(":|,");
            int bNumber = Integer.parseInt(fields[0]);
            String firstName = fields[1];
            String lastName = fields[2];
            double gpa = Double.parseDouble(fields[3]);
            String major = fields[4];
            Set<String> skills = new HashSet<String>(10);
            //System.out.println("length of Hashset : "+skills.size());
            for (int i = 5; i < fields.length; i++) {
                skills.add(fields[i]);
            }
            //System.out.println("length of Hashset after adding : "+skills.size());
        /*Iterator<String> i = skills.iterator();
        while (i.hasNext())
            System.out.println("Skils inserted : "+i.next());*/
            Request request = new Request();
            request.setbNumber(bNumber);
            request.setFirstName(firstName);
            request.setLastName(lastName);
            request.setGpa(gpa);
            request.setMajor(major);
            /*need to change*/
            request.setSkills(skills);
            return request;
        }
        else
        {   String errorMsg="input value provided is not valid Format.\n";
            ErrorUtils.getInstance().addError(errorMsg);
            throw new IOException("input value provided is not valid Format.\n " + input);
        }


}

    /**
     * Parses modify text file
     * @param modify
     * @return
     */
    public static Request parseModificationRequest(String modify)
    {
        //System.out.println("parse modify");
        Pattern linePattern = Pattern.compile("[0-2],[0-9]+:[A-Za-z]+,[A-Za-z]+");
        String fields[]=modify.split(":|,");
        int replicaId=Integer.parseInt(fields[0]);
        int bNumber=Integer.parseInt(fields[1]);
        String orignalValue=fields[2];
        String newValue=fields[3];
        Request request = new Request();
        request.setbNumber(bNumber);
        request.setReplicaId(replicaId);
        request.setOriginalValue(orignalValue);
        request.setNewValue(newValue);
        /*System.out.println(request.getbNumber());
        System.out.println(request.getReplicaId());
        System.out.println(request.getOriginalValue());
        System.out.println(request.getNewValue());*/

        return request;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}