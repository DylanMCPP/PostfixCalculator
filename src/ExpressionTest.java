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
public class ExpressionTest {
    public static void main(String[] args) {

        String command = args[0];
        String[] expression = command.split("\\s");

        try {
            System.out.println(Expression.evaluatePostfix(Expression.convertToPostfix(expression)));
        } catch (IllegalStateException e) {
            System.out.println("Attempted to evaluate an illegal argument, please input an infix " +
                                "expression where all tokens are seperated by a space.");
        }
        //This block is for individually testing the convertToPostfix method
        /* String[] postfix = Expression.convertToPostfix(testExpression);
        for (String i: postfix) {
            System.out.println(i);
        } */

        //This block is for individually testing two Expression methods currently set to private
        /* String[] testExpression = {"[", "(", "5", ")", "]"};
        String[] badTestExpression = {"d", "(", "]", "+", "5"};
        if(Expression.checkBalance(testExpression) && !Expression.checkBalance(badTestExpression))
            System.out.println("checkBalance() works!");
        else
            System.out.println("checkBalance() does not work :(");

        if(Expression.isVar(testExpression[2]) && !Expression.isVar(testExpression[1]))
            System.out.println("isVar() works!");
        else
            System.out.println("isVar() does not work :(");
        */
    }
}
