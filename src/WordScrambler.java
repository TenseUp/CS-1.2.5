public class WordScrambler {

    private String[] scrambledWords;

    public WordScrambler(String[] wordArr) throws IllegalArgumentException{
        for (String i : wordArr){
            if(i.contains(" ")) throw new IllegalArgumentException(String.format("Word Array must contain single words only! %s contains more than one word!", i));
        }
        scrambledWords = mixedWords(wordArr);
    }

    private String recombine(String word1, String word2) {
        int length1 = word1.length();
        int length2 = word2.length();
        int halfLength1 = length1 / 2;
        int halfLength2 = length2 / 2;

        String firstHalf = word1.substring(0, halfLength1);
        String secondHalf = word2.substring(halfLength2);

        return firstHalf + secondHalf;
    }

    private String[] mixedWords(String[] words) throws IllegalArgumentException{
        int numWords = words.length;
        if(numWords % 2 != 0) throw new IllegalArgumentException("Word Array must contain an even number of elements!");
        String[] mixed = new String[numWords];

        for (int i = 0; i < numWords; i += 2) {
            String word1 = words[i];
            String word2 = words[i + 1];
            mixed[i] = recombine(word1, word2);
            mixed[i + 1] = recombine(word2, word1);
        }

        return mixed;
    }

    public String[] getScrambledWords() {
        return scrambledWords;
    }
}