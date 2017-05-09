package com.ivan.calculator.calculatorData.graphNodes;

import com.ivan.calculator.CalculationException;

import java.util.List;

/**
 * Created by Ivan on 08.05.2017.
 */
public interface Node {
    public int arityOfOperation();
    public String getText(int depth) throws CalculationException;
    public double getResult() throws CalculationException;
    public boolean isReachable(int depth);
    public List<Node> getAdjacentNodes();
    public String getTitle();
    public void setDepth(int depth);
}
