package org.graphite.onething;

import org.graphite.onething.util.GetProperties;
import org.jooq.DSLContext;
import org.jooq.SQLDialect;
import org.jooq.impl.DSL;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DataConnection {

    private static Connection connection = null;
    private static DSLContext dslContext = null;

    private Connection getConnection() {
        try {
            Properties properties = new GetProperties().getDBProperties();
            if (connection == null) {
                try {
                    connection = DriverManager.getConnection(properties.getProperty("dbUrl"),
                            properties.getProperty("userName"),
                            properties.getProperty("password"));
                } catch (SQLException throwables) {
                    throwables.printStackTrace();
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return connection;
    }


    public DSLContext getDSL() {
        if (dslContext == null) {
            dslContext = DSL.using(getConnection(), SQLDialect.POSTGRES);
        }
        return dslContext;
    }

}


