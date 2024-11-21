
public class multi_line_argument {

    public static void main(String[] args) {
        System.out.println("Number of arguments: " + args.length);
        for (int i = 0; i < args.length; i++) {
            System.err.println("Argument" + i + ": " + args[i]);
        }
    }
}
