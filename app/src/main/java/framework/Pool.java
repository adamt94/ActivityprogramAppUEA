package framework;
import java.util.ArrayList;
import java.util.List;

/**
 * Generic class used globally to create factories of objects
 * @param <T> Type of object
 */
public class Pool<T> {
    /**
     * Create specified object
     * @param <T> Type of object
     */
    public interface PoolObjectFactory<T> {
        public T createObject();
    }

    /**
     * List of free objects
     */
    private final List<T> freeObjects;

    /**
     * Factory object of type T
     **/
    private final PoolObjectFactory<T> factory;

    /**
     * Maximum number of objects to be created
     */
    private final int maxSize;

    /**
     * Type: Constructor
     * Pool constructor
     * @param factory to use
     * @param maxSize maximum number of elements
     */
    public Pool(PoolObjectFactory<T> factory, int maxSize) {
        this.factory = factory;
        this.maxSize = maxSize;
        this.freeObjects = new ArrayList<T>(maxSize);
    }

    /**
     * Type: Allocate
     * If number of freeObjects is 0 creates new object and returns
     * else returns object from free object
     * @return T object type
     */
    public T newObject() {
        T object = null;

        if (freeObjects.size() == 0)
            object = factory.createObject();
        else
            object = freeObjects.remove(freeObjects.size() - 1);

        return object;
    }

    /**
     * Type: Free
     * If space is available adds the object to the freeObjects list
     * @param object
     */
    public void free(T object) {
        if (freeObjects.size() < maxSize)
            freeObjects.add(object);
    }
}
