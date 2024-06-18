import Messages.SendingMessagesClient;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server  {
    public static ServerSocket server;
    public static Socket client;
    //private static BufferedReader in;
    // private static BufferedWriter out;
    private static ObjectInput in;
    private static ObjectOutput out;
    public static String phrase;

    public static void main(String[] args) throws ClassNotFoundException, NullPointerException{
        try {
            try {
                server = new ServerSocket(4004);
                out = new ObjectOutputStream(client.getOutputStream());
                in = new ObjectInputStream(client.getInputStream());
                SendingMessagesClient message = (SendingMessagesClient) in.readObject();
                System.out.println("User login 1" + message.getSenderLogin());
                System.out.println("User login 2" + message.getRecipientLogin());
                System.out.println("Message" + message.getMessageText());
                System.out.println("сервер запущен");
                while (true) {
                    client = server.accept();
                    try {
                      //  in = new BufferedReader(new InputStreamReader(client.getInputStream()));
                        //out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
                        phrase = in.readLine();
                        System.out.println(phrase);
                        //out.write("сервер: вы написали:" + phrase + "\n");
                        out.flush();
                    } finally {
                        client.close();
                        in.close();
                        out.close();
                    }
                    if (phrase.equals(".")) {
                        break;
                    }
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