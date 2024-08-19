package example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Scanner;

public class ReservationSystem {
    private static final String url = "jdbc:mysql://localhost:3306/hotel_db";
    private static final String username = "root";
    private static final String password = "123456";

    public static void main(String[] args) {
        try {
            Connection connection = DriverManager.getConnection(url, username, password);
            while (true) {
                System.out.println("\nСИСТЕМА БРОНИРОВАНИЯ ОТЕЛЯ");
                Scanner input = new Scanner(System.in);
                System.out.println("1. Бронирование номера");
                System.out.println("2. Просмотр бронирования");
                System.out.println("3. Уточнить номер комнаты");
                System.out.println("4. Обновить бронирование");
                System.out.println("5. Удалить бронирование");
                System.out.println("0. Выход");
                System.out.print("Выберите опцию: ");
                int choice = input.nextInt();
                switch (choice){
                    case 0:

                        input.close();
                        return;
                    default:
                        System.out.println("Неверный выбор. Попробуйте еще раз.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
