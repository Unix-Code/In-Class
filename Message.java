public class Message {
    private boolean encrypted;
    private String message;
    public Message(String message, boolean alreadyEncrypted) {
        this.encrypted = alreadyEncrypted;
        if (this.encrypted == false) {
            this.message = encrypt(message);
            this.encrypted = true;
        }
    }

    public static String encrypt(String msg) {
        StringBuilder end = new StringBuilder();
        StringBuilder temp = new StringBuilder();

        for (int i = 0; i < msg.length(); i++) {
            temp.append(String.valueOf((int)(msg.charAt(i))));
            temp.reverse();
            String add = (Math.random()*10 + 1 <= i) ? "0 - " + String.valueOf(Integer.parseInt(temp.toString())) : String.valueOf(Integer.parseInt(temp.toString()));
            end.append(add + " - ");
            temp.delete(0, temp.length());
        }
        end.delete(end.length() - 3, end.length());
        return end.toString();
    }

    public static String[] decrypt(String msg) {
        StringBuilder end = new StringBuilder();
        StringBuilder temp = new StringBuilder();
        String[] theMsg = msg.split(" - ");/*
        for (int i = 0; i < theMsg.length; i++) {
        temp.append(theMsg[i]);
        temp.reverse();
        end.append((char)(Integer.parseInt(temp.toString())));
        temp.delete(0, temp.length());
        }

        return end.toString();*/
        for (String word : theMsg) {
            System.out.println(word);
        }
        return theMsg;
    }
}
