//package strings;

public class strBufferBuilder {

    public static void main(String[] args) {
        StringBuffer sBuffer = new StringBuffer();//default capacity is 16
        System.out.println("Capacity of sBuffer: " + sBuffer.capacity());
        sBuffer = new StringBuffer(50); //Set the capacity to 50
        System.out.println("Capacity of sBuffer: " + sBuffer.capacity());
        //String buffer capacity is now 16+ length of given string
        sBuffer = new StringBuffer("My StringBuffer");
        System.out.println("Capacity of sBuffer:" + sBuffer.capacity());
        System.out.println("String in sBuffer: " + sBuffer);
        //StringBuilders are used same as StringBuffer
        StringBuilder sBuilder = new StringBuilder("My StringBuilder");
        System.out.println("String in sBuffer: " + sBuilder);
        //append sting after the string bugger and string builder
        sBuffer.append("appended with string buffer.");
        sBuilder.append("appended with string builder.");
        System.out.println("String in sBuffer: " + sBuffer);
        System.out.println("String in sBuilder: " + sBuilder);
        sBuffer = new StringBuffer("AABCABBC");
        sBuilder = new StringBuilder("abaabcabac");
        //insert stirng in between the old string
        sBuffer.insert(5, "armanislam");//insert substirng at index 5
        sBuilder.insert(3, "XYZ");//insert substirng at index 3
        System.out.println("String in sBuffer: " + sBuffer);
        System.out.println("String in sBuilder: " + sBuilder);
        //reverse the string
        sBuffer.reverse();
        sBuilder.reverse();
        System.out.println("Reversed StringBuffer:  " + sBuffer);
        System.out.println("Reversed StringBuilder:  " + sBuilder);
        //delete a substring
        sBuffer.delete(3, 6);
        sBuilder.delete(3, 6);
        System.out.println("String in sBuffer: " + sBuffer);
        System.out.println("String in sBuilder: " + sBuilder);
    }

}
