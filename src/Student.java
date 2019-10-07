import java.io.*;

public class Student {
    public static void main(String[] args){
        // 定义字符串数组
        String content[] ={"好久不见","Hello World","HaHaHa"};
        File file = new File("word.text");
        try {
            FileWriter fw = new FileWriter(file);
            // 定义BufferWriter类对象
            BufferedWriter bufw = new BufferedWriter(fw);
            for (int k=0;k<content.length;k++){
                bufw.write(content[k]);
                // 写入行分隔符
                bufw.newLine();
            }
            bufw.close();
            fw.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            FileReader fr = new FileReader(file);
            BufferedReader bufr = new BufferedReader(fr);
            String s = null;
            int i = 0;
            while ((s=bufr.readLine())!=null){
                i++;
                System.out.println("第" + i +"行：" +s);
            }
            bufr.close();
            fr.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
