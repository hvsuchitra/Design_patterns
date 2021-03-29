package arrayvisitors.visitors;

import arrayvisitors.util.Results;

public abstract class AbstractElement implements ElementI {

    @Override
    public boolean accept(VisitorI visitor) throws RuntimeException {
        throw new UnsupportedOperationException();
    }

    @Override
    public Results accept(VisitorI visitor, Results results) throws RuntimeException {
        throw new UnsupportedOperationException();
    }
}