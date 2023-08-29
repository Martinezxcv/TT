package org.example.fileData;

import java.time.LocalDate;

public class DateFormatImpl {

    public LocalDate dateFormat() {
        int day = createRandomIntBetween(1, 28);
        int month = createRandomIntBetween(1, 12);
        int year = createRandomIntBetween(1945, 2023);
        return LocalDate.of(year, month, day);
    }

    private static int createRandomIntBetween(int start, int end) {
        return start + (int) Math.round(Math.random() * (end - start));
    }
}

