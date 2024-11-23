import java.util.Scanner;
public class TemperatureConverter {
    public static void main(String[] args) {
     Scanner scanner = new Scanner(System.in);
  System.out.print("Enter your celcius temperature to convert into farenheit:");
        double celsius = scanner.nextDouble();
        double fahrenheit = ( celsius * 9 / 5) + 32;
        System.out.println("Fahrenheit: " + fahrenheit);
    }
}
