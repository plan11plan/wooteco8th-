package christmas.calculate;

import christmas.calculate.ChristmasDayDiscount.DiscountResult;
import christmas.model.DiscountContext;
import christmas.model.MenuItem;
import java.time.LocalDate;

/**
 * 증정 이벤트 기간 2023.12.1 ~ 2023.12.31 조건 할인 전 총주문 금액이 12만원 이상 보상 샴페인 1개 증정
 */

public class PromotionEvent implements DiscountPolicy {
    private static final MenuItem REWARD = MenuItem.샴페인;
    private static final int REWARD_CRITERIA = 120_000;
    private final String name = "증정 이벤트";


    @Override
    public DiscountResult apply(DiscountContext context) {
        int totalAmount = context.totalAmount();

        int discountAmount = REWARD.getPrice();
        int appliedAmount = totalAmount - discountAmount;

        return new DiscountResult(this, totalAmount, discountAmount, appliedAmount);

    }

    @Override
    public boolean canApply(DiscountContext context) {
        LocalDate date = context.visitDate();
        int totalAmount = context.totalAmount();
        if (isValidPeriod(date) && meetCriteria(totalAmount)) {
            return true;
        }
        return false;
    }

    @Override
    public String getName() {
        return this.name;
    }

    private boolean meetCriteria(int totalAmount) {
        return totalAmount >= REWARD_CRITERIA;
    }

    private boolean isValidPeriod(LocalDate date) {
        return date.isAfter(LocalDate.of(2023, 12, 1)) && date.isBefore(LocalDate.of(2023, 12, 31));
    }

}
