public class Test {
    public static void printThis(Language lang) {
        System.out.println(lang.toString() + "\n" + lang.length);
        for (int letter : lang.alphabet) {
            System.out.println((char)letter + " : " + letter);
        }
    }
}