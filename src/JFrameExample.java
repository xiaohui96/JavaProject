import java.awt.*;
import javax.swing.*;

public class JFrameExample extends JFrame{
    public void CreateJFrame(String title){
        // 实例化一个JFrame对象
        JFrame jf = new JFrame(title);
        // 获取一个容器
        Container container = jf.getContentPane();
        // 创建一个JLabel标签
        JLabel jl = new JLabel("这是一个JFrame窗口");
        // 标签上的文字居中
        jl.setHorizontalAlignment(SwingConstants.CENTER);
        // 标签添加到容器
        container.add(jl);
        container.setBackground(Color.white);
        // 窗体可视
        jf.setVisible(true);
        // 窗体大小
        jf.setSize(400,300);
        // 窗口关闭方式
        jf.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
    }
    public static void main(String[] args){
        new JFrameExample().CreateJFrame("创建一个JFrame窗体");
    }
}
