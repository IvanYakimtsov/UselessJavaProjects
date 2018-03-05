import java.util.ArrayDeque;

public class ArrayClassTest {
    ArrayDeque<Integer> arrayDeque = new ArrayDeque<>();
    public ArrayClassTest(){
        arrayDeque.push(1);
        arrayDeque.push(2);
        arrayDeque.push(3);
    }

    public ArrayDeque<Integer> getArrayDeque() {
        return arrayDeque;
    }
}
