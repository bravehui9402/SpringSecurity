import java.sql.*;

public class testJdbc {

    public static void main(String[] args) throws ClassNotFoundException, SQLException {
       //1����������
       Class.forName("com.mysql.jdbc.Driver");
       //2����ȡ���ݿ�����
       Connection connection = DriverManager.getConnection("jdbc:mysql://121.43.100.25:3306/vhr","root","Lh655413.");
       //3����ȡstatement
       Statement statement = connection.createStatement();
       //4��ִ��sql����ȡ���
       ResultSet resultSet = statement.executeQuery("select * from hr");
       //5���������
       while(resultSet.next()){
           System.out.println("id : "+resultSet.getInt(1)+"  name : " + resultSet.getString(2));
       }
       //6���ر�����
       connection.close();
        System.out.println("-------------------------------------------------------");
        MydataPool mydataPool = new MydataPool("jdbc:mysql://121.43.100.25:3306/vhr","com.mysql.jdbc.Driver","root","Lh655413.",10,20,15);
        Connection connection1 = mydataPool.getConnection();
        //3����ȡstatement
        Statement statement1 = connection1.createStatement();
        //4��ִ��sql����ȡ���
        ResultSet resultSet1 = statement1.executeQuery("select * from hr");
        //5���������
        while(resultSet1.next()){
            System.out.println("id : "+resultSet1.getInt(1)+"  name : " + resultSet1.getString(2));
        }
    }
}
