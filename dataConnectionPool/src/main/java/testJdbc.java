import java.sql.*;

public class testJdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       //1、加载驱动
       Class.forName("com.mysql.jdbc.Driver");
       //2、获取数据库连接
       Connection connection = DriverManager.getConnection("jdbc:mysql://121.43.100.25:3306/vhr","root","Lh655413.");
       //3、获取statement
       Statement statement = connection.createStatement();
       //4、执行sql并获取结果
       ResultSet resultSet = statement.executeQuery("select * from hr");
       //5、遍历结果
       while(resultSet.next()){
           System.out.println("id : "+resultSet.getInt(1)+"  name : " + resultSet.getString(2));
       }
       //6、关闭连接
       connection.close();
        System.out.println("-------------------------------------------------------");
        MydataPool mydataPool = new MydataPool("jdbc:mysql://121.43.100.25:3306/vhr","com.mysql.jdbc.Driver","root","Lh655413.",10,20,15);
        Connection connection1 = mydataPool.getConnection();
        //3、获取statement
        Statement statement1 = connection1.createStatement();
        //4、执行sql并获取结果
        ResultSet resultSet1 = statement1.executeQuery("select * from hr");
        //5、遍历结果
        while(resultSet1.next()){
            System.out.println("id : "+resultSet1.getInt(1)+"  name : " + resultSet1.getString(2));
        }
    }
}
