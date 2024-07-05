import java.sql.*;
import java.util.Scanner;
public class StudentDatabaseManager {
    private Connection con = null;
    private PreparedStatement ps = null;
    private ResultSet rs = null;
    private Scanner scanner = new Scanner(System.in);
    public StudentDatabaseManager() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection("jdbc:mysql://localhost:3306/student_db", "root", "");
    }
    public void insertStudent() throws SQLException {
        System.out.println("Enter Student Roll Number:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter Student Name:");
        String name = scanner.nextLine();
        String sql = "INSERT INTO pers (id, name) VALUES (?, ?)";
        ps = con.prepareStatement(sql);
        ps.setInt(1, rollNumber);
        ps.setString(2, name);
        ps.executeUpdate();
        System.out.println("Student record inserted successfully.");
    }
    public void fetchRecords() throws SQLException {
        String sql = "SELECT * FROM pers";
        ps = con.prepareStatement(sql);
        rs = ps.executeQuery();
        System.out.println("Roll Number\tName");
        while (rs.next()) {
            System.out.print(rs.getInt("id") + "\t\t");
            System.out.println(rs.getString("name"));
        }
    }
    public void modifyRecord() throws SQLException {
        System.out.println("Enter Roll Number of the student to modify:");
        int rollNumber = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter new Student Name:");
        String newName = scanner.nextLine();
        String sql = "UPDATE pers SET name = ? WHERE id = ?";
        ps = con.prepareStatement(sql);
        ps.setString(1, newName);
        ps.setInt(2, rollNumber);
        int rowsUpdated = ps.executeUpdate();
        if (rowsUpdated > 0) {
            System.out.println("Student record updated successfully.");
        } else {
            System.out.println("No student found with the given roll number.");
        }
    }
    public void deleteRecord() throws SQLException {
        System.out.println("Enter Roll Number of the student to delete:");
        int rollNumber = scanner.nextInt();
        String sql = "DELETE FROM pers WHERE id = ?";
        ps = con.prepareStatement(sql);
        ps.setInt(1, rollNumber);
        int rowsDeleted = ps.executeUpdate();
        if (rowsDeleted > 0) {
            System.out.println("Student record deleted successfully.");
        } else {
            System.out.println("No student found with the given roll number.");
        }
    }
    public static void main(String[] args) {
        try {
            StudentDatabaseManager manager = new StudentDatabaseManager();
            manager.insertStudent();
            manager.fetchRecords();
            manager.modifyRecord();
            manager.fetchRecords();
            manager.deleteRecord();
            manager.fetchRecords();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
