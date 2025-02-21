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
        s1.setrollno(1);
        s1.setid(1);
        s1.setmajor("CSE");
        s1.setcourse("Java");
        s1.setmarks(30, 50, 40);
        s1.display();
        System.out.println("Total Marks: " + s1.total());
        System.out.println("Average Marks: " + s1.average());
        s2.
    }
}
