public class Encryptor {
    /**
     * Static method to encrypt a given input message given the key String
     * @param Message sStart
     * @param String theKey
     * @return Message
     */
    public static Message encrypt(Message sStart, String theKey) {
        StringBuilder encryption = new StringBuilder();
        String start = sStart.getMessage().toLowerCase();
        String key = generateKey(sStart.getMessage(), theKey);
        
        for (int i = 0; i < start.length(); i++) {
            if (Character.isLetter(start.charAt(i)) == false) {
                char nonLetter = (start.charAt(i) == ' ') ? Character.toUpperCase((char)sStart.getLanguage().alphabet[0]) : ((start.charAt(i) >= '0' && start.charAt(i/2) <= '9') ? (char)(start.charAt(i) - '0' + Character.toUpperCase((char)sStart.getLanguage().alphabet[1])) : start.charAt(i));
                encryption.append(nonLetter);
                continue;
            }

            encryption.append((char)(((((int)start.charAt(i) - (int)sStart.getLanguage().alphabet[0]) + ((int)key.charAt(i) - (int)sStart.getLanguage().alphabet[0]))%sStart.getLanguage().alphabet.length) + (int)sStart.getLanguage().alphabet[0]));
        }

        return new Message(encryption.toString(), sStart.getLanguage(), true);
    }
    
    /**
     * Static method to decrypt a given input message given the key String
     * @param Message sStart
     * @param String theKey
     * @return Message
     */
    public static Message decrypt(Message sStart, String theKey) {
        StringBuilder decryption = new StringBuilder();
        String start = sStart.getMessage();
        String key = generateKey(sStart.getMessage(), theKey);
        
        for (int i = 0; i < start.length(); i++) {
            if (Character.isLetter(start.charAt(i)) == false || start.charAt(i) < sStart.getLanguage().alphabet[0]) {
                char nonLetter = (start.charAt(i) == Character.toUpperCase((char)sStart.getLanguage().alphabet[0])) ? ' ' : ((start.charAt(i) >= Character.toUpperCase((char)sStart.getLanguage().alphabet[1]) && start.charAt(i) <= (Character.toUpperCase((char)sStart.getLanguage().alphabet[1]) + 10)) ? (char)((int)start.charAt(i) - (int)Character.toUpperCase((char)sStart.getLanguage().alphabet[1]) + (int)'0') : start.charAt(i));
                decryption.append(nonLetter);
                continue;
            }

            decryption.append((char)(((((int)start.charAt(i) - (int)sStart.getLanguage().alphabet[0]) - ((int)key.charAt(i) - (int)sStart.getLanguage().alphabet[0]) + sStart.getLanguage().alphabet.length)%sStart.getLanguage().alphabet.length) + (int)sStart.getLanguage().alphabet[0]));
        }
        
        return new Message(decryption.toString(), sStart.getLanguage(), false);
    }
    
    /**
     * Private Static method to generate a String object named Key
     * @param String start
     * @param String sKey
     * @return String
     */
    private static String generateKey(String start, String sKey) {
        StringBuilder key = new StringBuilder();
        
        for (int i = 0; i < start.length(); i++) {
            key.append(sKey.charAt(i%sKey.length()));
        }
        
        return key.toString();
    }
}