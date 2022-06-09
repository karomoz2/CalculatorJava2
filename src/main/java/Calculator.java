import java.util.Stack;

public class Calculator {

    private static String ExpToRPolish(String expr){ //перевод в обратную польскую нотацию (RPN)
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

    private static double RPolishToResult(String rpn)
    {
        String oper=new String();
        Stack<Double> stack = new Stack<>();

        for (int i=0; i<rpn.length();i++)
        {
            if(rpn.charAt(i)==' ') continue;
            if (GetPriority(rpn.charAt(i))== 0){
                while(rpn.charAt(i)!=' ' && GetPriority(rpn.charAt(i))==0)
                {
                    oper+=rpn.charAt(i++);
                if (i==rpn.length()) break;
                }
                stack.push(Double.parseDouble(oper));
                oper=new String();
            }
            //Если матем символ попался
            if (GetPriority(rpn.charAt(i))>1){
                double a=stack.pop(), b=stack.pop();

                if (rpn.charAt(i)=='+')stack.push(b+a);
                if (rpn.charAt(i)=='-')stack.push(b-a);
                if (rpn.charAt(i)=='*')stack.push(b*a);
                if (rpn.charAt(i)=='/')stack.push(b/a);
                if (rpn.charAt(i) == '%') stack.push(b%a);
            }
        }

        return stack.pop();
    }

    private static int GetPriority(char token)
    {
        if(token=='*'|| token=='/' || token =='%')          return 3;
        else if (token =='+' || token =='-')                return 2;
        else if (token == '(')                              return 1;
        else if (token ==')')                               return -1;
        else return 0;
    }

    public double getResult(String expr){
        String rpn = ExpToRPolish(expr);
        return RPolishToResult(rpn);

    }

}





