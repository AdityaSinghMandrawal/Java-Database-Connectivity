import java.sql.*;

public class FetchDataJDBC {
    Connection con = null;
    Statement stml = null;

    FetchDataJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");

        stml = con.createStatement();

        ResultSet rs = stml.executeQuery("SELECT * FROM personal");
        System.out.println("Roll No.\tStudent Name \tCourse \tBranch \t");
        while (rs.next()) {
            System.out.print(rs.getInt("rollno") + "       \t");
            System.out.print(rs.getString("name") + "       \t");
            System.out.print(rs.getString("course") + "       \t");
            System.out.println(rs.getString("branch") + "       \t");
        }
        con.close();
    }

    public static void main(String args[]) {
        try {
            new FetchDataJDBC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
