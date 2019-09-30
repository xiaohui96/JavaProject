public class Compare {
    public static void main(String[] args){
        String c1 = new String("123");
        String c2 = new String("123");
        String c3 = c1;
        System.out.println("c2=c3的结果: " +(c2 == c3));
        System.out.println("c2.equals(c3)的结果: " +(c2.equals(c3)));
    }
}
