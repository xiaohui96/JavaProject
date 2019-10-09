import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipInputStream;

public class Decompressing {
    private static void main(String[] temp){
        File file = new File("test.zip");
        ZipInputStream zin;
        try {
            // 创建压缩文件对象
            ZipFile zipfile = new ZipFile(file);
            // 实例化对象
            zin = new ZipInputStream(new FileInputStream(file));
            // 跳过目录获取下一个ZipEntry
            ZipEntry entry = zin.getNextEntry();
            while ((entry!=null)&&(!entry.isDirectory())){
                // 解压出的文件路径
                File tmp = new File("D:\\" +entry.getName());
                if(!tmp.exists()){
                    // 如果文件不存在，创建文件父类文件夹路径
                    tmp.getParentFile().mkdir();
                    // 文件目录中的文件放入输出流
                    OutputStream os = new FileOutputStream(tmp);
                    InputStream in = zipfile.getInputStream(entry);
                    int count = 0;
                    while((count=in.read())!=-1){
                        os.write(count);
                    }
                    os.close();
                    in.close();
                }
                zin.closeEntry();
                System.out.println(entry.getName()+"解压成功");
            }
            zin.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
