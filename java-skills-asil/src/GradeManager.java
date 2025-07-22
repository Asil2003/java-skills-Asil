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
        return 'F';
    }

    public static String[] findFailingStudents(String[] names, int[] scores) {
        return null;
    }

    public static void main(String[] args) {
        String[] students = {"Alice", "Bob", "Charlie", "Diana"};
        int[] scores = {95, 67, 45, 78};

        String[] reversedNames = reverseStudentNames(students);
        System.out.println("Reversed Names:");
        for (String name : reversedNames) {
            System.out.println(name);
        }
    }
}
