package strings;

import java.util.Scanner;

public class stringProg {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[] charstr = {'a', 'b', 'c', 'd', 'e', 'f', 'g'}; //the array  of characters
        String str = new String(charstr); //making a string from the array of characters
        System.out.println("The value of str is: " + str);

        System.out.print("Enter a string: ");
        str = scanner.nextLine();
        System.out.println("You entered: " + str);
        System.out.println("Length of the string: " + str.length());
        System.out.println("Uppercase: " + str.toUpperCase());
        System.out.println("Lowercase: " + str.toLowerCase());
        System.out.print("Enter another string: ");
        String anotherString = scanner.nextLine();
        String concatenatedString = str.concat(anotherString);
        System.out.println("Concatenated string: " + concatenatedString);
        scanner.close();
    }
}
