package kr.re.kitri.northwind;

import java.sql.*;

/**
 * Created by danawacomputer on 2017-05-08.
 */
public class NorthwindMain {

    public static void main(String args[]) {

        //1. postgreSQL 데이터베이스 JDBC 드라이버를 로딩한다.

        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("driver loading ok..");
            // 드라이버 로딩까지는 완료
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        // 2. 데이터베이스와 연결을 수행한다.
        // 즉, Connection 객체를 만든다.
        String dburl = "jdbc:postgresql://localhost/northwind";
        String username = "postgres";
        String password = "alfp1357";
        Statement stmt;
        ResultSet rs;
        try {
            Connection conn =
                    DriverManager.getConnection(dburl, username, password);
            System.out.println("Connection ok...");

//            String sql =
//                    "INSERT INTO public.sample( " +
//                            "first_name, last_name, age)" +
//                            "VALUES (?, ?, ?);";
//            PreparedStatement pstmt = conn.prepareStatement(sql);
//            pstmt.setString(1, "찬호");
//            pstmt.setString(2, "박");
//            pstmt.setInt(3, 25);
//            pstmt.executeUpdate();


            stmt = conn.createStatement();
            //데이터를 가져온다.
            rs = stmt.executeQuery("select orderid, customerid  from public.orders where orderid=10248" +
                    "INNER JOIN public.customers ON public.customers.customerid=public.orders.customerid;");

            System.out.println("값 가져와서 출력");
            while(rs.next()){
                //출력
                System.out.println(rs.getString("orderid"));

            }

            
            // 3. SQL문을 DB로 전달한다.

            conn.close();
            System.out.println("Connection closed...");
        } catch (SQLException e) {
            e.printStackTrace();
        }


    }
}
