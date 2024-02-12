import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.text.SimpleDateFormat;
import java.util.Date;

public class InsertDataIntoStudentsTable {
    
    public static void main(String[] args) {
        insertSampleData();
    }

    public static void insertSampleData() {
        try {
            // Database Connection
            String url = "jdbc:mysql://localhost:3306/KBPCOES";
            String userName = "root";
            String password = "Panu_173"; // Replace with your actual password
    
            Connection connection = DriverManager.getConnection(url, userName, password);
    
            // Sample data for insertion
            String[] studentNames = {"xyz", "anc", "pqy", "mnp", "qrs"};
            String[] birthDates = {"2005-01-15", "2004-08-22", "2006-03-10", "2005-12-05", "2004-06-20"};
            String[] grades = {"Grade 9", "Grade 10", "Grade 8", "Grade 11", "Grade 12"};
            String[] addresses = {"123 Main St, City1", "456 Oak Ave, City2", "789 Pine Rd, City3", "101 Cedar Blvd, City4", "202 Elm St, City5"};
    
            // SQL Query to insert data into the "students" table
            String insertQuery = "INSERT INTO students (student_name, date_of_birth, grade, address) VALUES (?, ?, ?, ?)";
    
            // Prepared Statement for efficient insertion
            PreparedStatement preparedStatement = connection.prepareStatement(insertQuery);
    
            // Inserting sample data
            for (int i = 0; i < 5; i++) {
                preparedStatement.setString(1, studentNames[i]);
                preparedStatement.setDate(2, java.sql.Date.valueOf(birthDates[i]));
                preparedStatement.setString(3, grades[i]);
                preparedStatement.setString(4, addresses[i]);
                preparedStatement.executeUpdate();
            }
    
            preparedStatement.close();
            System.out.println("Data inserted successfully into the 'students' table.");
    
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
