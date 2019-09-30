public class Summation {
    public static void main(String[] args){
        String str[] = {"5", "5", "8", "9", "10"};
        int sum = 0;
        for (int i=0;i<str.length;i++){
            int myint = Integer.parseInt(str[i]);
            sum += myint;
        }
        System.out.println("数组中的各元素之和是：" +sum);
    }
}
