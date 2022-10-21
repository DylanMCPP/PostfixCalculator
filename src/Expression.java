// 
//  Name:   Michalak, Dylan
//  Project:  # 3
//  Due:        10/19/2022
//  Course:  cs-2400-01-f22 
// 
//  Description: 
//    A java class that converts infix arithmetic expressions to postfix and calculates
//    their resulting value, using a Stack ADT implemented with a resizeable array.
// 
import java.util.Arrays;
public class Expression {


    /**
     * Converts an infix arithmetic expression to its postfix form
     * @param infixExpression an Array of Strings, with each string being an individual token in the infix expression
     * @return an Array of Strings, with each string being an individual token in the postfix expression
     */
    public static String[] convertToPostfix(String[] infixExpression) {
        //if (!checkBalance(infixExpression))
            //throw new IllegalStateException("attempted to convert an unbalanced statement to postfix");

        Stack<String> operatorStack = new ArrayStack<>();
        int tokenCount = infixExpression.length;
        String[] postfix = new String[tokenCount];
        int index = 0;
        int finalArrayindex = 0;
        String topOperator;
        int operandCounter = 0, operatorCounter = 0;
        
        while(index < tokenCount) {
            String token = infixExpression[index];
            if (isVar(token)) {
                postfix[finalArrayindex] = token;
                finalArrayindex++;
                operandCounter++;
            } else {
                switch (token) {
                    case "^":
                        operatorStack.push(token);
                        operatorCounter++;
                        break;
                    case "+": case "-": case "*" : case "/":
                        while(!operatorStack.isEmpty() && (precedence(token) <= precedence(operatorStack.peek()))) {
                            postfix[finalArrayindex] = operatorStack.pop();
                            finalArrayindex++;
                        }
                        operatorStack.push(token);
                        operatorCounter++;
                        break;
                    case "(": case "[": case "{":
                        operatorStack.push(token);
                        break;
                    case ")":
                        topOperator = operatorStack.pop();
                        while (!topOperator.equals("(")) {
                            postfix[finalArrayindex] = topOperator;
                            finalArrayindex++;
                            topOperator = operatorStack.pop();
                        }
                        break;
                    case "]":
                        topOperator = operatorStack.pop();
                        while (topOperator != "[") {
                            postfix[finalArrayindex] = topOperator;
                            finalArrayindex++;
                            topOperator = operatorStack.pop();
                        }
                        break;
                    case "}":
                        topOperator = operatorStack.pop();
                        while (topOperator != "{") {
                            postfix[finalArrayindex] = topOperator;
                            finalArrayindex++;
                            topOperator = operatorStack.pop();
                        }
                        break;
                    default:
                        throw new IllegalStateException("Attempted to convert a non-infix statement to postfix");
                }
            }
            index++;
        }
        while (!operatorStack.isEmpty())
            {
                postfix[finalArrayindex] = operatorStack.pop();
                finalArrayindex++;
            }

        if (operatorCounter != (operandCounter - 1)) //if the expression is missing any necessary variables or operators, it's not a proper postfix expression
            throw new IllegalStateException("Attempted to convert a non-infix statement to postfix");

        return Arrays.copyOfRange(postfix, 0, finalArrayindex);
    }

    /**
     * Evaluates the result of a postfix arithmetic expression
     * @param postfixExpression a String array, where each entry is a token in a complete postfix expression
     * @return the resulting double value of the expression
     */
    public static double evaluatePostfix(String[] postfixExpression) {
        Stack<Double> valueStack = new ArrayStack<>();
        String token;

        for (int i = 0; i < postfixExpression.length; i++) {
            token = postfixExpression[i];
            if (isVar(token)) {
                valueStack.push(Double.parseDouble(token));
            }
            else {
                double operandTwo = valueStack.pop();
                double operandOne = valueStack.pop();
                double result;
                switch(token) {
                    case "+":
                        result = operandOne + operandTwo;
                        break;
                    case "-":
                        result = operandOne - operandTwo;
                        break;
                    case "*":
                        result = operandOne * operandTwo;
                        break;
                    case "/":
                        result = operandOne / operandTwo;
                        break;
                    case "^":
                        result = Math.pow(operandOne, operandTwo);
                        break;
                    default:
                        throw new IllegalStateException("Attempted to evaluate an illegal expression using Expression.evaluatePostfix()");
                }
                valueStack.push(result);
            }
        }
        return valueStack.peek();
    }


    //checks to see whether expression's parenthesis, brackets, and braces occur in correct left/right pairs
    private static boolean checkBalance(String[] expression) {

        Stack<String> openDelimiterStack = new ArrayStack<>();
        int tokenCount = expression.length;
        boolean isBalanced = true;
        int index = 0;

        while (index < tokenCount  && isBalanced) {
            switch(expression[index]) {
                case "(": case "[": case "{":
                    openDelimiterStack.push(expression[index]); //adds the delimiter to the top of the stack
                    break;
                case ")": case "]": case "}":
                    if (openDelimiterStack.isEmpty()) //if a closing expression occurs while no opening expression has been added, not balnaced
                        isBalanced = false;
                    else {
                        String openDelimiter = openDelimiterStack.pop();
                        isBalanced = isPaired(openDelimiter, expression[index]); //checks to see if the last opening expression added pairs correctly with the closing expression, and takes it from the stack
                    } break;
                default: break;
            }
            index++;
        }
        return isBalanced;
    }

    //returns true if the token is allowed in an infix expression
    private static boolean isVar(String token) {
        try {
            Double.parseDouble(token);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static boolean isPaired(String open, String close)
    {
        return(open == "("&& close == ")") ||
        (open == "["&& close == "]") ||
        (open == "{"&& close == "}");
    }
    
    private static int precedence(String token) {
        switch(token) {
            case "+": case "-":
                return 1;
            case "*": case "/":
                return 2;
            case "^":
                return 3;
            default:
                return -1;
        }
    }

}
