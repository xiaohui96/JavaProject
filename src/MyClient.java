import javax.swing.*;
import javax.swing.border.BevelBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.PrintWriter;
import java.net.Socket;

public class MyClient extends JFrame {
    // 声明PrintWriter对象
    private PrintWriter writer;
    // 声明Socket对象
    Socket socket;
    private JTextArea ta = new JTextArea();
    private JTextField tf = new JTextField();
    Container cc;
    // 构造方法
    public MyClient(String title){
        // 调用父类的方法
        super(title);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        // 实例化对象
        cc = this.getContentPane();
        final JScrollPane scrollPane = new JScrollPane();
        scrollPane.setBorder(new BevelBorder(BevelBorder.RAISED));
        getContentPane().add(scrollPane, BorderLayout.CENTER);
        scrollPane.setViewportView(ta);
        cc.add(tf,"South");
        tf.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // 文本框中信息写入流
                writer.println(tf.getText());
                // 文本框中信息显示在文本域中
                ta.append(tf.getText()+'\n');
                ta.setSelectionEnd(ta.getText().length());
                // 文本框清空
                tf.setText("");
            }
        });
    }
    // 连接套接字方法
    private void connect(){
        // 文本域提示信息
        ta.append("尝试连接\n");
        try{
            // 实例化socket对象
            socket = new Socket("127.0.0.1",8998);
            writer = new PrintWriter(socket.getOutputStream(),true);
            ta.append("完成连接\n");
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        MyClient client = new MyClient("向服务器发送数据");
        client.setSize(200,200);
        client.setVisible(true);
        client.connect();
    }
}
