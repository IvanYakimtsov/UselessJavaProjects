import java.util.ArrayDeque;
import java.util.Stack;

public class test {
    public static void main(String[] args) {
        ArrayClassTest arrayClassTest = new ArrayClassTest();
        ArrayDeque<Integer> e = arrayClassTest.getArrayDeque();
        e.push(4);
        System.out.println(e.peek());
        System.out.println(arrayClassTest.getArrayDeque().peek());
    }

}
