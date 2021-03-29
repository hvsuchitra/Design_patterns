package arrayvisitors.visitors;

import arrayvisitors.adt.MyArrayI;
import arrayvisitors.adt.MyArrayListI;
import arrayvisitors.util.Results;

public abstract class AbstractVisitor implements VisitorI {
    @Override
    public boolean visit(MyArrayI myArray) throws RuntimeException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Results visit(MyArrayListI myArrayList, Results results) throws RuntimeException {
        throw new UnsupportedOperationException();
    }
}