package kr.re.kitri.northwind.service;

import kr.re.kitri.northwind.model.Customer;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class JdbcService {

    public List<Customer> makeList(String DB_URL, String USERNAME, String PASSWORD) {

        List<Customer> Customerlist = new ArrayList<>();

        String query = "SELECT customerid, " +
                "               companyname, " +
                "               contactname, " +
                "               address, " +
                "               city, " +
                "               phone" +
                " FROM          customers;";
//                " order by      contactname;";
        try {

            Connection conn =
                    DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(query);
            ResultSet rs = pstmt.executeQuery();

            while (rs.next()) {

                Customerlist.add(
                        new Customer(
                                rs.getString(1),
                                rs.getString(2),
                                rs.getString(3),
                                rs.getString(4),
                                rs.getString(5),
                                rs.getString(6)));
            }

            conn.close();
            System.out.println("connection_1 closed..");

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return Customerlist;
    }
}
