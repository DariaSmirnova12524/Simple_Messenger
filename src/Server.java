import Messages.SendingMessagesClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static ServerSocket server;
    public static Socket client;
    private static ObjectInput in;
    private static ObjectOutput out;
    public static String text;

    public static void main(String[] args) throws ClassNotFoundException, IOException {
        try {
            server = new ServerSocket(4004);
            System.out.println("сервер запущен");
        } catch (IOException e) {
            System.out.println("Сервер не запущен, порт занят");
        }
        try {
            client = server.accept();
        } catch (IOException e) {
            System.out.println("клиент не принят");
        }
        try {
            while (true) {
                out = new ObjectOutputStream(client.getOutputStream());
                in = new ObjectInputStream(client.getInputStream());
                SendingMessagesClient message = (SendingMessagesClient) in.readObject();
                //text = in.readLine();
                System.out.println("User login 1 - " + message.getSenderLogin());
                System.out.println("User login 2 - " + message.getRecipientLogin());
                System.out.println("Message - " + message.getMessageText());
                out.flush();
                if (message.equals(".")) {
                    break;
                }
            }
        } catch (IOException e) {
            System.out.println("ошибка в чтении сообщения!");
        } finally {
            client.close();
            in.close();
            out.close();
            System.out.println("сервер закрыт");
            server.close();
        } //раньше файнали было в третьем трае
    }
}
/*private static BufferedReader in;
    private static BufferedWriter out; */
// public static String phrase;
 /*  in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                    out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));*/
 /*phrase = in.readLine();
                    System.out.println(phrase);
                    out.write("сервер: вы написали:" + phrase + "\n");*/
//
// } catch (IOException e) {
//     System.err.println(e);
//  }