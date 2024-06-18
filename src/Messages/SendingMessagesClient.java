package Messages;

public class SendingMessagesClient extends Request implements java.io.Serializable {
    public static String senderLogin;
    public static String recipientLogin;
    public static String messageText;
    public SendingMessagesClient(String login1,String login2,String text){
        senderLogin = login1;
        recipientLogin = login2;
        messageText = text;
    }
    public static String getSenderLogin(){
        return senderLogin;
    }
    public static String getMessageText() {
        return messageText;
    }
    public static String getRecipientLogin() {
        return recipientLogin;
    }
}
