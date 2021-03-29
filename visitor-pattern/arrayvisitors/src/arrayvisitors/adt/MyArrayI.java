package arrayvisitors.adt;

public interface MyArrayI extends Iterable<Integer> {
    public boolean insert(int value);
    public boolean delete(int value);
    public boolean deleteAll();
    public boolean contains(int value);
    public int get(int index) throws IndexOutOfBoundsException;
    public int getIndex(int value);
    public boolean isEmpty();
    public int length();
}