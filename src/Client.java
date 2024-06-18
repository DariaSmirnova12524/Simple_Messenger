import Messages.SendingMessagesClient;

import java.io.*;
import java.net.Socket; //импорт

public class Client {
    public static Socket client; //объявление
    //private static BufferedReader in;
   // private static BufferedWriter out;
    private static ObjectInput in;
    private static ObjectOutput out;
    private static BufferedReader reader;
    public static String phrase;

    public static void main(String[] args) {
        try {
            try {
                while (true) { //для общения до определенной команды
                    client = new Socket("localhost", 4004);
                    reader = new BufferedReader(new InputStreamReader(System.in));
                    out = new ObjectOutputStream(client.getOutputStream());
                    in = new ObjectInputStream(client.getInputStream());
                    SendingMessagesClient message = new SendingMessagesClient("a","b","hello!");
                    out.writeObject(message);
                    //in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    //out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                    //System.out.println("Напишите что-нибудь");
                    //phrase = reader.readLine();
                    //out.write(phrase + "\n");
                    out.flush();
                    String serverPhrase = in.readLine();
                    System.out.println(serverPhrase);
                    if (phrase.equals(".")) {
                        break;
                    }
                }
            } finally {
                System.out.println("клиент закрыт");
                client.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }

    }

}
