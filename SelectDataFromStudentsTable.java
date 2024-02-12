import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class SelectDataFromStudentsTable {

    public static void main(String[] args) {
        selectDataFromStudents();
    }

    public static void selectDataFromStudents() {
        try {
            // Database Connection
            String url = "jdbc:mysql://localhost:3306/KBPCOES";
            String userName = "root";
            String password = "Panu_173"; // Replace with your actual password

            Connection connection = DriverManager.getConnection(url, userName, password);

            // SQL Query to select data from the "students" table
            String selectQuery = "SELECT * FROM students";

            // Prepared Statement for executing the query
            PreparedStatement preparedStatement = connection.prepareStatement(selectQuery);

            // Execute the query and get the result set
            ResultSet resultSet = preparedStatement.executeQuery();

            // Print the results
            System.out.println("Student Records:");
            System.out.printf("%-12s %-30s %-15s %-10s %-30s%n",
                    "Student ID", "Student Name", "Date of Birth", "Grade", "Address");

            while (resultSet.next()) {
                int studentId = resultSet.getInt("student_id");
                String studentName = resultSet.getString("student_name");
                String dateOfBirth = resultSet.getString("date_of_birth");
                String grade = resultSet.getString("grade");
                String address = resultSet.getString("address");

                System.out.printf("%-12d %-30s %-15s %-10s %-30s%n",
                        studentId, studentName, dateOfBirth, grade, address);
            }

            // Close resources
            resultSet.close();
            preparedStatement.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
