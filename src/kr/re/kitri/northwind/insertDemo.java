package kr.re.kitri.northwind;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 * Created by danawacomputer on 2017-05-10.
 */
public class insertDemo {

    public static final String DRIVER_POSTGRES = "org.postgresql.Driver";
    public static final String DB_URL = "jdbc:postgresql://localhost/northwind";
    public static final String USERNAME = "postgres";
    public static final String PASSWORD = "alfp1357";

    public static void main(String args[]) {

        //driver looding
        try {
            Class.forName(DRIVER_POSTGRES);
            System.out.println("driver loading ok...");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        String aa = "'efefef'"; // 왜 "" 안에 ''를 넣는지 이제야 알겠구나!!!!
        String query =
                "INSERT INTO categories(categoryid, categoryname, description) " +
                "VALUES (112,"+ aa +", 'ㄷㄷㄷ');";
        int n = 150;
        byte b = (byte) n;
        // get a connetion
        try {
            Connection conn =
                    DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);

            PreparedStatement pstmt = conn.prepareStatement(query);
//            pstmt.setInt(1, 101);
//            pstmt.setString(2, "Desktop");
//            pstmt.setString(3, "집에 놓고 쓴느 컴퓨터");
            pstmt.executeUpdate();
            System.out.println("insert ok..");

            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
