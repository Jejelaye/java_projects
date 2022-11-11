import java.util.Scanner;

public class Calculator {
    public static void main(String[] args) {
        double num1 = 0.0;
        double num2 = 0.0;
        char operator;
        double result = 0.0;

        Scanner in = new Scanner(System.in);

        System.out.println("Welcome to this simple calculator!");
        System.out.println("Enter the first number here: ");
        num1 = in.nextDouble();
        System.out.println("Enter the operator");
        operator = in.next().charAt(0);
        System.out.println("Enter the second number here: ");
        num2 = in.nextDouble();

        switch (operator) {
            case '-': result = num1 - num2;
                break;
            case '+': result = num1 + num2;
                break;
            case '/': result = num1 / num2;
                break;
            case '*': result = num1 * num2;
                break;
        }

        System.out.println("The result of " + num1 + " " + operator + " " + num2 + " is = " + result);
    }
}
