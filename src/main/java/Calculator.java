
public class Calculator {

    public static String ExptoRPolish(String expr){
        return null;
    };

    public static double RPolishToResult(String rpn)
    {
        return 0;
    }

    private int GetPriority(char token)
    {
        if(token=='*'|| token=='/') return 3;
        else if (token =='+') return 2;
        else if (token == '(') return 1;
    }

    }





}