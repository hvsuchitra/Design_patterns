package studentskills.mytree;

/**
 * ObserverI interface declares Update method which is implemented by StudentRecords
 */
public interface ObserverI {
     abstract void update(Operations op, StudentRecord sRecord);
}