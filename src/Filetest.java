import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Filetest {
    public static void main(String[] args){
        File file = new File("word.text");
        try {
            FileOutputStream out = new FileOutputStream(file);
            byte buy[] = "我有一头小毛驴，我从来也不骑.".getBytes();
            out.write(buy);
            out.close();
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            FileInputStream in = new FileInputStream(file);
            byte byt[] = new byte[1024];
            int len = in.read(byt);
            System.out.println("文件中的信息是: " + new String(byt,0,len));
            in.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
