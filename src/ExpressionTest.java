public class ExpressionTest {
    public static void main(String[] args) {

        String[] testExpression = { "^", "8", "-", "5", "*", "(", "3", "+", "6", ")"};
        
        System.out.println(Expression.evaluatePostfix(Expression.convertToPostfix(testExpression)));
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
