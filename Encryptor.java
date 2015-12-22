public class Encryptor {
    public static Message encrypt(Message start) {
        Message msg = new Message(start.getMessage() + "SUP");
        return msg;
    }
    
    public static Message encrypt(String start, Language lang) {
        Message msg = new Message(start, lang, false);
        msg = encrypt(msg);
        return msg;
    }
    
    public static Message decrypt(Message start) {
        return null;
    }
}