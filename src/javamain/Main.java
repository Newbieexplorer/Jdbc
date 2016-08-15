package javamain;

import javamain.model.Data;
import javamain.model.DbUtils.DbUtils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Виктор on 29.07.2016.
 */
public class Main {


    public static void main(String[] args) throws SQLException, ClassNotFoundException {
        insertData(true);
        List<Data> datas = DbUtils.getAllData();

        System.out.println(datas!=null?datas.toString():"LostItSelf");
        Data data = DbUtils.getDataByID(2);
        System.out.println(data!=null?data.toString():"LostItSelf");
    }

    private static void insertData(boolean createData) {
        try {
            DbUtils.insertData("one", 1);
            DbUtils.insertData("two", 2);
            DbUtils.insertData("KSO YARO", 3);
            DbUtils.insertData("DARASINAY", 4);
            DbUtils.insertData("Kusotare", 5);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


}
