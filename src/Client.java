import java.io.*;
import java.net.Socket;

public class Client {
    public static Socket client;
    private static BufferedReader in;
    private static BufferedWriter out;
    private static BufferedReader reader;
    public static String phrase;
    public static void main(String[] args) {
        while (true) {
            try {
                try {
                    client = new Socket("localhost", 4004);
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    System.out.println("Напишите что-нибудь");
                    phrase = reader.readLine();
                    out.write(phrase + "\n");
                    out.flush();
                    String serverPhrase = in.readLine();
                    System.out.println(serverPhrase);
                } finally {
                    System.out.println("клиент закрыт");
                    client.close();
                    in.close();
                    out.close();
                }
            } catch (IOException e) {
                System.err.println(e);
            }
            if(phrase.equals(".")){
                break;
            }
        }
    }

}
