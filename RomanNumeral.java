
public class RomanNumeral {

    private final int value;

    public static final String[] numerals = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
    public static final int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};

    public RomanNumeral(int value) {
        if (value < 0) throw new IllegalArgumentException("Number must be Positive");
        if (value >= 4000) throw new IllegalArgumentException("Number must be < 4000");

        this.value = value;
    }

    public int getValue() {
        return value;
    }

    private String convert() {
        if (this.value == 0) return "nullus";

        int start = this.value;
        String end = "";

        boolean go;
        int i;
        while (start > 0) {
            go = true;
            i = 0;
            while (go) {
                if (start - values[i] >= 0) {
                    start -= values[i];
                    end += numerals[i];
                    go = false;
                }
                i++;
            }
        }

        return end;
    }

    public String toString() {
        return convert();
    }
}