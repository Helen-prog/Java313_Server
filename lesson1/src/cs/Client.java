package cs;
//
//import java.io.*;
//import java.net.InetAddress;
//import java.net.Socket;
//import java.util.Locale;
//
//public class Client {
//    private static final int serverPort = 5555;
//    private static final String localhost = "127.0.0.1";
//
//    public static void main(String[] args) {
//        Socket socket = null;
//        try {
//            try {
//                System.out.println("Добро пожаловать на клиентскую сторону\nПодключение к серверу\n\t(IP адрес " + localhost + ", порт "+ serverPort + ")");
//                InetAddress ipAddress = InetAddress.getByName(localhost);
//                socket = new Socket(ipAddress, serverPort);
//                System.out.println("Соединение установлено");
//
//                System.out.println("\tАдрес хоста = " + socket.getInetAddress().getHostAddress() + "\n\tРазмер буфера = " + socket.getReceiveBufferSize());
//
//                DataInputStream in = new DataInputStream(socket.getInputStream());
//                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
//
//                InputStreamReader isr = new InputStreamReader(System.in);
//                BufferedReader keyboard = new BufferedReader(isr);
//
//                String line;
//
//                while (true){
//                    System.out.print("Введите что-нибудь и нажмите Enter: ");
//                    line = keyboard.readLine();
//                    out.writeUTF(line);
//                    out.flush();
//                    line = in.readUTF();
//
//                    if(line.endsWith("quit")){
//                        break;
//                    } else {
//                        System.out.println("\nСервер отправил мне эту строку:\n\t" + line);
//                        System.out.println();
//                    }
//                }
//            } catch (Exception e) {
//                System.out.println("Исключение: " + e);
//            }
//        } finally {
//            try {
//                if (socket != null) {
//                    socket.close();
//                }
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }
//    }
//}

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {
    private static final int serverPort = 7777; //создаем переменную "port" и задаем ей значение такое же как у Server
    private static final String localhost = "127.0.0.1"; //создаем переменную "localhost" и задаем ей значение
    // IP-адреса локального сервера

    public static void main(String[] args) {
        Socket socket = null; //создаем переменную "socket" типа Socket и присваиваем ей значение null
        try {
            try {
                System.out.println("Добро пожаловать на клиентскую сторону");
                System.out.println(">> Подключение к серверу\t");
                InetAddress ipAddress = InetAddress.getByName(localhost); //создаем экземпляр ipAddress
                // класса InetAddress и присвоим ему значение IP-алреса локального сервера методом getByName(localhost)
                socket = new Socket(ipAddress, serverPort); //в переменную socket передаем значение IP-алреса
                // локального сервера и значение порта
                System.out.println(">> Соединение установлено"); //указываем что Соединение установлено

                //создаем входной и выходной потоки socket
                DataInputStream in = new DataInputStream(socket.getInputStream()); //getInputStream() Возвращает входной поток
                DataOutputStream out = new DataOutputStream(socket.getOutputStream()); //getOutputStream() Возвращает выходной поток

                //создаем входной поток для чтения с клавиатуры
                InputStreamReader isr = new InputStreamReader(System.in); //создаем экземпляр isr класса InputStreamReader для чтения с клавиатуры
                BufferedReader keyboard = new BufferedReader(isr); //создаем экземпляр keyboard класса для буферизации текста введенного с клавиатуры

                String line; //создаем пременную "line" в которую будут записываться сообщения с клавиатуры
                while (true) { //т.к. сообщений может быть сколько угодно то созлаем бесконечный цикл
                    System.out.print("Хотите получить цитату дня (y/n): ");
                    line = keyboard.readLine(); //считываем из буфера в переменную "line" сообщение с клавиатуры
//                    out.writeUTF(line); //записываем в выходной поток введенное сообщение
//                    out.flush(); //отправляем введенное сообщение на сервер


//                    line = in.readUTF(); //теперь считываем сообщение которое нам возвращает сервер обратно и запсываем его переменную line

                    if (line.endsWith("n")) { //если клиент прсылает сообщение "N"
                        System.out.println("Спасибо за использование этого ресурса\t");
                        break; //выходим из цикла
                    } else {
                        // перенести в else
                        out.writeUTF(line); //записываем в выходной поток введенное сообщение
                        out.flush(); //отправляем введенное сообщение на сервер
                        line = in.readUTF(); //теперь считываем сообщение которое нам возвращает сервер обратно и запсываем его переменную line


                        System.out.println("\nСервер отправил мне эту цитату:\n\t" + line.substring(0, line.length() - 1)); /////////////////////
                        // System.out.println("\nСервер отправил мне эту цитату:\n\t" + line); // !!!!!!!!!!!!!!
                        System.out.println();
                    }
                }
            } catch (Exception e) {
                System.out.println("Исключение метода main() client: " + e);
            }
        } finally {
            try {
                if (socket != null) { //если srvSocket не null
                    socket.close(); //закрываем сеанс
                }
            } catch (IOException e) { //если возникнут исключения (ошибки потока ввовда-вывода)
                e.printStackTrace(); //то выводим сообщения об этих ошибках printStackTrace() прямо выводит
                // информацию в System. err , не принимая во внимание архитектуру приложения
            }
        }
    }
}