public class InstanceVariableExample{
    int age = 35;
    public static void main(String[] args) {
        InstanceVariableExample obj = new InstanceVariableExample();
        System.err.println("Instance variable: "+ obj.age);
    }
}