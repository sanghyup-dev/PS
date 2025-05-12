import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter lines of text (digits will be summed). Enter 'done' to stop");

        long Totalsum = 0;
        while (true) {
            String line = sc.nextLine();
            if (line.equals("done"))
                break;
            long sum = 0;
            for (char c : line.toCharArray()) {
                if (Character.isDigit(c)) {
                    sum += c - '0';
                }
            }
            Totalsum += sum;
        }
        System.out.println("Done.\n");
        System.out.println("Total Sum of points: " + Totalsum);
        LocalDate targetDate = LocalDate.of(2025, 6, 23);
        LocalDate today = LocalDate.now();
        long totalDays = ChronoUnit.DAYS.between(today, targetDate) - 2;
        System.out.println("Days remaining: " + totalDays);
        System.out.println("points per day needed: " + (Totalsum / totalDays + 1));
        sc.close();
    }
}
