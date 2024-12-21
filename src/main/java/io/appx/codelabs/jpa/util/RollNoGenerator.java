package io.appx.codelabs.jpa.util;

import java.util.Random;

public class RollNoGenerator {
    public static String generateId() {
        Random random = new Random();
        StringBuilder sb = new StringBuilder();

        // First 3 characters - upper case alphabets
        for (int i = 0; i < 3; i++) {
            sb.append((char) ('A' + random.nextInt(26)));
        }

        // Next 2 characters - current year in YY format
        int year = java.time.Year.now().getValue();
        String yearYY = String.format("%02d", year % 100);
        sb.append(yearYY);

        // Next 7 characters - random number
        int randomSevenDigit = 1000000 + random.nextInt(9000000); // Ensures 7-digit number
        sb.append(randomSevenDigit);

        // Next 1 character - upper case alphabet
        sb.append((char) ('A' + random.nextInt(26)));

        // Last character - number other than 0
        sb.append(1 + random.nextInt(9)); // Ensures a digit between 1 and 9

        return sb.toString();
    }
}
