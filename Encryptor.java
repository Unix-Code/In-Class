public class Encryptor {
    public static String encrypt(String start) {
        StringBuilder encryption = new StringBuilder();
        String key = generateKey(start.length());
        
        for (int i = 0; i < start.length()*2; i++) {
            if (i%2 == 0) {
                encryption.append(key.charAt((int)i/2));
            }
            else if (i%2 != 0) {
                encryption.append((char)(((((int)start.charAt(i/2) - (int)'a') + ((int)key.charAt(i/2) - (int)'a'))%26) + (int)'a'));
            }
        }

        return encryption.toString();
    }

    public static String decrypt(String start) {
        StringBuilder decryption = new StringBuilder();
        
        return decryption.toString();
    }

    public static String generateKey(int length) {
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < length; i++) {
            key.append((char)((Math.random()*26) + (int)'a'));
        }

        return key.toString();
    }
}