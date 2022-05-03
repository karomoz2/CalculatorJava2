
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

class CalculatorTest {

    @Test
    void calculator1() {
        String str="1+2+3";
        Calculator calc =new Calculator();
        assertEquals(6,calc.calculation(str));
    }
    @Test
    void calculator2() {
        String str="(1+2)*(3-1)";
        Calculator calc =new Calculator();
        assertEquals(6,calc.calculation(str));
    }
    @Test
    void calculator3() {
        String str="(1+3)%2";
        Calculator calc =new Calculator();
        assertEquals(0,calc.calculation(str));
    }
    @Test
    void calculator4() {
        String str="(32+6/3)/2";
        Calculator calc =new Calculator();
        assertEquals(17,calc.calculation(str));
    }

}