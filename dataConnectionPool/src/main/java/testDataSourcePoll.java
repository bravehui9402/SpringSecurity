import com.alibaba.druid.pool.DruidDataSource;
import com.alibaba.druid.pool.DruidDataSourceFactory;
import com.alibaba.druid.pool.DruidPooledConnection;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class testDataSourcePoll {
    public static void main(String[] args) throws Exception {
        Properties properties = new Properties();
        properties.put("driverClassName:com","com.mysql.cj.jdbc.Driver");
        properties.put("url","jdbc:mysql://121.43.100.25:3306/vhr?characterEncoding=utf8&useSSL=true&serverTimezone=GMT");
        properties.put("username","root");
        properties.put("password","Lh655413.");
        DataSource source = DruidDataSourceFactory.createDataSource(properties);
        Connection connection = source.getConnection();
        //3、获取statement
        Statement statement = connection.createStatement();
        //4、执行sql并获取结果
        ResultSet resultSet = statement.executeQuery("select * from hr");
        //5、遍历结果
        while(resultSet.next()){
            System.out.println("id : "+resultSet.getInt(1)+"  name : " + resultSet.getString(2));
        }
    }
}
