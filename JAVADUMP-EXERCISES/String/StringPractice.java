public class StringPractice {
    public static void main(String[] args) {

        // Part 1: Basic String Operations
        String firstName = "Harry";
        String lastName = "Potter";
        String fullName = firstName + " " + lastName;

        System.out.println("Full name: " + fullName);
        System.out.println("Length: " + fullName.length());
        System.out.println("First character: " + fullName.charAt(0));
        System.out.println("Index of 'r': " + fullName.indexOf('r'));

        System.out.println();

        // Part 2: Extracting Parts of a String
        String sentence = "Learning Java is fun!";
        String word1 = sentence.substring(0, 8);   // "Learning"
        String word2 = sentence.substring(9, 13);  // "Java"
        String word3 = sentence.substring(17);     // "fun!"

        System.out.println("First word: " + word1);
        System.out.println("Second word: " + word2);
        System.out.println("Last word: " + word3);

        System.out.println();

        // Part 3: Splitting Strings
        String csvData = "apple,banana,grape,orange";
        String[] fruits = csvData.split(",");

        for (int i = 0; i < fruits.length; i++) {
            System.out.println("Fruit " + (i + 1) + ": " + fruits[i]);
        }

        System.out.println();

        // Part 4: Replacing Characters
        String quickSentence = "The quick brown fox.";
        String modified = quickSentence.replace("quick", "slow").replace(" ", "_");
        System.out.println("Modified sentence: " + modified);

        System.out.println();

        // Part 5: Handling Null and Empty Strings
        String nullString = null;
        if (nullString == null) {
            System.out.println("The string is null, cannot compute length.");
        } else {
            System.out.println("Length: " + nullString.length());
        }

        String emptyString = "";
        System.out.println("Empty string length: " + emptyString.length());
    }
}
