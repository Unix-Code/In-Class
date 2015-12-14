public class StringPractice {
    public static void main(String [] args) {
        String s = "Uellx, World!!!";

        System.out.println("Comma at: " + s.indexOf(','));

        char first = s.charAt(0);
        System.out.println("The First Character is " + (("aAeEiIoOuU".indexOf(first) < 0) ? "not " : "") + "a vowel.");

        System.out.println("Middle Character" + ((s.length()%2 == 0) ? "s: " + s.substring((int)s.length()/2 -1, (int)s.length()/2 + 1) : ": " + s.substring((int)s.length()/2, (int)s.length()/2 + 1))); 

        String flipped = s.substring((int)s.length()/2 + 1, s.length()) + s.substring(0, (int)s.length()/2 + 1); 
        System.out.println("Flipped String: " + flipped);

        String sScroll = s.substring(1) + s.charAt(0);
        System.out.println("#5 New String: " + sScroll);

        String replaced = "";
        for (int i = 0; i < s.length(); i++) {
            char check = s.charAt(i);
            if (check == 'x') {
                replaced += 'o';
            }
            else {
                replaced += check;
            }
        }
        System.out.println("Replaced String: " + replaced); 

        System.out.println("Lexigraphically Greatest: " + getLastInDictionaryOrder("ABC", "ACD", "BCD"));

        String sThrees = "";
        for (int i = 0; i < s.length(); i++) {
            if (i%2 == 0 && i != 0) { 
                sThrees += "3";
            }
            sThrees += s.substring(i, i + 1);
        }
        System.out.println("String with 3's: " + sThrees);

        System.out.println(myIndexOf(s, "orl"));

        String output = "";
        for (int i = s.length()-1; i >= 0; i--) {
            output += Character.toString(s.charAt(i));
        }
        System.out.println("Reversed: " + output);
    }

    public static String getLastInDictionaryOrder(String s1, String s2, String s3) {      
        return (s1.compareTo(s2) >= 0) ? ((s1.compareTo(s3) >= 0) ? s1 : s3) : ((s2.compareTo(s3) >= 0) ? s2 : s3);
    }

    public static int myIndexOf(String s1, String check) {
        int itt = -1;

        if (!(check.length() > s1.length() || check.length() == 0 || check.equals(null))) {
            for (int i = 0; i < s1.length(); i++) {
                if (i + check.length() > s1.length()) {
                    break;
                }
                if (s1.substring(i, i + check.length()).equals(check)) {
                    itt = i;
                }
            }
        }

        return itt;
    }
}