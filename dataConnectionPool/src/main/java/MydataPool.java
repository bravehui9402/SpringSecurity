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


    private Integer initSize; //��ʼ����������
    private Integer maxActive; //������ӳ�����
    private Integer minIdle;   //��С���ӳ�����


    //���� --- ���ݿ����ӳ�
    private LinkedList<Connection> dataSources = new LinkedList<Connection>();

    //��ʼ����������
    MydataPool( String url,String driverClassName,String username,String password,Integer initSize,Integer maxActive,Integer minIdle) {
        System.out.println("��ʼ�����ݿ����ӳ�ing������");
        this.url = url;
        this.driverClassName = driverClassName;
        this.username = username;
        this.password = password;
        this.initSize = initSize;
        this.maxActive = maxActive;
        this.minIdle = minIdle ;
        //һ���Դ���10������
        for(int i = 0; i < initSize; i++) {
            try {
                //1��װ��sqlserver��������
                Class.forName(driverClassName);
                //2��ͨ��JDBC�������ݿ�����
                Connection con = DriverManager.getConnection(url,username,password);
                //3�������Ӽ������ӳ���
                dataSources.add(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }


    @Override
    public Connection getConnection() throws SQLException {
        if(dataSources.size()  >=  maxActive){//�������µ�����ʱ�������ж��Ƿ��Ѿ��ﵽ���������
            System.out.println("���ݿ����ӳص�����������������ܾ��������ӣ�");
            return null;
        }else{
            if(dataSources.size() <= minIdle){//û�дﵽ������ӣ���Ҫ�ж��Ƿ�ﵽ��С�����������û�дﵽ��С�����������½����Ӳ����뵽���ӳ���
                System.out.println("û�е�����С�������������½����ӡ�");
                Connection con = DriverManager.getConnection(url,username,password);
                dataSources.add(con);
                return con;
            }else { //�ﵽ��С�������������ж��Ƿ��ɿ��е����ӣ�����оʹ����ӳ��л�ȡ�����û�о��½�
                for (Connection con :dataSources){
                    System.out.println("������С�������������ӳ����п������ӣ����ÿ�������");
                    if(con.isValid(1)){//�жϸ������Ƿ���Ч
                        dataSources.remove(con);
                        return con;
                    }
                }
                //ͨ������ѭ�������ж����ӳ���û�п��õ����ӣ����½����Ӳ����뵽���ӳ��в�����
                System.out.println("������С�������������ӳ���û�п������ӣ��½�����");
                Connection con = DriverManager.getConnection(url,username,password);
                dataSources.add(con);
                return con;
            }
        }
    }

    //�����ӷŻ����ӳ�
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
