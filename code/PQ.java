package code;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PQ<T> {
    // A PriorityQueue with a custom comparator
    private PriorityQueue<Wrapper<T>> queue;

    // Constructor
    public PQ() {
        // Min-heap based on the key
        queue = new PriorityQueue<>(Comparator.comparingInt(Wrapper::getKey));
    }

    // Add an object with a key
    public void add(T object, int key) {
        queue.add(new Wrapper<>(object, key));
    }

    // Retrieve and remove the object with the lowest key
    public T poll() {
        Wrapper<T> wrapper = queue.poll();
        return wrapper != null ? wrapper.getObject() : null;
    }

    // Retrieve but do not remove the object with the lowest key
    public T peek() {
        Wrapper<T> wrapper = queue.peek();
        return wrapper != null ? wrapper.getObject() : null;
    }

    // Check if the queue is empty
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    // Get the size of the queue
    public int size() {
        return queue.size();
    }

    // Wrapper class to associate objects with keys
    private static class Wrapper<T> {
        private final T object;
        private final int key;

        public Wrapper(T object, int key) {
            this.object = object;
            this.key = key;
        }

        public T getObject() {
            return object;
        }

        public int getKey() {
            return key;
        }
    }
}
