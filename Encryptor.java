import java.util.Date;
public class Encryptor {
    public static void main(String[] args) {
        String check = "";
        
        for (int i = 0; i < 100000; i++) {
            check += (char)(Math.random()*27 + 'a');
        }
        
        Date start = new Date();
        String encrypted = encrypt(check);
        
        System.out.println(encrypted + "\n");
        
        Date end = new Date();
        long duration = end.getTime() - start.getTime();
        
        System.out.println(duration + "\n");
        
        start = new Date();
        String decrypted = decrypt(encrypt(check));
        
        System.out.println(decrypted + "\n");
        
        end = new Date();
        duration = end.getTime() - start.getTime();
        
        System.out.println(duration);
        
        // System.out.println("Encrypted: " + encrypted + "\nDecrypted: " + decrypted + "\n");
    }

    public static String encrypt(String sStart) {
        String start = sStart.toLowerCase();
        StringBuilder encryption = new StringBuilder();
        String key = generateKey(start.length());

        for (int i = 0; i < start.length()*2; i++) {
            if (Character.isLetter(start.charAt(i/2)) == false) {
                encryption.append((char)((int)start.charAt(i/2) - 1));
                continue;
            }

            if (i%2 == 0) {
                encryption.append(key.charAt((int)i/2));
            }
            else if (i%2 != 0) {
                encryption.append((char)(((((int)start.charAt(i/2) - (int)'a') + ((int)key.charAt(i/2) - (int)'a'))%26) + (int)'a'));
            }
        }

        return encryption.toString();
    }

    public static String decrypt(String sStart) {
        StringBuilder start = new StringBuilder();
        StringBuilder decryption = new StringBuilder();
        StringBuilder key = new StringBuilder();

        for (int i = 0; i < sStart.length(); i++) {
            if (i%2 == 0) {
                key.append(sStart.charAt(i));
                // start.delete(i, i + 1);
            }
            else if (i%2 != 0) {
                start.append(sStart.charAt(i));
            }
        }

        // System.out.println(key.toString() + "\n" + start.toString());

        for (int i = 0; i < start.length(); i++) {
            if (Character.isLetter(start.charAt(i)) == false) {
                decryption.append((char)((int)start.charAt(i) + 1));
                continue;
            }
            
            decryption.append((char)(((((int)start.charAt(i) - (int)'a') - ((int)key.charAt(i) - (int)'a') + 26)%26) + (int)'a'));
        } 

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