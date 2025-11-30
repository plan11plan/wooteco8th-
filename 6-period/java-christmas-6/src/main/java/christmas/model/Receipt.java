package christmas.model;

import christmas.calculate.ChristmasDayDiscount.DiscountResult;
import java.util.List;

public record Receipt(
        List<Menu> myMenus,
        int totalPriceBeforeDiscount,
        MenuItem promotionMenu,
        List<DiscountResult> appliedEvent,
        int totalDiscountAmount,
        int fee,
        Badge badge
) {
}
