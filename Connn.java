package bank.management.system;

import java.sql.*;

public class Connn {
    Connection connection;
    Statement statement;

    public Connn() {
        try {
            // Load the MS SQL Server JDBC driver
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            // Establish the connection with SQL Server authentication
            connection = DriverManager.getConnection(
                    "jdbc:sqlserver://DESKTOP-8VRI02D\\SQLEXPRESS:1433;databaseName=BankManagementSystem;user=sa;password=data123;encrypt=true;trustServerCertificate=true;"
            );

            // Create the statement
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
