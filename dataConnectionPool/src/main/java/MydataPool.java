import com.sun.org.apache.xml.internal.security.Init;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.LinkedList;
import java.util.logging.Logger;

public class MydataPool implements DataSource {


    private String url;
    private String driverClassName;
    private String username;
    private String password;


    private Integer initSize; //初始化连接数量
    private Integer maxActive; //最大连接池数量
    private Integer minIdle;   //最小连接池数量


    //链表 --- 数据库连接池
    private LinkedList<Connection> dataSources = new LinkedList<Connection>();

    //初始化连接数量
    MydataPool( String url,String driverClassName,String username,String password,Integer initSize,Integer maxActive,Integer minIdle) {
        System.out.println("初始化数据库连接池ing。。。");
        this.url = url;
        this.driverClassName = driverClassName;
        this.username = username;
        this.password = password;
        this.initSize = initSize;
        this.maxActive = maxActive;
        this.minIdle = minIdle ;
        //一次性创建10个连接
        for(int i = 0; i < initSize; i++) {
            try {
                //1、装载sqlserver驱动对象
                Class.forName(driverClassName);
                //2、通过JDBC建立数据库连接
                Connection con = DriverManager.getConnection(url,username,password);
                //3、将连接加入连接池中
                dataSources.add(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        if(dataSources.size()  >=  maxActive){//当请求新的连接时，首先判断是否已经达到最大连接数
            System.out.println("数据库连接池到达最大连接数量，拒绝开启连接！");
            return null;
        }else{
            if(dataSources.size() <= minIdle){//没有达到最大连接，就要判断是否达到最小连接数，如果没有达到最小连接数，就新建连接并放入到连接池中
                System.out.println("没有到达最小连接数，进行新建连接。");
                Connection con = DriverManager.getConnection(url,username,password);
                dataSources.add(con);
                return con;
            }else { //达到最小连接数，首先判断是否由空闲的链接，如果有就从链接池中获取，如果没有就新建
                for (Connection con :dataSources){
                    System.out.println("到达最小连接数，但连接池中有空闲连接，复用空闲连接");
                    if(con.isValid(1)){//判断该链接是否有效
                        dataSources.remove(con);
                        return con;
                    }
                }
                //通过上述循环可以判断链接池中没有可用的链接，就新建连接并放入到连接池中并返回
                System.out.println("到达最小连接数，但连接池中没有空闲连接，新建连接");
                Connection con = DriverManager.getConnection(url,username,password);
                dataSources.add(con);
                return con;
            }
        }
    }

    //将连接放回连接池
    public void releaseConnection(Connection conn) {
        dataSources.add(conn);
    }


    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }


    @Override
    public <T> T unwrap(Class<T> iface) throws SQLException {
        return null;
    }

    @Override
    public boolean isWrapperFor(Class<?> iface) throws SQLException {
        return false;
    }

    @Override
    public PrintWriter getLogWriter() throws SQLException {
        return null;
    }

    @Override
    public void setLogWriter(PrintWriter out) throws SQLException {

    }

    @Override
    public void setLoginTimeout(int seconds) throws SQLException {

    }

    @Override
    public int getLoginTimeout() throws SQLException {
        return 0;
    }

    @Override
    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
        return null;
    }
}
