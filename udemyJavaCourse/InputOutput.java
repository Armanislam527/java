
package InputOutput;
import java.util.Scanner; //import package to use scanner for reading data

public class InputOutput {

    public static void main(String[] args) {
        //The following line will print the given string in the console
        System.out.println("This is an Output line");
        int x = 10;
        //with the string, is used to display value of the variable
        System.out.println("Value of x: " + x);

//The lines will print in the same line for using print() method
        System.out.print("First String ");

        System.out.println("Second String ");

//formatted output string using format specifier
        System.out.printf("This is the value of x=%d, PI %f \n", x, 22f / 7);
        Scanner scanner = new Scanner(System.in); //scanner class object to read from input devices
        System.out.print("Enter data using keyboard: ");

        int data = scanner.nextInt(); //it will take integer as input value and store to data

        System.out.println("The data, that has been read: " + data);

        scanner.close(); //close the scanner object when inputs are obtained

    }

}
