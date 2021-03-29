package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.adt.MyArrayI;
import arrayvisitors.util.Results;

import java.util.Set;
import java.util.HashSet;

public class CommonIntsVisitor extends AbstractVisitor {

    private Set<Integer> distinctInts;
   // Results results=new Results();

    public CommonIntsVisitor() {
        this.distinctInts = new HashSet<Integer>();
    }

    /**
     * Calculates commonInts of the two files
     * @param myArrayList
     * @param results
     * @return CommonInts stored in Results object
     */
    @Override
    public Results visit(MyArrayListI myArrayList, Results results) {
        for(MyArrayI myArray : myArrayList) {
            if(distinctInts.isEmpty()) {
                for(int number : myArray) {
                    distinctInts.add(number);
                }
            } else {
                for(int number : myArray) {
                    if(distinctInts.contains(number))
                        results.addToSet(number);
                }
            }
        }
        //System.out.println(distinctInts);
        //System.out.println("common ints"+results.getCommonInts());
        return results;
    }


}