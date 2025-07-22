public class TextProcessor {

    public static int countWords(String sentence) {
        if (sentence == null || sentence.trim().isEmpty()) {
            return 0;
        }
        String[] words = sentence.trim().split("\\s+");
        return words.length;
    }

    public static String replaceWord(String text, String oldWord, String newWord) {
        if (text == null || oldWord == null || newWord == null) {
            return text;
        }
        return text.replaceAll("\\b" + oldWord + "\\b", newWord);
    }

    public static void main(String[] args) {
        String test = "Java is fun and Java is powerful";
        System.out.println("Word count: " + countWords(test));
        System.out.println("After replacement: " + replaceWord(test, "Java", "Programming"));
    }
}
