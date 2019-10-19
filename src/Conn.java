import java.sql.*;
public class Conn {
    // 声明Connection对象
    static Connection con;
    // 声明Statement对象
    static Statement sql;
    // 声明ResultSet对象
    static  ResultSet res;
    public Connection getConnection(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            System.out.println("加载数据库驱动成功");
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }
        try {
            con = DriverManager.getConnection("jdbc:mysql:"+"//192.168.46.111:3306/ncslab","root","");
            System.out.println("数据库连接成功");
        }catch (SQLException e){
            e.printStackTrace();
        }

        return con;
    }
    public static void main(String[] args){
        Conn c = new Conn();
        c.getConnection();
        try {
            // 实例化Statement对象
            sql = con.createStatement();
            // 执行SQL语句，返回结果集
            res = sql.executeQuery("select * from users");
            // 如果当前语句不是最后一条，则进入循环
            while (res.next()){
                String id = res.getString("id");
                String account = res.getString("account");
                String password = res.getString("password");
                String email = res.getString("email");
                System.out.println("id: " + id);
                System.out.println("account: " + account);
                System.out.println("password: " + password);
                System.out.println("email: " + email);
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
