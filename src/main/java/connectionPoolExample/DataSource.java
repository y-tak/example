package connectionPoolExample;

import com.mchange.v2.c3p0.ComboPooledDataSource;
import javafx.scene.chart.PieChart;

import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;

public class DataSource {
    private static volatile  DataSource dataSource;
    private ComboPooledDataSource cdap;

    private DataSource() throws PropertyVetoException {
        cdap=new ComboPooledDataSource();
        cdap.setDriverClass("org.postgresql.Driver");
        cdap.setJdbcUrl("jdbc:postgresql://localhost:5433/BD");
        cdap.setUser("root");
        cdap.setPassword("root");
        cdap.setMinPoolSize(1);
        cdap.setMaxPoolSize(10);

    }

    public  static  DataSource getInstance()
    {
        if (dataSource==null)
        {synchronized (DataSource.class)
        {
            try {
                dataSource=new DataSource();
            } catch (PropertyVetoException e) {
                e.printStackTrace();
            }
        }
        }
        return dataSource;
    }

    public Connection connection() throws SQLException {
        return cdap.getConnection();
    }

    public static Connection getConnection() throws SQLException {
        return getInstance().connection();
    }

}
class ConnectionPool
{
    public static void main(String[] args) {
        try {
            Connection connection=DataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
