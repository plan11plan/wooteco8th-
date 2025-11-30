package christmas;

import christmas.calculate.ChristmasDayDiscount.DiscountResult;
import christmas.calculate.DiscountPolicy;
import christmas.calculate.PromotionEvent;
import christmas.model.Badge;
import christmas.model.DiscountContext;
import christmas.model.Menu;
import christmas.model.MenuItem;
import christmas.model.Menus;
import christmas.model.Receipt;
import christmas.model.VisitDate;
import java.time.LocalDate;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ChristmasService {
    private final List<DiscountPolicy> discountPolicies;
    private final Map<DiscountPolicy, DiscountResult> repository;

    public ChristmasService(List<DiscountPolicy> discountPolicies) {
        this.discountPolicies = discountPolicies;
        this.repository = new HashMap<>();
    }

    public Receipt calculateBefefitOfExpectation(VisitDate visitDate, Menus menus) {
        List<Menu> myMenus = menus.getMenus();
        LocalDate myDate = visitDate.getDate();
        int totalPriceBeforeDiscount = calculateTotalPriceBeforeDiscount(myMenus);

        DiscountContext discountContext = new DiscountContext(myDate, myMenus, totalPriceBeforeDiscount);

        List<DiscountPolicy> myPolicy = discountPolicies.stream()
                .filter(policy -> policy.canApply(discountContext))
                .toList();

        List<DiscountResult> results = myPolicy.stream()
                .map(policy -> policy.apply(discountContext))
                .toList();

        DiscountResult discountResult = results.stream().filter(i -> i.discountPolicy() instanceof PromotionEvent)
                .findFirst()
                .get();
        MenuItem menuItem = null;
        if (discountResult.discountAmount() >= 120000) {
            menuItem = MenuItem.샴페인;

        }
        int sum = results.stream()
                .mapToInt(i -> i.discountAmount())
                .sum();
        if (menuItem != null) {
            sum -= MenuItem.샴페인.getPrice();
        }
        Badge badge = Badge.valueOf(sum);
        return new Receipt(
                myMenus,
                totalPriceBeforeDiscount,
                menuItem,
                results,
                sum,
                totalPriceBeforeDiscount - sum,
                badge
        );
    }

    private int calculateTotalPriceBeforeDiscount(List<Menu> myMenus) {
        return myMenus.stream()
                .mapToInt(i -> i.menuItem().getPrice() * i.count())
                .sum();
    }
}
