import java.util.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.BufferedReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SpellChecker {

    public static final int EDIT_DISTANCE_THRESHOLD = 1;

    private final HashMap<String, Integer> dict = new HashMap<>();

    public SpellChecker(String file) throws IOException {
        BufferedReader in = new BufferedReader(new FileReader(file));
        Pattern p = Pattern.compile("\\w+");
        for(String temp = ""; temp != null; temp = in.readLine()){
            Matcher m = p.matcher(temp.toLowerCase());
            while(m.find()) {
                String key = m.group();
                Integer value = dict.containsKey(key) ? dict.get(key) + 1 : 1;
                dict.put(key, value);
            }
        }
        in.close();
    }


    /**
     * Calculates the Damerau Levenshtein Edit distance between source and target distance
     * Damerau Levenshtein is an enhanced version of Edit Distance which incorporates transpose operation
     * @param source
     * @param target
     * @return
     */
    public int damerauLevenshteinEditDistance(String source, String target) {
        if (source == null || target == null){
            throw new IllegalArgumentException("Input strings cannot be null");
        }

        int sourceLength = source.length();
        int targetLength = target.length();

        Integer[][] E = new Integer[sourceLength+1][targetLength+1];

        for (int i = 0; i <= sourceLength; i++ ){
            E[i][0] = i;
        }
        for (int j = 0; j <= targetLength; j++ ){
            E[0][j] = j;
        }

        for (int i = 1; i <= sourceLength; i++){
            for (int j = 1; j <= targetLength; j++){
                int cost = source.charAt(i - 1) == target.charAt(j - 1) ? 0 : 1;

                E[i][j] = Math.min( Math.min( E[i-1][j-1] + cost, E[i][j-1] + 1), E[i-1][j] + 1);
                // Accounting for transposes
                if (i > 1
                        && j > 1
                        && source.charAt(i - 1) == target.charAt(j - 2)
                        && source.charAt(i - 2) == target.charAt(j - 1)) {
                    E[i][j] = Math.min(E[i][j], E[i - 2][j - 2] + 1);
                }
            }
        }

        return E[sourceLength][targetLength];
    }

    public List<String> probableCorrections(String misspelledWord){
        int length = misspelledWord.length();
        List<String> corrections = new ArrayList<>();
        for (String word : dict.keySet()){
            if (word.length() <= length + EDIT_DISTANCE_THRESHOLD && word.length() >= length - EDIT_DISTANCE_THRESHOLD){
                // We will consider only those words whose length is within
                // 1 distance of the misspelledWord
                if (damerauLevenshteinEditDistance(word, misspelledWord) <= EDIT_DISTANCE_THRESHOLD){
                    corrections.add(word);
                }
            }
        }
        Collections.sort(corrections, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                return dict.get(o2) - dict.get(o1);
            }
        });
        return corrections;
    }

    private static void printList(List<String> list){
        StringBuilder sb = new StringBuilder();
        for (String word : list){
            System.out.println(word);
        }
    }


    public static void main(String[] args){
        String projectPath =  System.getProperty("user.dir");
        String filePath = projectPath + "/src/SherlockHolmes.txt";

        try {
            SpellChecker spellChecker = new SpellChecker(filePath);

            spellChecker.checkWord("manage");
            spellChecker.checkWord("stroes");
            spellChecker.checkWord("primise");

        }catch (IOException ioe){
            ioe.printStackTrace();
        }
    }

    private void checkWord(String word){
        if (dict.containsKey(word)){
            System.out.println(word + " is a valid word\n");
        }else {
            System.out.println(word + " is misspelled, probable corrections are: ");
            printList(probableCorrections(word));
        }
    }

}
