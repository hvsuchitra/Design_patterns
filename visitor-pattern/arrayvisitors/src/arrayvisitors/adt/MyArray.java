package arrayvisitors.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.VisitorI;
import arrayvisitors.exceptions.AppException;
import arrayvisitors.visitors.AbstractElement;

/**
 *MyArray class will implement MyArrayI and stores the values from the  input file
 */
public class MyArray extends AbstractElement implements MyArrayI, Cloneable {

    private int[] numbers;
    private int capacity;
    private int index;
    private int length;
    private final static int INITIAL_CAPACITY = 10;

    public MyArray() {
       // System.out.println("array obkject");
        this(INITIAL_CAPACITY);
        MyLogger.getInstance().writeMessage("Constructor MyArray ", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    /**
     * Sets initial capacity,index and length values of an array
     * @param capacity
     */
    public MyArray(int capacity) {
        //System.out.println("array cap");
        this.capacity = capacity > 0 ? capacity : INITIAL_CAPACITY;
        numbers = new int[this.capacity];
        index = -1;
        length = 0;
    }

    public MyArray(int[] numbers) {
        this(numbers.length);
       //System.out.println("array obkject");
        for(int number : numbers)
            insertElement(number);
    }

    private MyArray(MyArray myArray) {
        this(myArray.capacity);
        for(int number : myArray)
            insertElement(number);
        //System.out.println("array nums");
        //System.out.println(numbers);
    }

    /**
     * Stores each integer value from input file to an array
     * @param value
     * @return boolean
     */
    @Override
    public boolean insert(int value) {
        return insertElement(value);
    }

    private final boolean insertElement(int value) {
        if (length >= capacity) {
            ensureCapacity();
        }
        numbers[++index] = value;
        incLength();
        return true;
    }

    @Override
    public boolean delete(int value) {
        if (contains(value)) {
            int index = getIndex(value);
            for(int i = index + 1; i < length; i++) {
                numbers[index++] = numbers[i];
            }
            --this.index;
            decLength();
        }
        return false;
    }

    @Override
    public boolean deleteAll() {
        index = -1;
        length = 0;
        return true;
    }

    /**
     * Checks if the the value is present in an array
     * @param value
     * @return boolean
     */
    @Override
    public boolean contains(int value) {
        for(int number : this) {
            return number == value;
        }
        return false;
    }

    /**
     * Returns the value at particular index
     * @param index
     * @return value of index
     * @throws IndexOutOfBoundsException
     */
    @Override
    public int get(int index) throws IndexOutOfBoundsException {
        if (index > -1 && index <= this.index) {
            return numbers[index];
        }

        throw new IndexOutOfBoundsException(index);
    }

    /**
     * Returns Index value of an array
     * @param value
     * @return int index
     */
    @Override
    public int getIndex(int value) {
        for(int index = 0; index < length; index++) {
            if (numbers[index] == value)
                return index;
        }
        return -1;
    }

    @Override
    public int length() {
        return length;
    }

    @Override
    public boolean isEmpty() {
        return length == 0;
    }

    /**
     * Accept method calls Visitor method in Visitor
     * @param visitor
     * @return boolean
     * @throws AppException
     */

    @Override
    public boolean accept(VisitorI visitor) throws AppException {
       return visitor.visit(this);
    }

    /**
     *
     */

    private final void ensureCapacity() {
        capacity = capacity + (capacity / 2);
        int[] newNumbers = new int[capacity];
        int tempIndex = 0;
        for(int number : this) {
            newNumbers[tempIndex++] = number;
        }

        this.numbers = newNumbers;
    }

    private int incLength() {
        return ++length;
    }

    private int decLength() {
        return --length;
    }

    @Override
    protected void finalize() throws Throwable {

    }

    @Override
    public MyArrayI clone() throws CloneNotSupportedException {
        return isEmpty() ? new MyArray() : new MyArray(this);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        if (!isEmpty()) {
            out.append("[");
            for (int number : this)
                out.append(number).append(",");

            out.deleteCharAt(out.length() - 1);
            out.append("]");
        }
        return out.toString();
    }

    @Override
    public Iterator<Integer> iterator() {
        return new Iterator<Integer>(){

            private int iter = 0;

            @Override
            public boolean hasNext() {
                return iter <= index;
            }

            @Override
            public Integer next() {
                if(!hasNext())
                    throw new NoSuchElementException();

                return get(iter++);
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}