package christmas.calculate;

import static christmas.model.MenuItem.MenuCategory.DESSERT;
import static java.time.DayOfWeek.MONDAY;
import static java.time.DayOfWeek.SUNDAY;
import static java.time.DayOfWeek.THURSDAY;
import static java.time.DayOfWeek.TUESDAY;
import static java.time.DayOfWeek.WEDNESDAY;

import christmas.calculate.ChristmasDayDiscount.DiscountResult;
import christmas.model.DiscountContext;
import christmas.model.Menu;
import java.time.DayOfWeek;
import java.time.LocalDate;
import java.util.List;
import java.util.Objects;

/**
 * 평일 할인 기간 2023.12.1 ~ 2023.12.31 (일요일~목요일) 보상 디저트메뉴 1개당 2,023원 할인
 */
public class WeekDaysDiscount implements DiscountPolicy {
    private static final int DISCOUNT_UNIT = 2_023;
    private final List<DayOfWeek> days;
    private final String name = "평일 할인";

    public WeekDaysDiscount() {
        this.days = List.of(SUNDAY, MONDAY, TUESDAY, WEDNESDAY, THURSDAY);
    }

    private static boolean isValidPeriod(LocalDate date) {
        return date.isAfter(LocalDate.of(2023, 12, 1)) && date.isBefore(LocalDate.of(2023, 12, 31));
    }

    @Override
    public DiscountResult apply(DiscountContext context) {
        List<Menu> menus = context.menus();
        int totalAmount = context.totalAmount();

        int count = menus.stream()
                .filter(menu -> Objects.equals(menu.menuItem().getCategory(), DESSERT.name()))
                .mapToInt(i -> i.count())
                .sum();
        int discountAmount = count * DISCOUNT_UNIT;
        int appliedAmount = totalAmount - discountAmount;

        return new DiscountResult(this, totalAmount, discountAmount, appliedAmount);

    }

    @Override
    public boolean canApply(DiscountContext context) {
        LocalDate date = context.visitDate();
        if (isValidPeriod(date) && isValidDayOfWeek(date)) {
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return name;
    }

    private boolean isValidDayOfWeek(LocalDate date) {
        boolean appliable = days.stream()
                .anyMatch(day -> day.equals(date.getDayOfWeek()));
        if (appliable) {
            return true;
        }
        return false;
    }
}
