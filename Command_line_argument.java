
public class Command_line_argument {

    public static void main(String[] args) {
        if (args.length > 0) {
            System.out.println("Hello, " + args[0] + "!");

        } else {
            System.out.println("No argument provided");
        }
    }
}
