import java.util.ArrayList;

public class GradeManager {

    public static String[] reverseStudentNames(String[] names) {
        String[] reversed = new String[names.length];
        for (int i = 0; i < names.length; i++) {
            StringBuilder sb = new StringBuilder(names[i]);
            reversed[i] = sb.reverse().toString();
        }
        return reversed;
    }

    public static char getLetterGrade(int score) {
        if (score >= 90 && score <= 100) {
            return 'A';
        } else if (score >= 80 && score <= 89) {
            return 'B';
        } else if (score >= 70 && score <= 79) {
            return 'C';
        } else if (score >= 60 && score <= 69) {
            return 'D';
        } else {
            return 'F';
        }
    }

    public static String[] findFailingStudents(String[] names, int[] scores) {
        ArrayList<String> failing = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (scores[i] < 60) {
                failing.add(names[i]);
            }
        }
        return failing.toArray(new String[0]);
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        String[] reversedNames = reverseStudentNames(students);
        System.out.println("Reversed Names:");
        for (String name : reversedNames) {
            System.out.println(name);
        }

        System.out.println("\nLetter Grades:");
        for (int i = 0; i < scores.length; i++) {
            System.out.println(students[i] + ": " + getLetterGrade(scores[i]));
        }

        String[] failing = findFailingStudents(students, scores);
        System.out.println("\nFailing Students:");
        for (String name : failing) {
            System.out.println(name);
        }
    }
}
