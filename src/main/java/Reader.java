import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Reader {
    public static void main(String[] args) {
        try {

            Output.writeJson();

            char[] s = {'a', 'c', 'b'};

            StringBuilder string = new StringBuilder(String.valueOf(s));
            String value  = string.reverse().toString();
            System.out.println(value);
            char [] p = value.toCharArray();

            System.out.println(s);
            String address = "127.0.0.1";
            int port = 23456;
            ServerSocket server = new ServerSocket(port, 50, InetAddress.getByName(address));
            Socket socket = server.accept();
            DataInputStream input = new DataInputStream(socket.getInputStream());
            DataOutputStream output  = new DataOutputStream(socket.getOutputStream());
            ServerSocket serverSocket = new ServerSocket(2344);

//            FileReader reader = new FileReader(new File("./ecommerce_voceraae38622"));
            Scanner scanner = new Scanner(new File("ecommerce_voceraae38622.csv"));
            scanner.useDelimiter(",");
            int i = 0;
            while (scanner.hasNext()) {
                System.out.print(scanner.next() + " ");
                i++;
                if (i==5) {
                    System.out.println();

                }

            }
            scanner.close();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Some issue reading the file");
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
