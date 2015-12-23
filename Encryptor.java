public class Encryptor {
    public static Message encrypt(Message sStart, String theKey) {
        Message message;
        StringBuilder encryption = new StringBuilder();
        String start = sStart.getMessage();
        String key = generateKey(sStart.getMessage(), theKey);
        for (int i = 0; i < start.length(); i++) {
            if (Character.isLetter(start.charAt(i)) == false) {
                char nonLetter = (start.charAt(i) == ' ') ? 'A' : ((start.charAt(i) >= '0' && start.charAt(i/2) <= '9') ? (char)(start.charAt(i) - '0' + 'B') : start.charAt(i));
                encryption.append(nonLetter);
                continue;
            }

            encryption.append((char)(((((int)start.charAt(i) - (int)sStart.getLanguage().alphabet[0]) + ((int)key.charAt(i) - (int)sStart.getLanguage().alphabet[0]))%26) + (int)sStart.getLanguage().alphabet[0]));
        }

        return new Message(encryption.toString(), sStart.getLanguage(), true);
    }

    /*
    public static Message encrypt(String start, Language lang) {
    Message msg = new Message(start, lang, false);
    msg = encrypt(msg);
    return msg;
    }
     */

    public static Message decrypt(Message start) {
        return null;
    }
    
    private static String generateKey(String start, String sKey) {
        StringBuilder key = new StringBuilder();
        char[] theKey = sKey.toCharArray();
        
        for (int i = 0; i < start.length(); i++) {
            key.append(theKey[i%5]);
        }
        
        return key.toString();
    }
}