import java.text.DecimalFormat;

public class DecimalFormatSimpleDemo {
    static private void UseApplyPatternMethodFormat(String Pattern, double value){
        DecimalFormat MyFormat = new DecimalFormat();
        MyFormat.applyPattern(Pattern);
        System.out.println(value + " " + Pattern +" " +MyFormat.format(value));
    }
    public static void main(String[] args){
        // 将数字转换成百分数形式
        UseApplyPatternMethodFormat("#.###%", 0.789);
        // 将小数点后两位格式为两位
        UseApplyPatternMethodFormat("#####.##", 123456.789);
        // 将数字转化成千分数的形式
        UseApplyPatternMethodFormat("0.00\u2030", 0.789);    }
}

