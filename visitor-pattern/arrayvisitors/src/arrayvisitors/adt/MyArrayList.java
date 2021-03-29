package arrayvisitors.adt;

import java.util.Iterator;
import java.util.NoSuchElementException;

import arrayvisitors.util.MyLogger;
import arrayvisitors.visitors.VisitorI;
import arrayvisitors.exceptions.AppException;
import arrayvisitors.util.Results;
import arrayvisitors.visitors.AbstractElement;

/**
 * Class MyArrayList implements MyArrayList and stores
 * the values of both the  input File in the LinkedList
 */
public class MyArrayList extends AbstractElement implements MyArrayListI, Cloneable {

    private Node head = null;
    private Node last = null;
    private int size = 0;

    /**
     * LinkedList implementation
     */
    private class Node {
        private MyArrayI myArray;
        private Node prev;
        private Node next;

        public Node(MyArrayI myArray) {
            this(myArray, null, null);
        }

        public Node(MyArrayI myArray, Node prev, Node next) {
            this.myArray = myArray;
            this.prev = prev;
            this.next = next;
        }

        public Node setPrev(Node prev) {
            this.prev = prev;
            return this;
        }

        public Node setNext(Node next) {
            this.next = next;
            return this;
        }

        public Node getNext() {
            return this.next;
        }

        public Node getPrev() {
            return this.prev;
        }

        public MyArrayI getMyArray() {
            return myArray;
        }
    }

    public MyArrayList() {
        MyLogger.getInstance().writeMessage("Constructor MyArrayList ", MyLogger.DebugLevel.CONSTRUCTOR);
    }

    public MyArrayList(MyArrayI myArray) {
        this.head = this.last = new Node(myArray);
        this.size = this.head == null ? this.size : incLength();
    }

    private MyArrayList(MyArrayList myArrayList) throws CloneNotSupportedException {
        for(MyArrayI myArray : myArrayList) {
            addElement(((MyArray) myArray).clone());
        }
    }


    @Override
    public boolean add(MyArrayI myArray) {
        return addElement(myArray);
    }

    /**
     * AddElement function inserts the both the values of two flies to the list
     * @param myArray
     * @return boolean
     */

    private final boolean addElement(MyArrayI myArray) {
        if (isEmpty() && myArray != null) {
            this.head = this.last = new Node(myArray);
            incLength();
        } else if (myArray != null) {
            Node newNode = new Node(myArray);
            newNode.setPrev(last);
            last.setNext(newNode);
            last = last.getNext();
            incLength();
        }
        return false;
    }

    @Override
    public boolean contains(MyArrayI myArray) {
        if (isEmpty() || myArray == null)
            return false;

        for(MyArrayI myArrayObj : this) {
            if (myArrayObj.equals(myArray))
                return true;
        }
        return false;
    }

    @Override
    public boolean isEmpty() {
        return head == null;
    }

    @Override
    public int length() {
        return size;
    }

    @Override
    public Results accept(VisitorI visitor, Results results) throws AppException {
        return visitor.visit(this, results);
    }

    private int incLength() {
        return ++size;
    }

    private int decLength() {
        return --size;
    }

    @Override
    protected void finalize() throws Throwable {

    }

    // Does Deep Clone
    @Override
    public MyArrayListI clone() throws CloneNotSupportedException {
        return isEmpty() ? new MyArrayList() : new MyArrayList(this);
    }

    @Override
    public String toString() {
        StringBuilder out = new StringBuilder();
        if (!isEmpty()) {
            out.append("[");
            int iter = 0;
            for (MyArrayI myArray : this) {
                out.append("[").append(iter++).append(",").append(myArray.toString()).append("]").append(",");
            }
            out.deleteCharAt(out.length() - 1);
            out.append("]");
        }
        return out.toString();
    }

    @Override
    public Iterator<MyArrayI> iterator() {
        return new Iterator<MyArrayI>() {
            private Node currNode = head;

            @Override
            public boolean hasNext() {
                return currNode != null;
            }

            @Override
            public MyArrayI next() {
                if(!hasNext())
                    throw new NoSuchElementException();

                MyArrayI retArray = currNode.getMyArray();
                currNode = currNode.getNext();
                return retArray;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException();
            }
        };
    }
}