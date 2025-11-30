//package christmas.calculate;
//
//import christmas.calculate.ChristmasDayDiscount.DiscountResult;
//import java.time.LocalDate;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//
//class PromotionEventTest {
//
//    @Test
//    void apply() {
//        // given
//        PromotionEvent discount = new PromotionEvent();
//
//        // when
//        DiscountResult apply = discount.apply(120_000);
//
//        org.assertj.core.api.Assertions.assertThat(apply.discountAmount()).isPositive();
//    }
//
//    @Test
//    void canApplyDiscount_false() {
//        // given
//        PromotionEvent discount = new PromotionEvent();
//        LocalDate localDate = LocalDate.of(2023, 12, 4);
//        int totalAmount = 119_999;
//
//        // when
//        boolean b = discount.canApply(localDate, totalAmount);
//
//        // then
//        Assertions.assertFalse(b);
//    }
//
//    @Test
//    void canApplyDiscount_true() {
//        // given
//        PromotionEvent discount = new PromotionEvent();
//        LocalDate localDate = LocalDate.of(2023, 12, 4);
//        int totalAmount = 120_000;
//
//        // when
//        boolean b = discount.canApply(localDate, totalAmount);
//
//        // then
//        Assertions.assertTrue(b);
//    }
//
//}
