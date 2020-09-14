package upup.implementation.classes.dbconnectionpool;

import javax.sql.DataSource;
import java.io.PrintWriter;
import java.sql.*;
import java.util.LinkedList;
import java.util.logging.Logger;

/**
 * @author Yuan Jiajun
 * @date 2020/9/12 13:23
 * @description @link
 */
public class DBConnection {
}

class EarlierConnection {
    //早期怎么进行数据库操作
    public void FindAllUsers() throws SQLException {
        //1、装载sqlserver驱动对象
        DriverManager.registerDriver(new SQLServerDriver());
        //2、通过JDBC建立数据库连接
        Connection con = DriverManager.getConnection("jdbc:sqlserver://192.168.2.6:1433;DatabaseName=customer", "sa", "123");
        //3、创建状态
        Statement state = con.createStatement();
        //4、查询数据库并返回结果
        ResultSet result = state.executeQuery("select * from users");
        //5、输出查询结果
        while (result.next()) {
            System.out.println(result.getString("email"));
        }
        //6、断开数据库连接
        result.close();
        state.close();
        con.close();
    }
}

class MyDBConnectionPool implements DataSource {
    //链表 --- 实现栈结构
    private final LinkedList<Connection> pool = new LinkedList<Connection>();

    //初始化连接数量
    public MyDBConnectionPool() {
        //一次性创建10个连接
        for (int i = 0; i < 10; i++) {
            try {
                //1、装载sqlserver驱动对象
                DriverManager.registerDriver(new SQLServerDriver());
                //2、通过JDBC建立数据库连接
                Connection con = DriverManager.getConnection(
                        "jdbc:sqlserver://192.168.2.6:1433;DatabaseName=customer", "sa", "123");
                //3、将连接加入连接池中
                pool.add(con);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Connection getConnection() throws SQLException {
        //取出连接池中一个连接
        final Connection conn = pool.removeFirst(); // 删除第一个连接返回
        return conn;
    }

    @Override
    public Connection getConnection(String username, String password) throws SQLException {
        return null;
    }

    //将连接放回连接池
    public void releaseConnection(Connection conn) {
        pool.add(conn);
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

class MyDBConnectionPoolTest {
    //查询所有用户
    public void FindAllUsers() throws SQLException {
        //1、使用连接池建立数据库连接
        MyDBConnectionPool pool = new MyDBConnectionPool();
        /** imp */
        Connection connection = pool.getConnection();

        //2、创建状态
        Statement state = connection.createStatement();
        //3、查询数据库并返回结果
        ResultSet result = state.executeQuery("select * from users");
        //4、输出查询结果
        while (result.next()) {
            System.out.println(result.getString("email"));
        }

        //5、断开数据库连接
        result.close();
        state.close();

        //6、归还数据库连接给连接池
        /** imp */
        pool.releaseConnection(connection);
    }
}