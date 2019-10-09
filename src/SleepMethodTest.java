import javax.swing.*;
import java.awt.*;
import java.util.Random;

public class SleepMethodTest extends JFrame {
    private Thread t;
    // 定义颜色数组
    private static Color[] color = {Color.BLACK, Color.blue, Color.cyan, Color.green, Color.orange,
            Color.YELLOW, Color.red, Color.pink, Color.LIGHT_GRAY};
    // 定义随机对象
    private static final Random rand = new Random();
    private static Color getC(){
        return color[rand.nextInt(color.length)];
    }
    public SleepMethodTest(){
        t = new Thread(new Runnable() {
            int x =30;
            int y =50;
            @Override
            public void run() {
                while (true){
                    try{
                        Thread.sleep(100);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                    // 获取组件绘图上下文对象
                    Graphics graphics = getGraphics();
                    // 设置绘图颜色
                    graphics.setColor(getC());
                    graphics.drawLine(x,y,100,y++);
                    if(y>=80){
                     y = 50;
                    }
                }
            }
        });
        // 启动线程
        t.start();
    }
    public static void main(String[] args){
        init(new SleepMethodTest(),100,100);
    }
    // 初始化界面的方法
    public static void init(JFrame frame, int width, int height){
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width, height);
        frame.setVisible(true);
    }
}
