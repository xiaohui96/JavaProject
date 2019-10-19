import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class Receive extends JFrame implements Runnable, ActionListener {
    int port;
    // 声明InetAddress对象
    InetAddress group = null;
    // 创建多点广播套接字对象
    MulticastSocket socket = null;
    // 创建按钮对象
    JButton ince = new JButton("开始接收");
    JButton stop = new JButton("结束接收");
    // 显示接收广播的文字域
    JTextArea inceAr = new JTextArea(10,10);
    JTextArea inced = new JTextArea(10,10);
    Thread thread;
    boolean b = false;
    public Receive(){
        super("广播数据报");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        thread = new Thread(this);
        // 绑定按钮的单击事件
        ince.addActionListener(this);
        stop.addActionListener(this);
        // 指定文字域中文字的颜色
        inceAr.setForeground(Color.white);
        // 创建Jpanel对象
        JPanel north = new JPanel();
        // 将按钮添加到面板north上
        north.add(ince);
        north.add(stop);
        // 将north放置在窗体的上部
        add(north,BorderLayout.NORTH);
        // 创建面板对象center
        JPanel center = new JPanel();
        // 设置面板布局
        center.setLayout(new GridLayout(1,2));
        // 将文本域添加到面板上
        center.add(inceAr);
        center.add(inced);
        // 设置面板布局
        add(center, BorderLayout.CENTER);
        // 刷新
        validate();
        port = 9898;
        try{
            // 指定接收地址
         group = InetAddress.getByName("224.255.10.0");
         // 绑定多点广播套接字
         socket = new MulticastSocket(port);
         // 加入广播组
         socket.joinGroup(group);
        }catch (Exception e){
            e.printStackTrace();
        }
        // 设置布局
        setBounds(100,50,360,380);
        // 设置窗口为显示状态
        setVisible(true);
    }
    @Override
    public void run() {
        while (true){
            byte data[] = new byte[1024];
            DatagramPacket packet = null;
            // 待接收的数据包
            packet = new DatagramPacket(data,data.length,group,port);
            try{
                // 接收数据包
                socket.receive(packet);
                // 获取数据包中的内容
                String  message = new String(packet.getData(),0,packet.getLength());
                inceAr.setText("正在接收的内容：\n" + message);
                inced.append(message + "\n");
            }catch (Exception e){
                e.printStackTrace();
            }
            if(b == true){
                break;
            }
        }
    }
    public void actionPerformed(ActionEvent e){
        // 单击按钮ince触发的事件
        if(e.getSource() == ince){
            ince.setBackground(Color.red);
            stop.setBackground(Color.yellow);
            if(!(thread.isAlive())){
                thread = new Thread(this);
            }
            // 启动线程
            thread.start();
            b = false;
        }
        if(e.getSource() == stop){
            ince.setBackground(Color.yellow);
            stop.setBackground(Color.red);
            b = true;
        }
    }
    public static void main(String[] args){
        Receive rec = new Receive();
        rec.setSize(460,200);
    }
}
