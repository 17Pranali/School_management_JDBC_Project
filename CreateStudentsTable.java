import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class CreateStudentsTable {
    
    public static void main(String[] args) throws Exception {
        try {
            // Database Connection
            String url = "jdbc:mysql://localhost:3306/KBPCOES";
            String userName = "root";
            String password = "Panu_173"; // Replace with your actual password
    
            Connection connection = DriverManager.getConnection(url, userName, password);
    
            // SQL Query to create a table for school students
            String createTableQuery = "CREATE TABLE IF NOT EXISTS students ("
                    + "student_id INT AUTO_INCREMENT PRIMARY KEY,"
                    + "student_name VARCHAR(255) NOT NULL,"
                    + "date_of_birth DATE NOT NULL,"
                    + "grade VARCHAR(10) NOT NULL,"
                    + "address VARCHAR(255) NOT NULL"
                    + ")";
    
            Statement statement = connection.createStatement();
            statement.executeUpdate(createTableQuery);
            statement.close();
    
            JOptionPane.showMessageDialog(null, "Students table has been created successfully", "System Message", JOptionPane.INFORMATION_MESSAGE);
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
