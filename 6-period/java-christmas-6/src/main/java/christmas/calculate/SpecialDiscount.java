package christmas.calculate;

import static java.time.DayOfWeek.SUNDAY;

import christmas.calculate.ChristmasDayDiscount.DiscountResult;
import christmas.model.DiscountContext;
import java.time.LocalDate;

/**
 * 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
 */
public class SpecialDiscount implements DiscountPolicy {
    private static final int DISCOUNT_AMOUNT = 1000;
    private static final int CHRISTMAS_DAY = 25;
    private final String name = "특별 할인";

    @Override
    public DiscountResult apply(DiscountContext context) {
        int totalAmount = context.totalAmount();

        int appliedAmount = totalAmount - DISCOUNT_AMOUNT;
        return new DiscountResult(this, totalAmount, DISCOUNT_AMOUNT, appliedAmount);
    }

    @Override
    public boolean canApply(DiscountContext context) {
        LocalDate date = context.visitDate();
        boolean isSunday = date.getDayOfWeek() == SUNDAY;
        boolean isChristmas = date.getDayOfMonth() == CHRISTMAS_DAY;

        return isSunday || isChristmas;
    }

    @Override
    public String getName() {
        return name;
    }
}
