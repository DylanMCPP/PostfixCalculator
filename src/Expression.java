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
public class Expression {


    public String[] convertToPostfix(String[] infixExpression) {
        Stack<String> operatorStack = new ArrayStack<>();
        int tokenCount = infixExpression.length;
        String[] postfix = new String[tokenCount];
        int index = 0;
        int finalArrayindex = 0;
        while(index < tokenCount) {
            String token = infixExpression[index];
            if (isVar(token)) {
                postfix[finalArrayindex] = token;
                finalArrayindex++;
            } else {
                switch (token) {
                    case "^":
                        operatorStack.push(token);
                        break;
                    case "+": case "-": case "*" : case "/":
                        while(!operatorStack.isEmpty() && )
                }
            }
        }
    }

    public double evaluatePostfix(String[] postfixExpression) {
        return 0;
    }

    //checks to see whether expression's parenthesis, brackets, and braces occur in correct left/right pairs
    private boolean checkBalance(String[] expression) {

        Stack<String> openDelimiterStack = new ArrayStack<>();
        int tokenCount = expression.length;
        boolean isBalanced = true;
        int index = 0;

        while (index < tokenCount && isBalanced) {
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
    private boolean isVar(String token) {
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
                throw new RuntimeException("attempted to assess precedence of a non-operator token");
        }
    }

}
