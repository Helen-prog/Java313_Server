package jdbc.BankingManagmentSystem;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class BankingApp {
    private static final String url = "jdbc:mysql://localhost:3306/banking_system";
    private static final String username = "root";
    private static final String password = "123456";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            Scanner input = new Scanner(System.in);
            User user = new User(connection, input);

            while (true){
                System.out.println("*** ДОБРО ПОЖАЛОВАТЬ В БАНКОВСКУЮ СИСТЕМУ ***\n");
                System.out.println("1. Регистрация");
                System.out.println("2. Авторизация");
                System.out.println("3. Выход");
                System.out.print("Ваш выбор: ");
                int choice1 = input.nextInt();
                switch (choice1){
                    case 1:
                        user.register();
                        break;
                    case 3:
                        System.out.println("СПАСИБО ЗА ИСПОЛЬЗОВАНИЕ БАНКОВСКОЙ СИСТЕМЫ");
                        System.out.println("Выход из системы!");
                        return;
                    default:
                        System.out.println("Такого варианта нет");
                        break;
                }
            }

        } catch (SQLException e){
            e.printStackTrace();
        }
    }
}
