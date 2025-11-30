package christmas.calculate;

import christmas.calculate.ChristmasDayDiscount.DiscountResult;
import christmas.model.DiscountContext;

public interface DiscountPolicy {
    boolean canApply(DiscountContext context);

    DiscountResult apply(DiscountContext context);

    String getName();
}
