import java.util.*;

class Calculator {
    public static void main(String[] args) {
        System.out.println("Simple Calculator...!!");
        while (true) {

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter First Number : ");
            int num1 = sc.nextInt();
            sc.nextLine();
            System.out.print("Enter Operator (+,-,*, or /.) : ");
            String op = sc.nextLine();
            System.out.print("Enter Second Number : ");
            int num2 = sc.nextInt();

            switch (op) {
                case "+":
                    int add = num1 + num2;
                    System.out.println("Addition is :" + add);
                    break;

                case "-":
                    int sub = num1 - num2;
                    System.out.println("Subtraction is :" + sub);
                    break;

                case "*":
                    int mul = num1 * num2;
                    System.out.println("Multiplication is :" + mul);
                    break;

                case "/":
                    int div = num1 / num2;
                    System.out.println("Division is :" + div);
                    break;

                case "%":
                    int mod = num1 % num2;
                    System.out.println("Modulo is :" + mod);
                    break;

                default:
                    System.out.println("Invalid operator. Please choose +, -, *, or /.");
                    break;
            }

        }

    }
}