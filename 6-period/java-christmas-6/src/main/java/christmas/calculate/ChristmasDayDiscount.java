package christmas.calculate;

import christmas.model.DiscountContext;
import java.time.LocalDate;

/**
 * 크리스마스 디데이 할인 기간 12월 25일 보상 1,000원으로 시작하여 크리스마스가 다가올수록 할인 금액이 100원씩 증가 총주문 금액에서 할인 (e.g. 시작일인 12월 1일에 1,000원, 2일에
 * 1,100원, ..., 25일엔 3,400원 할인)
 */
public class ChristmasDayDiscount implements DiscountPolicy {
    private static final int DISCOUNT_DEFAULT = 1000;
    private static final int DISCOUNT_UNIT = 100;
    private static final int DISCOUNT_DAY = 25;
    private final String name = "크리스마스 디데이 할인";

    private static boolean isValidPeriod(LocalDate date) {
        return date.isAfter(LocalDate.of(2023, 12, 1)) && date.isBefore(LocalDate.of(2023, 12, 31));
    }

    public DiscountResult apply(DiscountContext context) {
        int day = context.visitDate().getDayOfMonth();
        int totalAmount = context.totalAmount();
        int discountAmount = DISCOUNT_DEFAULT + (day - 1) * DISCOUNT_UNIT;
        int appliedAmount = totalAmount - discountAmount;
        return new DiscountResult(this, totalAmount, discountAmount, appliedAmount);

    }

    @Override
    public String getName() {
        return this.name;
    }

    public boolean canApply(DiscountContext context) {
        if (isValidPeriod(context.visitDate())) {
            return true;
        }
        return false;
    }

    public record DiscountResult(
            DiscountPolicy discountPolicy,
            int totalAmount,
            int discountAmount,
            int appliedAmount
    ) {
        @Override
        public String toString() {
            return "DiscountResult{" +
                    "discountPolicy=" + discountPolicy +
                    ", totalAmount=" + totalAmount +
                    ", discountAmount=" + discountAmount +
                    ", appliedAmount=" + appliedAmount +
                    '}';
        }
    }
}
