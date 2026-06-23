import java.util.ArrayList;
import java.util.Scanner;

public class Task2_GradeCalculator {

    static Scanner sc = new Scanner(System.in);

    static String getGrade(double percentage) {
        if (percentage >= 90)
            return "A+";cd C:\Users\HP\Downloads
        else if (percentage >= 80)
            return "A";
        else if (percentage >= 70)
            return "B";
        else if (percentage >= 60)
            return "C";
        else if (percentage >= 50)
            return "D";
        else
            return "F";
    }

    public static void main(String[] args) {
        System.out.println("=============================================");
        System.out.println("        STUDENT GRADE CALCULATOR");
        System.out.println("=============================================");

        System.out.print("Enter student name: ");
        String name = sc.nextLine().trim();

        int numSubjects = 0;

        while (true) {
            System.out.print("Enter number of subjects: ");
            try {
                numSubjects = Integer.parseInt(sc.nextLine().trim());

                if (numSubjects > 0) {
                    break;
                } else {
                    System.out.println("Number of subjects must be positive.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a number.");
            }
        }

        ArrayList<String> subjectNames = new ArrayList<>();
        ArrayList<Double> marks = new ArrayList<>();

        System.out.println("\nEnter marks (out of 100) for each subject:");

        for (int i = 0; i < numSubjects; i++) {
            System.out.print("Subject " + (i + 1) + " name: ");
            String subject = sc.nextLine().trim();

            double mark = 0;

            while (true) {
                System.out.print("Marks for " + subject + ": ");

                try {
                    mark = Double.parseDouble(sc.nextLine().trim());

                    if (mark >= 0 && mark <= 100) {
                        break;
                    } else {
                        System.out.println("Marks must be between 0 and 100.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Invalid input. Enter a numeric value.");
                }
            }

            subjectNames.add(subject);
            marks.add(mark);
        }

        double totalMarks = 0;

        for (double m : marks) {
            totalMarks += m;
        }

        double maxMarks = numSubjects * 100.0;
        double avgPercentage = (totalMarks / maxMarks) * 100;
        String grade = getGrade(avgPercentage);

        System.out.println("\n=============================================");
        System.out.println("               RESULT CARD");
        System.out.println("=============================================");
        System.out.printf("Student Name       : %s%n", name);
        System.out.println("---------------------------------------------");

        for (int i = 0; i < subjectNames.size(); i++) {
            System.out.printf("%-20s : %.1f / 100%n",
                    subjectNames.get(i), marks.get(i));
        }

        System.out.println("---------------------------------------------");
        System.out.printf("Total Marks        : %.1f / %.0f%n",
                totalMarks, maxMarks);
        System.out.printf("Average Percentage : %.2f%%%n",
                avgPercentage);
        System.out.printf("Grade              : %s%n", grade);

        System.out.println("=============================================");

        if (grade.equals("F")) {
            System.out.println("Status: ❌ FAIL - Better luck next time!");
        } else {
            System.out.println("Status: ✅ PASS - Congratulations!");
        }

        System.out.println("=============================================");

        sc.close();
    }
}