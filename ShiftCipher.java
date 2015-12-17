public class ShiftCipher {
    private String[] alphabet;
    public ShiftCipher() {
        alphabet = makeDefaultAlphabet();
    }
    
    public ShiftCipher(int shift) {
        alphabet = makeDefaultAlphabet();
        for (int i = 0; i < alphabet.length; i++) {
            alphabet[i] = String.valueOf((Character.valueOf(alphabet[i].charAt(0)) + shift - (int)'a') % 26 + (int)'a');
        }
    }
    
    public String[] getCipherAlphabet() {
        return alphabet;
    }
    
    private String[] makeDefaultAlphabet() {
        alphabet = new String[26];
        for(char letter = 'A'; letter <= 'Z'; letter++) {
            alphabet[letter - 65] = String.valueOf(letter);
        }
        
        return alphabet;
    }
}