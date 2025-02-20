//package keywords;

class staticDemo {

    static int staticvariable;
    int nonstaticvariable;

    public staticDemo() {

        nonstaticvariable = 0;

    }

    public static void staticmethod(int x) {
        staticvariable = x;
    }

    public void increment() {
        staticvariable++;
        nonstaticvariable++;
    }

    public void display() {
//        System.out.println("Static variable: " + staticvariable);//display the value of static variable
//        System.out.println("Non-static variable: " + nonstaticvariable);//display the value of nonstaticvariable
        System.out.println("Static variable accessed from non-static method: " + staticvariable);
        System.out.println("Non-static variable accessed from non-static method: " + nonstaticvariable);
        System.out.println();
    }

}

public class keywordStatic {

    public static void main(String[] args) {
        staticDemo obj1 = new staticDemo();
        staticDemo obj2 = new staticDemo();
        staticDemo obj3 = new staticDemo();

        obj1.staticmethod(10);

        obj1.nonstaticvariable = 50;
        obj1.increment();
        obj1.display();

        obj2.staticmethod(20);
        obj2.increment();
        obj2.display();

        obj3.staticmethod(30);
        obj3.increment();
        obj3.display();
    }
}
