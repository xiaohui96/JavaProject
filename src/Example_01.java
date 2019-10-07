import java.io.*;

public class Example_01 {
    public static void main(String[] args){
        File file = new File("Example_01.text");
        try {
            FileOutputStream fs = new FileOutputStream(file);
            DataOutputStream ds = new DataOutputStream(fs);
            ds.writeUTF("使用writeUTF()方法写入数据;");
            //ds.writeBytes("使用writeBytes()方法写入数据");
            //ds.writeChars("使用writeChars()方法写入数据");
            ds.close();
            FileInputStream fis = new FileInputStream(file);
            DataInputStream dis = new DataInputStream(fis);
            System.out.println(dis.readUTF());
            //System.out.println(dis.readByte());
            //System.out.println(dis.readChar());

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
