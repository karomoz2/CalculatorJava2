import static org.junit.Assert.*;

public class CalculatorTest {

    @org.junit.Test
    public void getResult() {
        Calculator a=new Calculator();
        String str="2+2*2";
        assertEquals(6.0,a.getResult(str),0);
    }

    @org.junit.Test
    public void getResult2() {
        Calculator a=new Calculator();
        String str="(2+2)*(4-2)";
        assertEquals(8.0,a.getResult(str),0);
    }

    @org.junit.Test
    public void getResult3() {
        Calculator a=new Calculator();
        String str="(2+3)%(4-2)";
        assertEquals(1.0,a.getResult(str),0);
    }

    @org.junit.Test
    public void getResult4() {
        Calculator a=new Calculator();
        String str="(2+2)/2";
        assertEquals(2.0,a.getResult(str),0);
    }

    @org.junit.Test
    public void getResult5() {
        Calculator a=new Calculator();
        String str="(28+2)*2/2-(4+2)";
        assertEquals(24.0,a.getResult(str),0);
    }
}