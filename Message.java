public class Message {
    private final boolean encrypted;
    private final String message;
    private final Language lang;
    
    /**
     * Default constructor
     */
    public Message() {
        message = "";
        lang = Language.ENGLISH;
        encrypted = false;
    }
    
    /**
     * Constructor with a given String parameter
     * @param String message
     */
    public Message(String message) {
       this.message = message;
       lang = Language.ENGLISH;
       encrypted = false;
    }
    
    /**
     * Constructor with a given String and boolean input
     * @param String message
     * @param boolean encrypted
     */
    public Message(String message, boolean encrypted) {
        this.message = message;
        lang = Language.ENGLISH;
        this.encrypted = encrypted;
    }
    
    /**
     * Constructor with a given String and language input
     * @param String message
     * @param Language lang
     */
    public Message(String message, Language lang) {
        this.message = message;
        this.lang = lang;
        encrypted = false;
    }
    
    /**
     * Constructor with a given String, language, and boolean input
     * @param String message
     * @param Language lang
     * @param boolean encrypted
     */
    public Message(String message, Language lang, boolean encrypted) {
        this.message = message;
        this.lang = lang;
        this.encrypted = encrypted;
    }
    
    /**
     * Accessor method to return message reference
     */
    public String getMessage() {
        return message;
    }
    
    /**
     * Accessor method to return message as a String
     */
    public String toString() {
        return message;
    }
    
    /**
     * Boolean method to determine if the message is encrypted
     */
    public boolean isEncrypted() {
        return encrypted;
    }
    
    /**
     * Accessor method to return the language of the message
     */
    public Language getLanguage() {
        return lang;
    }
}