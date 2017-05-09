package com.ivan.calculator.calculatorData.graphNodes;

import com.ivan.calculator.CalculationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 08.05.2017.
 */
public class FunctionNode implements Node {
    private Node operator;
    private int depth;
    private String operation;

    public FunctionNode(String operation) {
        this.operation = operation;
    }


    @Override
    public int arityOfOperation() {
        return 1;
    }

    @Override
    public String getText(int depth) throws CalculationException {
        if (operator.isReachable(depth)) {
            return operation + "(" + operator.getText(depth) + ")";
        } else
            return String.valueOf(getResult());


    }

    @Override
    public double getResult() throws CalculationException{
        switch (operation) {
            case "log":
                if(operator.getResult() > 0) return Math.log10(operator.getResult());
                 else throw new CalculationException("логарифм от отрицательного числа");
            case "ln":
                if(operator.getResult() > 0) return Math.log(operator.getResult());
                else throw new CalculationException("логарифм от отрицательного числа");
            case "sqrt":
                if(operator.getResult() > 0) return Math.sqrt(operator.getResult());
                else throw new CalculationException("корень квадратный от отрицательного числа");
            case "sqr":
                return operator.getResult()*operator.getResult();

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


    @Override
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public String getTitle() {
        return operation;
    }
}
