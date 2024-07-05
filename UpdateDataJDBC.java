import java.sql.*;

public class UpdateDataJDBC {
    Connection con = null;
    Statement stmt = null;

    UpdateDataJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");

        stmt = con.createStatement();

        String query = "UPDATE personal SET name = 'Jane Doe' WHERE rollno = 4";
        int result = stmt.executeUpdate(query);
        if (result > 0) {
            System.out.println("Data updated successfully.");
        } else {
            System.out.println("Failed to update data.");
        }
        con.close();
    }

    public static void main(String args[]) {
        try {
            new UpdateDataJDBC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
