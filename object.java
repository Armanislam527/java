class car {
    String model = "tesla";
}
public class object{
    public static void main(String[] args) {
        car mycar = new car();
        System.out.println("Car model: "+mycar.model);
    }
}