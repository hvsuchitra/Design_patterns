package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

import java.util.Set;
import java.util.HashSet;

public class MissingIntsVisitor extends AbstractVisitor {


    private Set<Integer> distinctInts;

    public MissingIntsVisitor() {
        this.distinctInts = new HashSet<Integer>();
    }

    /**
     * Calculates MissingInts in the files
     * @param myArrayList
     * @param results
     * @return MissingInts stored in Results object
     */
    @Override
    public Results visit(MyArrayListI myArrayList, Results results) {
        for(MyArrayI myArray : myArrayList) {
            if(!distinctInts.isEmpty())
                distinctInts.clear();

            for(int number : myArray)
                    distinctInts.add(number);
                    
            for(int i = 0; i < 100; i++) {
                if(!distinctInts.contains(i))
                    results.addToList(i);
            }
        }
       // System.out.println("missing ints"+results.getMissingInts());
        return results;   
    }

    @Override
    public String toString() {
        return "MissingIntsVisitor{" +
                "distinctInts=" + distinctInts +
                '}';
    }
}