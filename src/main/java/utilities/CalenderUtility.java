package utilities;

import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;

public class CalenderUtility {

    public static String getCurrentMonth() {

        LocalDate currentDate = LocalDate.now();

        // Get the current month
        Month currentMonth = currentDate.getMonth();

        // Calculate next month
        Month nextMonth = currentMonth.plus(2);
        if (nextMonth == Month.JANUARY) {
            // Increment the year if next month is January
            currentDate = currentDate.plusYears(1);
        }

        // Format the next month in 3-letter format
        String nextMonthFormatted = nextMonth.getDisplayName(
                java.time.format.TextStyle.SHORT,
                java.util.Locale.ENGLISH
        );

        return nextMonthFormatted;
    }

    public static String calculateDate(int days) {

        // Get the current date
        LocalDate today = LocalDate.now();

        // Add 355 days to the current date
        LocalDate futureDate = today.plusDays(days);

        // Create a DateTimeFormatter with the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM yyyy");

        // Format the future date
        String formattedDate = futureDate.format(formatter);

        return formattedDate;
    }

    public static String completeDate(int days) {

        // Get the current date
        LocalDate today = LocalDate.now();

        // Add 355 days to the current date
        LocalDate futureDate = today.plusDays(days);

        // Create a DateTimeFormatter with the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM d, yyyy");

        // Format the future date
        String formattedDate = futureDate.format(formatter);

        return formattedDate;
    }

    public static String getNextMonth() {
        // Get the current date
        LocalDate currentDate = LocalDate.now();

        // Get the first day of the next month
        LocalDate firstDayOfNextMonth = currentDate.plusMonths(1).withDayOfMonth(1);

        // Define the desired format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM.yyyy");

        // Format the date
        String formattedDate = firstDayOfNextMonth.format(formatter);

        return formattedDate;
    }

    public static String getNextMonthDate(int dayOfMonth) {
        if (dayOfMonth < 1 || dayOfMonth > 30) {
            throw new IllegalArgumentException("Day of month must be between 1 and 30.");
        }

        LocalDate today = LocalDate.now();
        LocalDate nextMonth = today.plusMonths(1);

        // Adjust to the correct day of the month, or set it to the last valid day if it exceeds
        LocalDate nextMonthDate = nextMonth.withDayOfMonth(Math.min(dayOfMonth, nextMonth.lengthOfMonth()));

        // Format the date to the desired output format
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("EEE MMM dd yyyy");
        return nextMonthDate.format(formatter);
    }

    public static void main(String [] args){
        

    }

}

