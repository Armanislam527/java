//package classobject;

class Student {

    String name;
    int rollno;
    int id;
    String major;
    String course;
    int m1, m2, m3;

    void setname(String stname) {
        name = stname;
    }

    void setrollno(int strollno) {
        rollno = strollno;
    }

    void setid(int stid) {
        id = stid;
    }

    void setmajor(String stmajor) {
        major = stmajor;
    }

    void setcourse(String stcourse) {
        course = stcourse;
    }

    void setmarks(int stm1, int stm2, int stm3) {
        m1 = stm1;
        m2 = stm2;
        m3 = stm3;
    }

    int total() {
        return m1 + m2 + m3;
    }

    int average() {
        return total() / 3;
    }

    void display() {
        System.out.println("Name: " + name);
        System.out.println("Roll No: " + rollno);
        System.out.println("ID: " + id);
        System.out.println("Major: " + major);
    }
}

public class classObject {

    public static void main(String[] args) {
        Student s1 = new Student();
        Student s2 = new Student();
        s1.setname("Arman Islam");
        s2.setname("Khadiza Akter");
        s1.setrollno(1);
        s2.setrollno(2);
        s1.setid(1);
        s2.setid(2);
        s1.setmajor("CSE");
        s2.setmajor("Nursing");
        s1.setcourse("Java");
        s2.setcourse("Fundamental of Nursing");

        s1.setmarks(30, 50, 40);
        s2.setmarks(40, 60, 50);
        s1.display();
        s2.display();
        System.out.println("Course: " + s1.course);

        System.out.println("Total Marks: " + s1.total());
        System.out.println("Average Marks: " + s1.average());

    }
}
