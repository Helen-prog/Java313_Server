package cs;
//
//import java.io.DataInputStream;
//import java.io.DataOutputStream;
//import java.io.IOException;
//import java.net.InetAddress;
//import java.net.ServerSocket;
//import java.net.Socket;
//
//public class Server extends Thread {
//    private static final int port = 5555;
//    private String MSG = "Клиент '%d' отправил мне сообщение: \n\t";
//    private String CONN = "Клиент '%d' закрыл соединение";
//
//    private Socket socket;
//    private int num;
//
//    public void setSocket(int num, Socket socket) {
//        this.num = num;
//        this.socket = socket;
//
//        start();
//    }
//
//    public void run() {
//        try {
//            DataInputStream dis = new DataInputStream(socket.getInputStream());
//            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());
//
//            String line;
//            while (true) {
//                line = dis.readUTF();
//                System.out.printf(MSG, num);
//                System.out.println(line);
//                System.out.println("Отправляю обратно...");
//                dos.writeUTF("Сервер получает текст: " + line);
//                dos.flush();
//                System.out.println();
//                if (line.equalsIgnoreCase("quit")) {
//                    socket.close();
//                    System.out.printf(CONN, num);
//                    break;
//                }
//            }
//        } catch (Exception e) {
//            System.out.println("Исключение: " + e);
//        }
//    }
//
//    public static void main(String[] args) {
//        ServerSocket srvSocket = null;
//        try {
//            try {
//                int i = 0;
//                InetAddress ia = InetAddress.getByName("localhost");
//                srvSocket = new ServerSocket(port, 0, ia);
//                System.out.println("Сервер запущен");
//
//                while (true){
//                    Socket socket = srvSocket.accept();
//                    System.err.println("\n\nКлиент принят");
//                    new Server().setSocket(i++, socket);
//                }
//            } catch (Exception e) {
//                System.out.println("Исключение: " + e);
//            }
//        } finally {
//            try {
//                if (srvSocket != null) {
//                    srvSocket.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  extends Thread {

    private static final int port = 7777; //создаем переменную "port" и задаем ей значение самостоятельно
    //создаем две строковые переменные для формирования сообщений об отправке и закрытии
    private String MSG = "Клиент '%d' отправил мне сообщение: \n\t";
    private String CONN = "Клиент '%d' закрыл соединение";

    private Socket socket; //создаем переменную "socket" типа класс Socket
    private int num;

    //создаем метод setSocket() с двумя аргументами: принимаемый "socket" типа Socket и "num" типа int
    public void setSocket(int num, Socket socket) {
        this.num = num; //присваиваем значение num (номер клиента)
        this.socket = socket; //присваиваем значение socket

        start(); // запускаем старт потока методом start() Метод start () класса thread используется для
        // начала выполнения thread. Результатом этого метода являются два потока, которые выполняются
        // одновременно: текущий поток (который возвращается из вызова метода start) и другой поток
        // (который выполняет свой метод run).
        // Метод start() внутренне вызывает метод run() интерфейса Runnable для выполнения кода,
        // указанного в методе run(), в отдельном потоке.
    }
    public void run() { //метод run() требует обработки исключений
        //создаем  входной и выходной потоки socket
        try {
            DataInputStream dis = new DataInputStream(socket.getInputStream()); //getInputStream() Возвращает входной поток
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream()); // выходной поток socket
            //сервер должен запуститься и жда от клиента сообщения
            String line; //создаем пременную в которую будут записываться сообщения
            while (true) { //т.к. сообщений может быть сколько угодно то созлаем бесконечный цикл
                line = dis.readUTF(); //метод readUTF() считывает из входного потока строку в кодировке UTF-8
                if (line.equalsIgnoreCase("y")) { // !!!!!!!!!!!!  если клиент прсылает сообщение "N"
                System.out.printf(MSG, num); //выводим "Клиент 'num' отправил мне сообщение:
                System.out.println(line); //выводим само сообщение
                System.out.println("Отправляю цитату..."); //т.к. используем протокол TCP мы должны подтвердить что данные к нам пришли

                String arr[] = new String[]{"Поспешишь - людей насмешишь", "Тише едешь - дальше будешь", "Мал золотник, да дорог", "Не рой другому яму сам, в нее попадешь"}; ////////////
                int min = 0, max = 3;
                int rand = min + (int) (Math.random() * ((max - min) + 1));
//                dos.writeUTF(arr[rand] + line);
                dos.writeUTF(arr[rand]); //!!!!!!!!!!!!!!!
                dos.flush(); //метод flush() отправляет (выталкивает) сообщение от сервера клиенту
                System.out.println();
                } //!!!!!!!!!!!!!!!
                if (line.equalsIgnoreCase("n")) { //если клиент прсылает сообщение "N"
                    socket.close(); //закрываем сеанс
                    System.out.printf(CONN, num); //выводим "Клиент 'num' закрыл соединение"
                    break; //поскольку цикл бесконечный принудительно выходим из него
                }
            }
        } catch (Exception e) {
            System.out.println("Исключение метода run() server: " + e); // если появляется исключение мы его выводим
        }
    }

    public static void main(String[] args) { //создаем основной метод main(String[] args)
        ServerSocket srvSocket = null; //создаем переменную "srvSocket" типа ServerSocket и присваиваем ей
        // значение null
        try {
            try {
                int i = 0; //переменная для счетчика количества подключений
                InetAddress ia = InetAddress.getByName("localhost"); //создаем перменную  ia экземпляра класса
                // InetAddress и методом getByName() передаем в нее доменное имя и IP-адрес локального сервера
                srvSocket = new ServerSocket(port, 0, ia); //создаем новый srvSocket экземпляр класса
                // ServerSocket с тремя параметрами "port", "", "ia"
                System.out.println("Сервер запущен");

                while (true) { //создаем бесконечный цикл ожидания подключения клиента
                    Socket socket = srvSocket.accept(); //создаем экеземпляр "socket" класса Socket и метод accept()
                    // ожидает подключения клиента
                    System.err.println("\n\nКлиент принят"); //после подключения клиента выволим сообщение "Клиент принят"
                    new Server().setSocket(i++, socket); //метод setSocket() устанавливает взаимодействие клиентской
                    // и серверной части, i  считает количество подключений
                }
            } catch (Exception e) {
                System.out.println("Исключение метода main() server: " + e);
            }
        } finally {
            try {
                if (srvSocket != null) { //если srvSocket не null
                    srvSocket.close(); //закрываем сеанс
                }
            } catch (IOException e) { //если возникнут исключения (ошибки потока ввовда-вывода)
                e.printStackTrace(); //то выводим сообщения об этих ошибках printStackTrace() прямо выводит
                // информацию в System. err , не принимая во внимание архитектуру приложения
            }
        }
    }
}
