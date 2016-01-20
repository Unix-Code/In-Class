public class Encryptor2 {
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
                char nonLetter = (start.charAt(i) == ' ') ? Character.toUpperCase((char)sStart.getLanguage().alphabet[0]) : ((start.charAt(i) >= '0' && start.charAt(i) <= '9') ? (char)(start.charAt(i) - '0' + Character.toUpperCase((char)sStart.getLanguage().alphabet[1])) : start.charAt(i));
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
        StringBuilder key = new StringBuilder();
        key.append(theKey);

        for (int i = 0; i < start.length(); i++) {
            char nextChar = (char)0;
            if (Character.isLetter(start.charAt(i)) == false || start.charAt(i) < sStart.getLanguage().alphabet[0]) {
                nextChar = (start.charAt(i) == Character.toUpperCase((char)sStart.getLanguage().alphabet[0])) ? ' ' : ((start.charAt(i) >= Character.toUpperCase((char)sStart.getLanguage().alphabet[1]) && start.charAt(i) <= (Character.toUpperCase((char)sStart.getLanguage().alphabet[1]) + 10)) ? (char)((int)start.charAt(i) - (int)Character.toUpperCase((char)sStart.getLanguage().alphabet[1]) + (int)'0') : start.charAt(i));
            }
            else {
                nextChar = (char)(((((int)start.charAt(i) - (int)sStart.getLanguage().alphabet[0]) - ((int)key.charAt(i) - (int)sStart.getLanguage().alphabet[0]) + sStart.getLanguage().alphabet.length)%sStart.getLanguage().alphabet.length) + (int)sStart.getLanguage().alphabet[0]);
            }
            decryption.append(nextChar);

            if (key.toString().length() < start.length()) {
                if (Character.isLetter(nextChar)){
                    key.append(nextChar);
                }
                else if (Character.isDigit(nextChar)) {
                    key.append((char)('a' + (Integer.parseInt(String.valueOf(nextChar)))));
                }
                else {
                    key.append(theKey.charAt(0));
                }
            }
        }

        return new Message(decryption.toString(), sStart.getLanguage(), false);
    }

    /**
     * Private Static method to generate a String object named Key
     * @param String start
     * @param String sKey
     * @return String
     */
    public static String generateKey(String start, String sKey) {
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < start.length(); i++) {
            if (i < sKey.length()) {
                key.append(sKey.charAt(i));
            }
            else {
                if (Character.isLetter(start.toLowerCase().charAt(i - sKey.length()))) {
                    key.append(start.toLowerCase().charAt(i - sKey.length()));
                }
                else if (Character.isDigit(start.toLowerCase().charAt(i - sKey.length()))) {
                    int shift = Integer.parseInt(String.valueOf(start.charAt(i-sKey.length())));
                    key.append((char)('a' + shift));
                }
                else {
                    key.append(sKey.charAt(0));
                }
            }
        }

        return key.toString();
    }
}