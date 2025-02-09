
import java.io.*;
import java.lang.*;

class sum_2 {

    int i, j;

    public void nested_loop() {
        for (i = 0; i < 5; i++) {
            for (j = 0; j < 5; j++) {
                System.out.
                        print(" " + (i + j));
            }
            System.out.println();
        }

    }
}

public class createcalss {

    /**
     * /**
     * Creates an instance of the sum_2 class and calls its nested_loop()
     * method.
     *
     * @param args the command line arguments
     *
     * *********** ✨ Codeium Command

     *      *⭐ ************
     *
     * /**
     * **** 82830c34-8263-47f9-8ee6-768d105b2a6b ******
     */
    public static void main(String[] args) {
        sum_2 obj = new sum_2();
        obj.nested_loop();
    }
}
