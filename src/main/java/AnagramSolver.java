import java.util.ArrayList;
import java.util.HashMap;

public class AnagramSolver {
    private AnagramSolver() {}

    public static HashMap<String, ArrayList<String>> anagrams(String filename) {
        HashMap<String, ArrayList<String>> anagramMap = new HashMap<>();
        java.util.Scanner scanner = null;

        try {
            scanner = new java.util.Scanner(new java.io.File(filename));
            while (scanner.hasNextLine()) {
                String word = scanner.nextLine().trim().toLowerCase();
                if (word.isEmpty()) continue;


                char[] chars = word.toCharArray();
                java.util.Arrays.sort(chars);
                String key = new String(chars);

                ArrayList<String> wordList = anagramMap.getOrDefault(key, new ArrayList<>());
                wordList.add(word);
                anagramMap.put(key, wordList);
            }
        } catch (java.io.FileNotFoundException e) {
            System.out.println("File not found: " + filename);
            return new HashMap<>();
        } finally {
            if (scanner != null) {
                scanner.close();
            }
        }

        return anagramMap;
    }

    /**
     * Input: name of text file (containing English words).
     * Output: a hashmap of lists of words that are anagrams.
     * @param filename
     * @return
     */

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: largest list of words in hashmap that are anagrams.
     * @param anagrams
     * @return
     */
    public static ArrayList<String> mostFrequentAnagram(HashMap<String, ArrayList<String>> anagrams) {
        if (anagrams == null || anagrams.isEmpty()) {
            return new ArrayList<>();
        }

        ArrayList<String> mostFrequent = null;
        int maxSize = 0;

        for (ArrayList<String> list : anagrams.values()) {
            if (list.size() > maxSize) {
                maxSize = list.size();
                mostFrequent = list;
            }
        }

        return mostFrequent != null ? mostFrequent : new ArrayList<>();
    }

    /**
     * Input: hashmap of lists of words that are anagrams.
     * Output: prints all key value pairs in the hashmap.
     * @param anagrams
     */
    public static void printKeyValuePairs(HashMap<String, ArrayList<String>> anagrams) {
        if (anagrams == null || anagrams.isEmpty()) {
            System.out.println("HashMap is empty");
            return;
        }

        for (String key : anagrams.keySet()) {
            System.out.println("Key: " + key + ", Value: " + anagrams.get(key));
        }
    }
}
