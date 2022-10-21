public class ExpressionTest {
    public static void main(String[] args) {
        String[] testExpression = {"[", "(", "5", ")", "]"};
        String[] badTestExpression = {"d", "(", "]", "+", "5"};
        if(Expression.checkBalance(testExpression) && !Expression.checkBalance(badTestExpression))
            System.out.println("checkBalance() works!");
        else
            System.out.println("checkBalance() does not work :(");

        if(Expression.isVar(testExpression[2]) && !Expression.isVar(testExpression[1]))
            System.out.println("isVar() works!");
        else
            System.out.println("isVar() does not work :(");
    }
}
