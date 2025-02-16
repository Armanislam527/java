
import java.io.*;
import java.util.Scanner;

class student {

    int roll;
    String name;//= new Striing();

    void getdata() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the roll number");
        roll = sc.nextInt();
        sc.nextLine();

        System.out.println("Enter the name");
        name = sc.nextLine();
    }
}

class result extends student {

    float marks;

    void info() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the marks");
        marks = sc.nextFloat();

    }

    void showdata() {
        System.out.println("Roll number:" + roll);
        System.out.println("Name:" + name);
        System.out.println("Marks:" + marks);
    }

}

public class resul {

    public static void main(String[] args) {
        result k = new result();
        k.getdata();
        k.info();
        k.showdata();
    }
}
