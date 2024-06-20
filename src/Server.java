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

    public static void main(String[] args) throws ClassNotFoundException {
        try {
            try {
                try {
                    try {
                        server = new ServerSocket(4004);
                        System.out.println("сервер запущен");
                    } catch (IOException e) {
                        System.out.println("Сервер не запущен, порт занят");
                    }
                    while (true) {
                        try {
                            client = server.accept();
                        } catch (IOException e) {
                            System.out.println("клиент не принят");
                        }
                        try {
                            out = new ObjectOutputStream(client.getOutputStream());
                            in = new ObjectInputStream(client.getInputStream());
                            SendingMessagesClient message = (SendingMessagesClient) in.readObject();
                            text = in.readLine();
                            System.out.println("User login 1 - " + message.getSenderLogin());
                            System.out.println("User login 2 - " + message.getRecipientLogin());
                            System.out.println("Message - " + message.getMessageText());
                            out.flush();
                        } catch (IOException e) {
                            System.out.println("ошибка в чтении сообщения!");
                        }
                        if (text.equals(".")) {
                            break;
                        }
                    }
                } finally {
                    client.close();
                    in.close();
                    out.close();
                }

            } finally {
                System.out.println("сервер закрыт");
                server.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
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