public class Message {
    private final boolean encrypted;
    private final String message;
    private final Language lang;
    
    public Message() {
        message = "";
        lang = Language.ENGLISH;
        encrypted = false;
    }
    
    public Message(String message) {
       this.message = message;
       lang = Language.ENGLISH;
       encrypted = false;
    }
    
    public Message(String message, boolean encrypted) {
        this.message = message;
        lang = Language.ENGLISH;
        this.encrypted = encrypted;
    }
    
    public Message(String message, Language lang, boolean encrypted) {
        this.message = message;
        this.lang = lang;
        this.encrypted = encrypted;
    }
    
    public String getMessage() {
        return message;
    }
    
    public String toString() {
        return message;
    }
    
    public boolean isEncrypted() {
        return encrypted;
    }
    
    public Language getLanguage() {
        return lang;
    }
}