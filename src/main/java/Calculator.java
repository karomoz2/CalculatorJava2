import java.util.Stack;

public class Calculator {

    public static String ExptoRPolish(String expr){
       String cur="";
       Stack<Character> stack = new Stack;
        return null;
    };

    public static double RPolishToResult(String rpn)
    {
        return 0;
    }

    private int GetPriority(char token)
    {
        if(token=='*'|| token=='/')          return 3;
        else if (token =='+' || token =='-') return 2;
        else if (token == '(')               return 1;
        else if (token ==')')                return -1;
        else return 0;
    }

    }





}