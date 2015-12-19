import java.util.Date;
public class Encryptor {
    public static void main(String[] args) {
        String check = "";

        for (int i = 0; i < 100000; i++) {
            check += (char)(Math.random()*26 + 'a');
        }

        Date start = new Date();
        String encrypted = encrypt(check);

        System.out.println(encrypted + "\n");

        Date end = new Date();
        long duration = end.getTime() - start.getTime();

        System.out.println(duration + "\n");

        start = new Date();
        String decrypted = decrypt(encrypted);

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
            if (i%2 == 0) {
                encryption.append(key.charAt((int)i/2));
            }
            else if (i%2 != 0) {
                if (Character.isLetter(start.charAt(i/2)) == false) {
                    char nonLetter = ((int)start.charAt(i/2) == 32) ? 'A' : ((start.charAt(i/2) >= '0' && start.charAt(i/2) <= '9') ? (char)(start.charAt(i/2) - '0' + 'B') : start.charAt(i/2));
                    encryption.append(nonLetter);
                    continue;
                }
                
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
            if (Character.isLetter(start.charAt(i)) == false || start.charAt(i) < 'a') {
                char nonLetter = ((int)start.charAt(i) == (int)'A') ? (char)32 : ((start.charAt(i) >= 'B' && start.charAt(i) <= ('B' + 10)) ? (char)((int)start.charAt(i) - (int)'B' + (int)'0') : start.charAt(i));
                decryption.append(nonLetter);
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