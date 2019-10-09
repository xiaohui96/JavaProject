import java.io.*;
import java.net.*;
import java.net.Socket;

public class MyServer {
    private BufferedReader reader;
    private ServerSocket server;
    private Socket socket;
    void getServer(){
        try{
            server = new ServerSocket(8998);
            System.out.println("服务器套接字已创建成功");
            while (true){
                System.out.println("等待客户机的连接");
                // 实例化Socket对象
                socket = server.accept();
                // 实例化BufferedReader对象
                reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                getClientMessage();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    private void getClientMessage(){
        try {
            while (true){
                System.out.println("客户机:" +reader.readLine());
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        try {
            if(reader!=null){
                //关闭流
                reader.close();
            }
            if(socket!=null){
                // 关闭套接字
                socket.close();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
    public static void main(String[] args){
        MyServer server = new MyServer();
        server.getServer();
    }
}
