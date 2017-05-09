import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 08.05.2017.
 */
public class NumberNode implements Node {
    private double number;
    private int depth;

    NumberNode(double number){
        this.number = number;
    }

    @Override
    public int arityOfOperation() {
        return 0;
    }

    @Override
    public String getText(int depth) {
        return String.valueOf(number);
    }

    @Override
    public double getResult() {
        return number;
    }

    @Override
    public boolean isReachable(int depth) {
        return this.depth<depth;
    }

    @Override
    public List<Node> getAdjacentNodes() {
        return new ArrayList<>();
    }

    public int getDepth() {
        return depth;
    }

    public String getTitle() {
        return String.valueOf(number);
    }

    @Override
    public void setDepth(int depth) {
        this.depth = depth;
    }
}
