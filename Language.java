public enum Language {
    ENGLISH (0, 26),
    RUSSIAN (1, 32);
    public final int length;
    public final int[] alphabet;
    Language(int lang, int length) {
        this.length = length;
        alphabet = new int[this.length];
        switch (lang) {
            case 0:
            for (int i = 0; i < this.length; i++) {
                alphabet[i] = i + (int)'a';
            }
            break;
            
            case 1:
            for (int i = 0; i < this.length; i++) {
                alphabet[i] = i + 1072;
                //             Cyrillic 'a'
            }
            break;
        }
    }
}