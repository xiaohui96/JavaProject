import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;
// 创建类，该类为多线程执行程序
public class Weather extends Thread{
    String weather = "节目预报：八点有大型晚会，请收听";
    // 定义端口
    int port = 9898;
    // 创建InetAddress对象
    InetAddress iaddress = null;
    // 声明多点广播套接字
    MulticastSocket socket = null;
    Weather(){
        try {
            // 实例化InetAddress，指定地址
            iaddress = InetAddress.getByName("224.255.10.0");
            // 实例化多点广播套接字
            socket =  new MulticastSocket(port);
            // 指定发送范围是本地网络
            socket.setTimeToLive(1);
            // 加入广播组
            socket.joinGroup(iaddress);
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (true){
            DatagramPacket packet = null;
            byte data[] = weather.getBytes();
            // 数据打包
            packet = new DatagramPacket(data, data.length, iaddress, port);
            // 将广播信息输出
            System.out.println(new String(data));
            try {
                socket.send(packet);
                sleep(1000);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    public static void main(String[] args){
        Weather w = new Weather();
        w.start();
    }
}
