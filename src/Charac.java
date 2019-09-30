public class Charac {
    public static void main(String[] args){
        String s1 = Integer.toString(456);
        String s2 = Integer.toOctalString(456);
        String s3 = Integer.toHexString(456);
        System.out.println("456的十进制表示为：" +s1);
        System.out.println("456的八进制表示为：" +s2);
        System.out.println("456的十六进制表示为：" +s3);
    }
}
