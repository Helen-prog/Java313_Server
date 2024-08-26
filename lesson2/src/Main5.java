import java.sql.*;

public class Main5 {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/users";
        String username = "root";
        String password = "123456";

        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            connection.setAutoCommit(false);
            try {
                Statement statement = connection.createStatement();
//            statement.addBatch("INSERT INTO employees (name, job, salary) VALUES('Igor', 'HR Manager', 65000.0)");
//            statement.addBatch("INSERT INTO employees (name, job, salary) VALUES('Oleg', 'C++ Developer', 82000.0)");
//            statement.addBatch("INSERT INTO employees (name, job, salary) VALUES('Petr', 'JS Developer', 67000.0)");
                statement.addBatch("INSERT INTO employees VALUES(10, 'Oleg', 'C++ Developer', 82000.0)");
                statement.addBatch("INSERT INTO employees VALUES(9, 'Igor', 'HR Manager', 65000.0)");
                statement.addBatch("INSERT INTO employees VALUES(11, 'Petr', 'JS Developer', 67000.0)");
                statement.executeBatch();
                connection.commit();
                System.out.println("Пакетная обработка прошла успешно");
            } catch (BatchUpdateException ex){
                connection.rollback();
                System.out.println("Ошибка пакетной обработки");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
