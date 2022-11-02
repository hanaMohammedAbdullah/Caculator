import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class Calculator1Test {

    Calculator1  calculator ;

    @Before
    public void setUp(){
        calculator = new Calculator1();
    }

    // does calculate lunch in less than 0.75 second
    @Test(timeout = 750)        //  support in Junit 4
    public void PerformanceOfLunch(){
        calculator.luncher();
    }

    @Test
    public void  ValidateAddOperation() {
        double num1 = 4;
        double num2 = 4;
        double expecet = 8;
        assertEquals(expecet ,calculator.add(num1 , num2 ),2);
        assertEquals(123456.880 ,calculator.add(123456.876 , 0.4 ),2);

    }

    @Test
    public void ValidateMultiOperation() {
        double num1 = 4;
        double num2 = 4;
        double expecet = 16;
        assertEquals(expecet ,calculator.mult(num1 , num2 ),2);
        assertEquals( 49382.752 ,calculator.mult(123456.876 , 0.4 ),3);

    }

    @Test
    public void ValidateSubOperation() {
        double num1 = 4;
        double num2 = 4;
        double expecet = 0;
        assertEquals(expecet ,calculator.sub(num1 , num2 ),2);
        assertEquals( 123456.872 ,calculator.sub(123456.876 , 0.4 ),3);
    }

    @Test
    public void ValidateDivOperation() {
        double num1 = 4;
        double num2 = 4;
        double expecet = 1;
        assertEquals(expecet ,calculator.div(num1 , num2 ),2);
        assertEquals( 308642.19 ,calculator.div(123456.876 , 0.4 ),2);
    }

    @Test
    public void neg() {
        String num1 = "4.0";
        String expecet = "-4.0";
        assertEquals(expecet ,calculator.neg(num1));
    }
}