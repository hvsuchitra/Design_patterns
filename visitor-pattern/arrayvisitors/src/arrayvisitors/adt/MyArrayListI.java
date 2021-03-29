package arrayvisitors.adt;

public interface MyArrayListI extends Iterable<MyArrayI> {
    public boolean add(MyArrayI myArray);
    public boolean contains(MyArrayI myArray);
    public boolean isEmpty();
    public int length();
}