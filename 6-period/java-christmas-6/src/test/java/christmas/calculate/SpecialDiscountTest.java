//package christmas.calculate;
//
//import christmas.calculate.ChristmasDayDiscount.DiscountResult;
//import java.time.LocalDate;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//class SpecialDiscountTest {
//    @ParameterizedTest
//    @ValueSource(ints = {3, 10, 17, 24, 31, 25})
//    void apply(int day) {
//        // given
//        SpecialDiscount discount = new SpecialDiscount();
//
//        // when
//        DiscountResult apply = discount.apply(10_000);
//
//        org.assertj.core.api.Assertions.assertThat(apply.discountAmount()).isEqualTo(1000);
//    }
//
//    @Test
//    void canApplyDiscount_false() {
//        // given
//        LocalDate localDate = LocalDate.of(2023, 12, 1);
//        SpecialDiscount discount = new SpecialDiscount();
//
//        // when
//        boolean b = discount.canApply(localDate);
//
//        // then
//        Assertions.assertFalse(b);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {3, 10, 17, 24, 31, 25})
//    void canApplyDiscount_true(int day) {
//        // given
//        LocalDate localDate = LocalDate.of(2023, 12, day);
//        SpecialDiscount discount = new SpecialDiscount();
//
//        // when
//        boolean b = discount.canApply(localDate);
//
//        // then
//        Assertions.assertTrue(b);
//    }
//
//}
