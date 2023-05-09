package org.example.homework;

import com.mchange.v2.c3p0.ComboPooledDataSource;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ResourceBundle;



import java.beans.PropertyVetoException;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import javax.sql.DataSource;



public class Database {
    private static final String DB_USERNAME="system";
    private static final String DB_PASSWORD="system";
    private static final String DB_URL ="jdbc:oracle:thin:@localhost:1521:xe";
    private static final String DB_DRIVER_CLASS="oracle.jdbc.driver.OracleDriver";


    private static ComboPooledDataSource dataSource = null;
    static{
        try {


            dataSource = new ComboPooledDataSource();
            dataSource.setDriverClass(DB_DRIVER_CLASS);

            dataSource.setJdbcUrl(DB_URL);
            dataSource.setUser(DB_USERNAME);
            dataSource.setPassword(DB_PASSWORD);

            dataSource.setMinPoolSize(5);
            dataSource.setAcquireIncrement(1);
            dataSource.setMaxPoolSize(2000);



        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }

    public static DataSource getDataSource(){
        return dataSource;
    }
}