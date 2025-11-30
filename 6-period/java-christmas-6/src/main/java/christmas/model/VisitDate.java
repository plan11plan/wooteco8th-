package christmas.model;

import christmas.common.ErrorMessage;
import java.time.DateTimeException;
import java.time.LocalDate;

public class VisitDate {
    private final static Integer YEAR = 2023;
    private final static Integer MONTH = 12;
    private final int day;
    private final LocalDate date;

    public VisitDate(String day) {
        try {
            int parseDay = Integer.parseInt(day);
            validateBoundary(parseDay);
            LocalDate localDate = LocalDate.of(YEAR, MONTH, parseDay);
            this.day = localDate.getDayOfMonth();
            this.date = localDate;
        } catch (NumberFormatException | DateTimeException e) {
            throw new IllegalArgumentException(ErrorMessage.VisitDate.INVALID_INPUT);
        }
    }

    public LocalDate getDate() {
        return date;
    }

    private void validateBoundary(int parseDay) {
        if (parseDay < 1 || parseDay > 31) {
            throw new IllegalArgumentException(ErrorMessage.VisitDate.INVALID_INPUT);
        }
    }

    public int getMonth() {
        return MONTH;
    }

    public int getDay() {
        return day;
    }
}
