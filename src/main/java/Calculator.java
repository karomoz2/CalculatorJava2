import java.io.InputStream;
import java.util.Scanner;
import java.util.Vector;

public class Calculator {

    private Scanner scanner;
    public Calculator()
    {
        scanner= new Scanner(System.in);
    }
    public Calculator(InputStream input)
    {
        this.scanner=new Scanner(input);
    }

    int priority(char op) { //приоритет знаков операции
       int b=-1;
       if (op == '+' || op == '-') b=1;
       else if (op == '*' || op == '/' || op == '%') b=2;
        return b;

    }

    void doOper(Vector<Integer> opNds, char opNs) {  //выполненяет операцию
        int r = opNds.lastElement();
        opNds.remove(opNds.size() - 1);
        int l = opNds.lastElement();
        opNds.remove(opNds.size() - 1);
        int res;

        switch (opNs) {
            case '+' : opNds.add(l + r); break;
            case '-' : opNds.add(l - r); break;
            case '*' : opNds.add(l * r); break;
            case '/' : opNds.add(l / r); break;
            case '%' : opNds.add(l % r); break;
        }
    }

    public int calculation(String data) { //алгоритм перевода из инфиксной в постфиксную форму
        Vector<Character> operatioNs = new Vector<>(); //операции
        Vector<Integer> operanDs = new Vector<>(); //операнды

        for (int i = 0; i < data.length(); ++i)
        {
            if (data.charAt(i)!=' ')
            {
                //Блок выполнения операций, заключенных в скобках
                if (data.charAt(i) == '(') //В вектор операций добавляетсяся откр-ся скобка, если такова имеется
                    operatioNs.add('(');
                else if (data.charAt(i) == ')')
                { //Выполняем операции до открывающей скобки и очищаем вектор операций
                    while (operatioNs.lastElement() != '(') {
                        doOper(operanDs, operatioNs.lastElement());
                        operatioNs.remove(operatioNs.size() - 1);
                    }
                    operatioNs.remove(operanDs.size() - 1); //Удаляем открывающуюся скобку
                }


                //Блок выполнения операций без скобок
                else if (data.charAt(i) == '+' || data.charAt(i) == '-' || data.charAt(i) == '*' || data.charAt(i) == '/' || data.charAt(i) == '%' )
                {//Проверяем на знак операции
                    char curOper = data.charAt(i); //Текущая операция
                    while (!operatioNs.isEmpty() && priority(operatioNs.lastElement()) >= priority(data.charAt(i)))
                    {
                        //Пока не встретили операцию с большим приоритетом - выполняем операции и подчищаем
                        doOper(operanDs, operatioNs.lastElement());
                        operatioNs.remove(operanDs.size() - 1);
                    }
                    operatioNs.add(curOper);
                }
                else
                {
                    StringBuilder operand = new StringBuilder();
                    while (i < data.length() && (Character.isLetter(data.charAt(i)) || Character.isDigit(data.charAt(i)))) //Если встретился операнд
                        operand.append(data.charAt(i++));
                    --i;
                    if (Character.isDigit(operand.charAt(0)))
                        operanDs.add(Integer.valueOf(operand.toString()));
                    else
                    {
                        var tmp = getVariable(operand.toString(), data); //вводим операнд
                        i += tmp.length() - operand.length();
                        data = data.replace(operand.toString(), tmp);
                        operanDs.add(Integer.valueOf(tmp));
                    }
                }
            }
        }
        while (!operatioNs.isEmpty()) { //выполняем все операции из вектора операций
            doOper(operanDs, operatioNs.lastElement());
            operatioNs.remove(operanDs.size() - 1);
        }
        return operanDs.lastElement(); //последнее значение, является решением

    }

    private String getVariable(String operand,String s) {
        System.out.println("Введите значение "+ operand + " :");
        return scanner.nextLine();
    }
}