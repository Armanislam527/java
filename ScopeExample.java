public class ScopeExample {
    public static void main(String[] args) {
        int outer = 10; // Method scope

        if (outer > 5) {
            int inner = 20; // Block scope
            System.out.println("Inner: " + inner);
        }

        // System.out.println(inner); // Error: inner not accessible here
    }
}
