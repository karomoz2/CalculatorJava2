import java.util.Stack;

public class Calculator {

    public static String ExptoRPolish(String expr){
       String cur="";
       Stack<Character> stack = new Stack<>();
       int prior; //Приоритет

       for(int i=0; i<expr.length(); i++)
       {
           prior=GetPriority(expr.charAt(i));

           if (prior==0) cur+=expr.charAt(i);
           if (prior ==1) stack.push(expr.charAt(i));
           if (prior > 1)
           {
               cur+=' '; //Надо чтобы у нас строка не получалась слитной
               while(!stack.empty())
               {
                   if (GetPriority(stack.peek())>=prior) cur+=stack.pop(); //Если верхнего приоритет >= текущего
                   else break;

               }
               stack.push(expr.charAt(i));
           }
           if (prior==-1){
               cur+=' ';
               while(GetPriority(stack.peek())!=1)cur+=stack.pop();
               stack.pop();
           }
       }

       while(!stack.empty())cur+=stack.pop();
        return cur;
    };

    public static double RPolishToResult(String rpn)
    {
        return 0;
    }

    private static int GetPriority(char token)
    {
        if(token=='*'|| token=='/')          return 3;
        else if (token =='+' || token =='-') return 2;
        else if (token == '(')               return 1;
        else if (token ==')')                return -1;
        else return 0;
    }

}





