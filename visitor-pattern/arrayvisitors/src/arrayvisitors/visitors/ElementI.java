package arrayvisitors.visitors;

import arrayvisitors.util.Results;

public interface ElementI {
    public boolean accept(VisitorI visitor);
    public Results accept(VisitorI visitor, Results results);
}