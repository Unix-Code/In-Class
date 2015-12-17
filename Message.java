import java.util.Scanner;
public class Message {
    private boolean encrypted;
    private String message;
    public Message(String message, boolean alreadyEncrypted) {
        this.encrypted = alreadyEncrypted;
        if (this.encrypted == false) {
            this.message = encrypt(message);
            this.encrypted = true;
        }
        else {
            this.message = message;
        }
    }

    public static void main(String[] args) {
        Message aMsg = new Message("     qwertyuiopasdfghjklzxcvbnmQWERTYUIOPLKJHGFDSAZXCVBNM`1234567890-=[]\\;',./~!@#$%^&*()_+{}|:<>?", false);
        System.out.println(aMsg.getDecryption());
    }

    private String encrypt(String msg) {
        StringBuilder end = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            temp.append(String.valueOf((int)msg.charAt(i)));
            temp.reverse();
            // Determines random chance of adding null (can be changed to preference)
            String add = (Math.random()*(i+10) + 1 <= i) ? "0 - " + temp.toString() : temp.toString();
            end.append(add + " - ");
            temp.delete(0, temp.length());
        }
        end.delete(end.length() - 3, end.length());
        return end.toString();
    }

    private String decrypt(String msg) {
        if (encrypted == false) {
            System.err.print("This should never have happened. Message not encrypted.");
            return message;
        }

        StringBuilder end = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String[] theMsg = msg.split(" - ");

        try {
            for (int i = 0; i < theMsg.length; i++) {
                temp.append(theMsg[i]);
                temp.reverse();
                String append = (Integer.parseInt(temp.toString()) == 0) ? "" : String.valueOf((char)Integer.parseInt(temp.toString()));
                end.append(append);
                temp.delete(0, temp.length());
            }
        } catch (NumberFormatException e) {
            System.err.print("Error: String was wrongfully set to encrypted\nString has been encrypted");
            message = encrypt(message);
            // only saves non-number-only messages
        }
        return end.toString();
    }
    
    public String getMessage() {
        return message;
    }
    
    public String getDecryption() {
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter Passcode:");
        String cmd = scan.nextLine();
        boolean correctPasscode = cmd.equalsIgnoreCase(decrypt("28 - 101 - 811 - 101 - 411 - 511 - 101 - 0 - 23 - 0 - 56 - 511 - 99 - 0 - 501 - 0 - 501"));
        System.out.print("\fPassword Accepted\n\n");
        return (correctPasscode) ? decrypt(message) : "Incorrect Password - Failure to Decrypt";
    }
}
