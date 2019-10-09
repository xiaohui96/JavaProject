import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class SwingAndThread extends JFrame {
    // 声明JLabel对象
    private JLabel jl = new JLabel();
    // 声明线程对象
    private static Thread t;
    private int count = 0;
    // 声明容器
    private Container container = getContentPane();
    public SwingAndThread(){
        // 绝对定位窗体位置和大小
        setBounds(300,200,250,100);
        container.setLayout(null);
        // 获取图片的url
        URL url = SwingAndThread.class.getResource("");
        // 实例化一个Icon
        Icon icon = new ImageIcon(url);
        // 图标放置在标签中
        jl.setIcon(icon);
        // 设置图片在标签的最左方
        jl.setHorizontalAlignment(SwingConstants.LEFT);
        // 设置标签的位置和大小
        jl.setBounds(10,10,200,50);
        jl.setOpaque(true);
        // 定义匿名内部类，该类实现Runnable接口
        t = new Thread(new Runnable() {
            @Override
            public void run() {
                while(count <=20){
                    jl.setBounds(count,10,200,50);
                    try{
                        Thread.sleep(1000);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                    count += 4;
                    if(count == 200){
                        count = 10;
                    }
                }
            }
        });
        // 启动线程
        t.start();
        container.add(jl);
        setVisible(true);
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
    }
    public static void main(String[] args){
        new SwingAndThread();
    }
}
