package net.therap.database;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

/**
 * Created with IntelliJ IDEA.
 * User: diptopol
 * Date: 7/3/13
 * Time: 3:10 PM
 * To change this template use File | Settings | File Templates.
 */
public class DatabaseConnectionPool {

    private static DataSource dataSource;
    private static String JDBC_DRIVER;
    private static String JDBC_URL;
    private static String DB_USER;
    private static String DB_PASSWORD;

    static {
        try {
            final ResourceBundle config = ResourceBundle.getBundle("props/database");
            JDBC_DRIVER = config.getString("JDBC_DRIVER");

            JDBC_URL = config.getString("JDBC_URL");
            DB_USER = config.getString("DB_USER");
            DB_PASSWORD = config.getString("DB_PASSWORD");
            System.out.println(JDBC_DRIVER+" "+JDBC_URL+" "+DB_USER+" "+DB_PASSWORD);
        } catch (MissingResourceException e) {
            e.printStackTrace();
        }

        dataSource =  getDataSource();

    }

    public static Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

    private static DataSource getDataSource() {

        System.out.println("creating datasource");
        ComboPooledDataSource cpDataSource = new ComboPooledDataSource();
        System.out.println(cpDataSource);
        try {
            cpDataSource.setDriverClass(JDBC_DRIVER);

        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }

        cpDataSource.setJdbcUrl(JDBC_URL);
        cpDataSource.setUser(DB_USER);
        cpDataSource.setPassword(DB_PASSWORD);

        cpDataSource.setMinPoolSize(5);
        cpDataSource.setAcquireIncrement(5);
        cpDataSource.setMaxPoolSize(20);


        return cpDataSource;
    }



}

