import java.sql.*;

public class DeleteDataJDBC {
    Connection con = null;
    Statement stmt = null;

    DeleteDataJDBC() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/studentdb", "root", "");

        stmt = con.createStatement();

        String query = "DELETE FROM personal WHERE rollno = 4";
        int result = stmt.executeUpdate(query);
        if (result > 0) {
            System.out.println("Data deleted successfully.");
        } else {
            System.out.println("Failed to delete data.");
        }
        con.close();
    }

    public static void main(String args[]) {
        try {
            new DeleteDataJDBC();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
