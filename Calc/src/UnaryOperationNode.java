import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 08.05.2017.
 */
public class UnaryOperationNode implements Node {
    private Node operator;
    private int depth;
    private String operation;

    UnaryOperationNode(String operation) {
        this.operation = operation;
    }


    @Override
    public int arityOfOperation() {
        return 1;
    }

    @Override
    public String getText(int depth) throws CalculationException {
        if (operator.isReachable(depth)) {
            return operator.getText(depth) + operation;
        } else
            return String.valueOf(getResult());


    }

    @Override
    public double getResult() throws  CalculationException{
        switch (operation) {
            case "!":
                Double result;
                if(operator.getResult() % 1 != 0) throw new CalculationException("ошибка при подсчете факториала");
                 else result = operator.getResult();
                return FactorialUtil.factorial(result.intValue());
            case "%":
                return operator.getResult()/100;

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


    @Override
    public void setDepth(int depth) {
        this.depth = depth;
    }
}
