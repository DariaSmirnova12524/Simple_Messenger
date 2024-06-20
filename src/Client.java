import Messages.SendingMessagesClient;

import java.io.*;
import java.net.Socket; //импорт
import java.util.Scanner;

public class Client {
    public static Socket client; //объявление
    private static ObjectInput in;
    private static ObjectOutput out;
    public static String text;

    public static void main(String[] args) throws EOFException {
        try {
            try {
                try {
                    client = new Socket("localhost", 4004);
                } catch (IOException e) {
                    System.out.println("Сервер занят");
                }
                try {
                    while (true) {
                        out = new ObjectOutputStream(client.getOutputStream());
                        in = new ObjectInputStream(client.getInputStream());
                        System.out.println("Напиши что-нибудь...");
                        Scanner sc = new Scanner(System.in);
                        text = sc.nextLine();
                        SendingMessagesClient message = new SendingMessagesClient("a", "b", text);
                        System.out.println("User login 1 - " + message.getSenderLogin());
                        System.out.println("User login 2 - " + message.getRecipientLogin());
                        System.out.println("Message - " + message.getMessageText());
                        out.writeObject(message);
                        out.flush();
                        if (text.equals(".")) {
                            break;
                        }
                    }
                } catch (IOException e) {
                    System.out.println("Ошибка в сообщении или его выводе");
                }
            } catch (NullPointerException n) {
                System.out.println("Клиент не инициализирован");
            } finally {
                System.out.println("клиент закрыт");
                client.close();
                in.close();
                out.close();
            }
        } catch (IOException e) {
            System.err.println(e);
        } catch (NullPointerException e) {
            System.out.println("Клиент не инициализирован!");
        }

    }

}
/*private static BufferedReader in;
    private static BufferedWriter out; */
/*private static BufferedReader reader;
    public static String phrase;*/
//reader = new BufferedReader(new InputStreamReader(System.in));
// /*in = new BufferedReader(new InputStreamReader(client.getInputStream()));
//                out = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
//                System.out.println("Напишите что-нибудь");
//                phrase = reader.readLine();
//                out.write(phrase + "\n");*/
     /*String serverPhrase = in.readLine();
                System.out.println(serverPhrase);
                if (phrase.equals(".")) {
                  break;
                 }
                 }*/
// while (true) { //для общения до определенной команды