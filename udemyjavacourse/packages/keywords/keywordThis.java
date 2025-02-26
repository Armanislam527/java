//package keywords;

class Myclass {

    private int a, b;

    public Myclass(int a, int b) {
        this.a = a;
        this.b = b;
    }

    public Myclass() {
        this(0, 0);
    }

    public void setdata(int a, int b) {
    }
    public void print(){
    System.out.println(this.a+" "+this.b);
    }
}

    class keywordThis {

        public static void main(String[] args) {
            Myclass obj = new Myclass();
            obj.print();
        }
    }
