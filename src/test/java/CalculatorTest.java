import org.junit.Test;

import static org.junit.Assert.*;

public class CalculatorTest {

    @Test
    public void isDigit() {
    }

    @Test
    public void infixToPostfix() {
        Calculator calc= new Calculator();
        String[]b=new String[]{"2","2","+"};
        String[]a=new String[]{"2","+","2"};
        assertArrayEquals(a,calc.infixToPostfix(b));
    }
}