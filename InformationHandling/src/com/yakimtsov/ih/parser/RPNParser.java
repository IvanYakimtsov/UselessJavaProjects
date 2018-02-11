package com.yakimtsov.ih.parser;

import java.util.Collections;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * Created by Ivan on 08.02.2018.
 */
public class RPNParser {
    private final String OPERATORS = "+-*/";
    private final String VARIABLE = "ij";
    private Stack<String> stackOperations = new Stack<String>();
    private Stack<String> stackRPN = new Stack<String>();
    private Stack<String> stackAnswer = new Stack<String>();

    public String parseRPN(String expression) {
        return "";
    }

    public void parse(String expression) {
        // cleaning stacks
        stackOperations.clear();
        stackRPN.clear();

        // make some preparations
        expression = expression.replace(" ", "").replace("(-", "(0-")
                .replace(",-", ",0-");
        if (expression.charAt(0) == '-') {
            expression = "0" + expression;
        }
        // splitting input string into tokens
        StringTokenizer stringTokenizer = new StringTokenizer(expression,
                OPERATORS + "()", true);

        // loop for handling each token - shunting-yard algorithm
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
                if (!stackOperations.empty()) {
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
            }
        }
        while (!stackOperations.empty()) {
            stackRPN.push(stackOperations.pop());
        }

        Collections.reverse(stackRPN);

        stackRPN.forEach(System.out::println);
    }


    private boolean isNumber(String token) {
        try {
            Double.parseDouble(token);
        } catch (Exception e) {
            if (token.equals(VARIABLE)) {
                return true;
            }
            return false;
        }
        return true;
    }


    private boolean isOpenBracket(String token) {
        return token.equals("(");
    }

    private boolean isCloseBracket(String token) {
        return token.equals(")");
    }

    private boolean isOperator(String token) {
        return OPERATORS.contains(token);
    }

    private byte getPrecedence(String token) {
        if (token.equals("+") || token.equals("-")) {
            return 1;
        }
        return 2;
    }

}
