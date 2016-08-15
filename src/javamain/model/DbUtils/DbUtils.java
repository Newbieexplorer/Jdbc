package javamain.model.DbUtils;

import javamain.model.Data;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Виктор on 29.07.2016.
 */
public class DbUtils {

    private static final java.lang.String DB_DRIVER = "com.mysql.jdbc.Driver";
    private static final java.lang.String DB_CONNECTION = "jdbc:mysql://localhost:3306/HERO";
    private static final String DB_USER = "root";
    private static final String DB_PASSWORD = "";

    private static Connection getDBConnection() {
        Connection dbConnection = null;
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            dbConnection = DriverManager.getConnection(DB_CONNECTION, DB_USER, DB_PASSWORD);
            return dbConnection;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return dbConnection;
    }

    public static void createDbUserTable() throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String createTableSQL = "CREATE TABLE example (\n" +
                "id INT," +
                "data VARCHAR(100)" +
                ");";

        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Table \"dbuser\" is created!");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static void insertData(String data, int id) throws SQLException {
        Connection dbConnection = null;
        Statement statement = null;
        String createTableSQL = "INSERT INTO example"
                + "(id,data) " + "VALUES"
                + "(" + id + "," + "'" + data + "');";
        try {
            dbConnection = getDBConnection();
            statement = dbConnection.createStatement();
            // выполнить SQL запрос
            statement.execute(createTableSQL);
            System.out.println("Data created:" + "data");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            if (statement != null) {
                statement.close();
            }
            if (dbConnection != null) {
                dbConnection.close();
            }
        }
    }

    public static List<Data> getAllData() {
        try {
            List<Data> datas = new ArrayList<>();
            String selectTableSQL = "SELECT id, data from example";
            Connection dbConnection = getDBConnection();
            Statement statement = dbConnection.createStatement();
            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                String id = rs.getString("id");
                String data = rs.getString("data");
                Data curData = new Data(id, data);
                datas.add(curData);
                System.out.println("id : " + id);
                System.out.println("data : " + data);
            }
            return datas;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    public static Data getDataByID(int id) {
        try {
            String selectTableSQL = "SELECT id, data from example WHERE id=" + id;
            Connection dbConnection = getDBConnection();
            Statement statement = dbConnection.createStatement();
            // выбираем данные с БД
            ResultSet rs = statement.executeQuery(selectTableSQL);
            rs.next();
            String data = rs.getString("data");
            Data curData = new Data(id, data);
            System.out.println("id : " + id);
            System.out.println("data : " + data);
            return curData;
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }


}
