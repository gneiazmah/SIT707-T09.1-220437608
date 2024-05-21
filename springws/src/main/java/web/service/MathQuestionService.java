package web.service;

public class MathQuestionService {

    public static double q1Addition(String number1, String number2) {
        validateInput(number1, number2);
        double result = Double.valueOf(number1) + Double.valueOf(number2);
        return result;
    }

    public static double q2Subtraction(String number1, String number2) {
        validateInput(number1, number2);
        double result = Double.valueOf(number1) - Double.valueOf(number2);
        return result;
    }

    public static double q3Multiplication(String number1, String number2) {
        validateInput(number1, number2);
        double result = Double.valueOf(number1) * Double.valueOf(number2);
        return result;
    }

    private static void validateInput(String number1, String number2) {
        if (isInvalidInput(number1) || isInvalidInput(number2)) {
            System.out.println("Invalid input detected: number1: '" + number1 + "', number2: '" + number2 + "'");
            throw new IllegalArgumentException("Invalid input: both numbers must be valid doubles.");
        }
    }

    private static boolean isInvalidInput(String input) {
        return input == null || input.trim().isEmpty();
    }
}
