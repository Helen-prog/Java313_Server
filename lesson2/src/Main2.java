import java.sql.*;

public class Main2 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "123456";
//        String query = "SELECT * FROM employees WHERE name = ?";
        String query = "INSERT INTO employees VALUES(?, ?, ?, ?)";
//        String query = "INSERT INTO employees (name, job, salary) VALUES(?, ?, ?)";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, 5);
            preparedStatement.setString(2, "Sergey");
            preparedStatement.setString(3, "Tester");
            preparedStatement.setDouble(4, 65000.0);

            int row = preparedStatement.executeUpdate();
            if (row > 0){
                System.out.println("Данные записаны успешно!");
            }
//            else {
//                System.out.println("Ошибка сохранения данных");
//            }
//            preparedStatement.setString(1, "Irina");
//            ResultSet resultSet = preparedStatement.executeQuery();
//
//            while (resultSet.next()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String job = resultSet.getString("job");
//                double salary = resultSet.getDouble("salary");
//
//                System.out.println("ID: " + id);
//                System.out.println("NAME: " + name);
//                System.out.println("JOB: " + job);
//                System.out.println("SALARY: " + salary);
//            }

//            resultSet.close();
            preparedStatement.close();
            connection.close();
        } catch (SQLException e){
            System.out.println("Ошибка сохранения данных");
//            e.printStackTrace();
        }
    }
}
