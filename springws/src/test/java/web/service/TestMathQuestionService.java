package web.service;

import org.junit.Test;
import static org.junit.Assert.*;

public class TestMathQuestionService {

    @Test
    public void testAddValidNumbers() {
        double result = MathQuestionService.q1Addition("1", "2");
        assertEquals(3.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNumber1Empty() {
        MathQuestionService.q1Addition("", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddNumber2Empty() {
        MathQuestionService.q1Addition("1", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddBothNumbersEmpty() {
        MathQuestionService.q1Addition("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidNumber1() {
        MathQuestionService.q1Addition("abc", "2");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testAddInvalidNumber2() {
        MathQuestionService.q1Addition("1", "xyz");
    }

    @Test
    public void testSubtractValidNumbers() {
        double result = MathQuestionService.q2Subtraction("5", "3");
        assertEquals(2.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractNumber1Empty() {
        MathQuestionService.q2Subtraction("", "3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractNumber2Empty() {
        MathQuestionService.q2Subtraction("5", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractBothNumbersEmpty() {
        MathQuestionService.q2Subtraction("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractInvalidNumber1() {
        MathQuestionService.q2Subtraction("abc", "3");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSubtractInvalidNumber2() {
        MathQuestionService.q2Subtraction("5", "xyz");
    }

    @Test
    public void testMultiplyValidNumbers() {
        double result = MathQuestionService.q3Multiplication("3", "4");
        assertEquals(12.0, result, 0.001);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyNumber1Empty() {
        MathQuestionService.q3Multiplication("", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyNumber2Empty() {
        MathQuestionService.q3Multiplication("3", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyBothNumbersEmpty() {
        MathQuestionService.q3Multiplication("", "");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyInvalidNumber1() {
        MathQuestionService.q3Multiplication("abc", "4");
    }

    @Test(expected = IllegalArgumentException.class)
    public void testMultiplyInvalidNumber2() {
        MathQuestionService.q3Multiplication("3", "xyz");
    }
}
