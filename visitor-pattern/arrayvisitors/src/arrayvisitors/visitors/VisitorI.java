package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

public interface VisitorI {
    public boolean visit(MyArrayI myArray);
    public Results visit(MyArrayListI myArrayList, Results results);
}