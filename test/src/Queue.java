/**
 * Created by Ivan on 21.11.2017.
 */
public class Queue<T> {
    Container first;
    Container last;

    public void push(T element) {
        Container container = new Container();
        container.data = element;
        if (first == null) first = container;
        if (last != null) last.next = container;
        last = container;
    }

    public T peek() {
        if (first != null) return first.data;
        else return null;
    }

    public T pop() {
        T data;
        if (first != null) {
            data = first.data;
            first = first.next;
            if(first == null) last = null;
            return data;
        } else return null;
    }

    public boolean isEmpty() {
        return first == null;
    }

    private class Container {
        Container next;
        T data;
    }
}
