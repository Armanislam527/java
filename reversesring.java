public class reversesring{
    public static void main(String[] args) {
        if(args.length == 0){
            System.out.println("No string provided to reverse");
            return;
        }
        for(String word : args){
            String reversed = new StringBuilder(word).reverse().toString();
            System.out.println("Original: "+ word +", reversed word: " + reversed);
        }
    }
}