import java.net.InetAddress;
import java.net.UnknownHostException;

public class Main {
    public static void main(String[] args) throws UnknownHostException {
        InetAddress address = InetAddress.getLocalHost();
        System.out.println(address);
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
        System.out.println();
        address = InetAddress.getByName("google.com");
        System.out.println(address);
        System.out.println(address.getCanonicalHostName());
        System.out.println(address.getHostAddress());
        System.out.println(address.getHostName());
    }
}