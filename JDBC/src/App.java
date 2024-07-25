import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class App {
    public static void main(String[] args) {
        // URL of the database
        String url = "jdbc:mysql://localhost:3306/mydatabase"; // Change "mydatabase" to your database name
        // Database credentials
        String user = "root"; // Change to your database username
        String password = "root"; // Change to your database password

        // 1. Load the JDBC driver (optional in newer versions)
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;

        try {
            // 2. Establish a connection
            connection = DriverManager.getConnection(url, user, password);

            // 3. Create a statement
            statement = connection.createStatement();

            // 4. Execute a query
            String query = "SELECT * FROM users"; // Change "users" to your table name
            resultSet = statement.executeQuery(query);

            // 5. Process the result set
            while (resultSet.next()) {
                // Assume your table has columns 'id', 'name', 'email'
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String email = resultSet.getString("email");

                System.out.println("ID: " + id + ", Name: " + name + ", Email: " + email);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            // 6. Close the resources
            try {
                if (resultSet != null) {
                    resultSet.close();
                }
                if (statement != null) {
                    statement.close();
                }
                if (connection != null) {
                    connection.close();
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
