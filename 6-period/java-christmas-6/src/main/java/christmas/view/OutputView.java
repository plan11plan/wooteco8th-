package christmas.view;

import christmas.calculate.ChristmasDayDiscount.DiscountResult;
import christmas.model.Badge;
import christmas.model.Menu;
import christmas.model.MenuItem;
import christmas.model.Receipt;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class OutputView {
    public void printInitMessage() {
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다");
    }

    public void benefitGuideMessage(int day) {
        String format = String.format("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", 12, day);
        System.out.println(format + System.lineSeparator());
    }

    public void printMyMenus(List<Menu> menus) {
        System.out.println("<주문 메뉴>");
        menus.forEach(menu -> System.out.println(menu.menuItem().name() + " " + menu.count() + "개"));
        System.out.println();
    }

    public void printMyEventResults(Receipt receipt) {
        printTotalPriceOfMenus(receipt.totalPriceBeforeDiscount());

        HashMap<MenuItem, Integer> map = new HashMap<>();
        MenuItem promotionItem = receipt.promotionMenu();
        if (promotionItem != null) {
            map.put(promotionItem, 1);
        }

        printMyPromotionMenu(map);
        printBenefitDetails(receipt.appliedEvent());
        printTotalDiscountAmount(receipt.totalDiscountAmount());
        printFeeOfExpectation(receipt.fee());
        printMyBadge(receipt.badge());
    }

    private void printTotalPriceOfMenus(int totalPriceOfMenus) {
        System.out.println("<할인 전 총주문 금액>");
        System.out.println(totalPriceOfMenus);
        System.out.println();
    }

    private void printMyPromotionMenu(Map<MenuItem, Integer> promotions) {
        System.out.println("<증정 메뉴>");
        if (!promotions.isEmpty()) {
            promotions.entrySet()
                    .forEach(entry -> System.out.println(entry.getKey().name() + " " + entry.getValue() + "개"));
        } else {
            System.out.println("없음");
        }
        System.out.println();
    }

    private void printBenefitDetails(List<DiscountResult> benefits) {
        System.out.println("<혜택 내역>");
        if (!benefits.isEmpty()) {
            benefits.forEach(result -> System.out.println(
                    result.discountPolicy().getName() + " " + "-" + result.discountAmount() + "원"));
        } else {
            System.out.println("0원");
        }
        System.out.println();
    }


    private void printTotalDiscountAmount(int totalDiscountAmount) {
        System.out.println("<총혜택 금액>");
        System.out.println("-" + totalDiscountAmount);
        System.out.println();
    }

    private void printFeeOfExpectation(int feeOfExpectation) {
        System.out.println("<할인 후 예상 결제 금액>");
        System.out.println(feeOfExpectation + "원");
        System.out.println();
    }

    private void printMyBadge(Badge badge) {
        System.out.println("<12월 산타 뱃지>");
        System.out.println(badge.name());
        System.out.println();
    }

}
