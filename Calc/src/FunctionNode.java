import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 08.05.2017.
 */
public class FunctionNode implements Node {
    private Node operator;
    private int depth;
    private String operation;

    FunctionNode(String operation) {
        this.operation = operation;
    }


    @Override
    public int ArityOfOperation() {
        return 1;
    }

    @Override
    public String getText(int depth) throws CalculationException{
        if (operator.isReachable(depth)) {
            return operation + "(" + operator.getText(depth) + ")";
        } else
            return String.valueOf(getResult());


    }

    @Override
    public double getResult() throws CalculationException{
        switch (operation) {
            case "log":
                return Math.log10(operator.getResult());
            case "ln":
                return Math.log(operator.getResult()/100);

            case "sqrt":
                return Math.sqrt(operator.getResult());

            default: return 0;
        }
    }

    @Override
    public boolean isReachable(int depth) {
        return this.depth < depth;
    }

    @Override
    public List<Node> getAdjacentNodes() {
        List<Node> adjacentNodes =  new ArrayList<>();
        adjacentNodes.add(operator);
        return adjacentNodes;
    }

    public void setOperators(Node operator) {
        this.operator = operator;
    }

    public String getTitle() {
        return operation;
    }
}
