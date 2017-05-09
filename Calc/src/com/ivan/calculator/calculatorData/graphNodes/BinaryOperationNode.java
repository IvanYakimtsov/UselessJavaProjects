package com.ivan.calculator.calculatorData.graphNodes;

import com.ivan.calculator.CalculationException;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Ivan on 08.05.2017.
 */
public class BinaryOperationNode implements Node {
    private Node leftOperator;
    private Node rightOperator;
    private int depth;
    private String operation;

    public BinaryOperationNode(String operation) {
        this.operation = operation;
    }


    @Override
    public int arityOfOperation() {
        return 2;
    }

    @Override
    public String getText(int depth) throws CalculationException {
        if (leftOperator.isReachable(depth) && rightOperator.isReachable(depth)) {
            return "(" + leftOperator.getText(depth) + operation + rightOperator.getText(depth) + ")";
        } else
            return String.valueOf(getResult());


    }

    @Override
    public double getResult() throws CalculationException {
        switch (operation) {
            case "+":
                return leftOperator.getResult() + rightOperator.getResult();
            case "-":
                return leftOperator.getResult() - rightOperator.getResult();
            case "*":
                return leftOperator.getResult() * rightOperator.getResult();
            case "/":
                double rightOperatorResult = rightOperator.getResult();
                if (rightOperatorResult == 0) throw new CalculationException("Деление на 0");
                return (double) leftOperator.getResult() /  rightOperatorResult;

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
        adjacentNodes.add(leftOperator);
        adjacentNodes.add(rightOperator);
        return adjacentNodes;
    }

    @Override
    public String getTitle() {
        return operation;
    }

    @Override
    public void setDepth(int depth) {
        this.depth = depth;
    }

    public void setOperators(Node leftOperator, Node rightOperator) {
        this.leftOperator = leftOperator;
        this.rightOperator = rightOperator;
    }
}
