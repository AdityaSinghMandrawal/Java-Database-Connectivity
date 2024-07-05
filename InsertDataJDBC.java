import java.sql.*;

public class InsertDataJDBC {
    Connection con = null;
    Statement stmt = null;

    InsertDataJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");

        stmt = con.createStatement();

        String query = "INSERT INTO personal (rollno, name, course, branch) VALUES (4, 'John Doe', 'B.Tech', 'CSE')";
        int result = stmt.executeUpdate(query);
        if (result > 0) {
            System.out.println("Data inserted successfully.");
        } else {
            System.out.println("Failed to insert data.");
        }
        con.close();
    }

    public static void main(String args[]) {
        try {
            new InsertDataJDBC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
