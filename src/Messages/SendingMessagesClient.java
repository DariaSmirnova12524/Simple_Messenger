package Messages;

public class SendingMessagesClient extends Request implements java.io.Serializable {
    public String senderLogin;
    public String recipientLogin;
    public String messageText;
    public SendingMessagesClient(String login1,String login2,String text){
        senderLogin = login1;
        recipientLogin = login2;
        messageText = text;
    }
    public String getSenderLogin(){
        return senderLogin;
    }
    public String getMessageText() {
        return messageText;
    }
    public String getRecipientLogin() {
        return recipientLogin;
    }
}
