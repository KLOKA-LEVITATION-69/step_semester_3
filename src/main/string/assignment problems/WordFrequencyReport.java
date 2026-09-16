import java.util.*;

public class WordFrequencyReport {

    static void printFilteredWordFrequency(String feedback) {

        // Convert to lowercase
        String cleanedText = feedback.toLowerCase();

        // Remove punctuation
        cleanedText = cleanedText.replace(".", "");
        cleanedText = cleanedText.replace(",", "");

        // Stop words
        String[] stopWords = {
                "the", "was", "and", "a",
                "is", "of", "in"
        };

        // Split into words
        String[] words = cleanedText.split("\\s+");

        HashMap<String, Integer> frequency =
                new HashMap<>();

        // Count words
        for (String word : words) {

            boolean isStopWord = false;

            // Check stop words
            for (String stopWord : stopWords) {

                if (word.equals(stopWord)) {
                    isStopWord = true;
                    break;
                }
            }

            // Skip stop words
            if (isStopWord) {
                continue;
            }

            frequency.put(
                    word,
                    frequency.getOrDefault(word, 0) + 1
            );
        }

        // Convert map entries into a list
        List<Map.Entry<String, Integer>> entries =
                new ArrayList<>(frequency.entrySet());

        // Sort by count in descending order
        entries.sort(
                (entry1, entry2) ->
                        entry2.getValue()
                                .compareTo(entry1.getValue())
        );

        // Print result
        for (Map.Entry<String, Integer> entry : entries) {

            System.out.println(
                    entry.getKey()
                    + ": "
                    + entry.getValue());
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter feedback: ");
        String feedback = sc.nextLine();

        printFilteredWordFrequency(feedback);

        sc.close();
    }
}