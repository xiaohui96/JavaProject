import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class MyZip {
    private void zip(String zipFileName, File inputFile)throws Exception{
        // 创建ZipOutputStream类对象
        ZipOutputStream out = new ZipOutputStream(new FileOutputStream(zipFileName));
        // 调用方法
        zip(out,inputFile,"");
        System.out.println("压缩中");
        out.close();
    }
    private void zip(ZipOutputStream out, File f, String base) throws Exception{
        if (f.isDirectory()){
            File[] fl = f.listFiles();
            if(base.length()!=0){
                // 写入此目录的entry
                out.putNextEntry(new ZipEntry(base + "/"));
            }
            for(int i=0;i<fl.length;i++){
                zip(out,fl[i],base+fl[i]);
            }
        }else{
            // 创建新的进入点
            out.putNextEntry(new ZipEntry(base));
            FileInputStream in = new FileInputStream(f);
            int b;
            System.out.println(base);
            // 如果没有到达流的尾部
            while((b=in.read())!=-1){
                out.write(b);
            }
            in.close();
        }
    }
    public static void main(String[] temp){
        MyZip book = new MyZip();
        try {
            book.zip("D:/test.zip", new File("D:/test"));
            System.out.println("压缩完成");
        }catch (Exception ex){
            ex.printStackTrace();
        }

    }
}
