package com.ivan.calculator.calculatorData;

import com.ivan.calculator.CalculationException;
import com.ivan.calculator.calculatorData.graphNodes.BinaryOperationNode;
import com.ivan.calculator.calculatorData.graphNodes.FunctionNode;
import com.ivan.calculator.calculatorData.graphNodes.Node;
import com.ivan.calculator.calculatorData.graphNodes.NumberNode;
import com.ivan.calculator.calculatorData.graphNodes.UnaryOperationNode;

import java.util.Stack;
import java.util.List;
import java.util.StringTokenizer;

/**
 * Created by Ivan on 06.05.2017.
 */
public class CalculatorData {
    private final String[] FUNCTIONS = {"log", "ln", "sqrt", "sqr"};
    private final String OPERATORS = "+-*/!%";

    private Node rootNode;
    private int depth;
    private int maxDepth = 0;


    public double calculate(String expression) throws CalculationException {
        Stack<Node> stackRPN = parseExpression(expression);
        buildTree(stackRPN);
        return rootNode.getResult();

    }

    public void changeDepth(boolean isIncrease) throws CalculationException {
        if (isIncrease) {
            if (depth + 1 <= maxDepth) depth++;
        } else if (depth - 1 > 0) depth--;
    }

    public String getExpression() throws CalculationException {
        return rootNode.getText(depth);
    }

    private void buildTree(Stack<Node> stackRPN) throws CalculationException {
        Stack<Node> expressionStack = new Stack<>();
        rootNode = stackRPN.firstElement();
        while (!stackRPN.isEmpty()){
            Node node = stackRPN.pop();

                switch (node.arityOfOperation()){
                    case 0: expressionStack.push(node);
                            break;
                    case 1: if(!expressionStack.isEmpty()){
                            if(node instanceof FunctionNode) ((FunctionNode)node).setOperators(expressionStack.pop());
                            else if(node instanceof UnaryOperationNode) ((UnaryOperationNode)node)
                                                                        .setOperators(expressionStack.pop());
                            expressionStack.push(node);
                            } else throw new CalculationException("пропущены операнты");
                             break;
                    case 2: if(!expressionStack.isEmpty() && expressionStack.peek() != expressionStack.firstElement()){
                        Node secondOperator = expressionStack.pop();
                        Node firstOperator = expressionStack.pop();
                        ((BinaryOperationNode)node).setOperators(firstOperator,secondOperator);
                        expressionStack.push(node);
                    }else throw new CalculationException("пропущены операнты");
                             break;
                }
        }
        DFS(rootNode,0);
        maxDepth++;
        depth = maxDepth;
    }

    private void DFS(Node node, int depth){
        if(maxDepth<depth) maxDepth = depth;
        node.setDepth(depth);
        List<Node> adjacentNodes = node.getAdjacentNodes();
        for (Node adjacentNode : adjacentNodes){
            DFS(adjacentNode,depth+1);
        }
    }

    private Stack<Node> parseExpression(String expression) throws CalculationException {
        Stack<String> stackRPN = new Stack<String>();
        Stack<String> stackOperations = new Stack<String>();

        expression = expression.replace(" ", "").replace("(-", "(0-");
        if (expression.charAt(0) == '-') {
            expression = "0" + expression;
        }

        StringTokenizer stringTokenizer = new StringTokenizer(expression,
                OPERATORS + "()", true);
        while (stringTokenizer.hasMoreTokens()) {
            String token = stringTokenizer.nextToken();

            if (isOpenBracket(token)) {
                stackOperations.push(token);
            } else if (isCloseBracket(token)) {
                while (!stackOperations.empty()
                        && !isOpenBracket(stackOperations.lastElement())) {
                    stackRPN.push(stackOperations.pop());
                }
                stackOperations.pop();
                if (!stackOperations.empty()
                        && isFunction(stackOperations.lastElement())) {
                    stackRPN.push(stackOperations.pop());
                }
            } else if (isNumber(token)) {

                stackRPN.push(token);

            } else if (isOperator(token)) {
                while (!stackOperations.empty()
                        && isOperator(stackOperations.lastElement())
                        && getPrecedence(token) <= getPrecedence(stackOperations
                        .lastElement())) {
                    stackRPN.push(stackOperations.pop());
                }
                stackOperations.push(token);
            } else if (isFunction(token)) {
                stackOperations.push(token);
            }
        }
        while (!stackOperations.empty()) {
            stackRPN.push(stackOperations.pop());
        }


        Stack<String> checkStack = (Stack<String>) stackRPN.clone();
        while (!checkStack.isEmpty()) {
            if (checkStack.pop().equals("(")) throw new CalculationException("Не все скобки закрыты");

        }
        Stack<Node> result = new Stack<>();
        while (!stackRPN.isEmpty()) {
            String token = stackRPN.pop();
            if (isNumber(token)) result.push(new NumberNode(Double.parseDouble(token)));
            else if(isFunction(token)) result.push(new FunctionNode(token));
            else if (isOperator(token)) {
                if(token.equals("!") || token.equals("%")) result.push(new UnaryOperationNode(token));
                    else result.push(new BinaryOperationNode(token));
            }
        }

        return result;
    }

    public void reset(){
        rootNode = null;
        maxDepth = 0;
        depth = 0;
    }

    public int getDepth() {
        return depth;
    }

    public Node getRootNode() {
        return rootNode;
    }

    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (Exception e) {
            return false;
        }
        return true;
    }

    private boolean isFunction(String token) {
        for (String item : FUNCTIONS) {
            if (item.equals(token)) {
                return true;
            }
        }
        return false;
    }

    private boolean isOpenBracket(String token) {
        return token.equals("(");
    }

    private boolean isCloseBracket(String token) {
        return token.equals(")");
    }

    private byte getPrecedence(String token) {
        if (token.equals("+") || token.equals("-")) {
            return 1;
        }
        if (token.equals("!")) return 3;
        return 2;
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

}
