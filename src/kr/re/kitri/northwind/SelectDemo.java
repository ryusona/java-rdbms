package kr.re.kitri.northwind;

import java.sql.*;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class SelectDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "alfp1357";

    public static void main(String args[]) {

        try {
            Class.forName(DRIVER_POSTGRES);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

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

            while (rs.next()) { // 마지막에 값이 없으면 false
                System.out.print(rs.getString(1) + "\t");
                System.out.print(rs.getString(2) + "\t");
                System.out.print(rs.getString(3) + "\t");
                System.out.print(rs.getString(4) + "\t");
                System.out.print(rs.getString(5) + "\t");
                System.out.print(rs.getString(6) + "\n");
            }

            conn.close();
            System.out.println("connection closed..");

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}
