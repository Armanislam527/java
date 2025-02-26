public class DebugExample {
    public static void main(String[] args) {
        try {
            int num1 = 10, num2 = 0;
            int result = num1 / num2; // Exception occurs
            System.out.println("Result: " + result);
        } catch (ArithmeticException e) {
            System.out.println("Error: Cannot divide by zero.");
            e.printStackTrace(); // Prints debugging details
        }//hi man yeasir arafat
    }
}
