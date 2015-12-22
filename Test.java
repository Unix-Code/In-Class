public class Test {
    public static void printThis(Language lang) {
        System.out.println(lang.toString() + "\n" + lang.length);
        for (int letter : lang.alphabet) {
            System.out.println((char)letter + " : " + letter);
        }
    }
    
    public static void printMessage() {
        Message message = new Message("Hello, World!", Language.ENGLISH, false);
        System.out.println(message + "\nLanguage: " + message.getLanguage() + "\nEncrypted? " + "\n" + message.isEncrypted());
    }
}