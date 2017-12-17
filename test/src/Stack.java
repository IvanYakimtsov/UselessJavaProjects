/**
 * Created by Ivan on 21.11.2017.
 */
public class Stack<T> {
    private Container current;

    public void push(T element) {
        Container container = new Container();
        container.previous = current;
        container.data = element;
        current = container;
    }

    public T peek() {
        if (current != null) return current.data;
        else return null;
    }

    public T pop() {
        if (current != null) {
            T data = current.data;
            current = current.previous;
            return data;
        } else return null;
    }

    public boolean isEmpty() {
        return current == null;
    }

    private class Container {
        Container previous;
        T data;
    }
}
