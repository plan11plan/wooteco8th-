//package christmas.calculate;
//
//import christmas.calculate.ChristmasDayDiscount.DiscountResult;
//import christmas.model.Menu;
//import christmas.model.MenuItem;
//import java.time.LocalDate;
//import java.util.List;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.Test;
//import org.junit.jupiter.params.ParameterizedTest;
//import org.junit.jupiter.params.provider.ValueSource;
//
//class WeekEndDiscountTest {
//    @Test
//    void apply() {
//        // given
//        WeekEndDiscount discount = new WeekEndDiscount();
//        Menu menu1 = new Menu(MenuItem.바비큐립, 2);
//        Menu menu2 = new Menu(MenuItem.제로콜라, 2);
//        Menu menu3 = new Menu(MenuItem.아이스크림, 2);
//
//        List<Menu> menus = List.of(menu1, menu2, menu3);
//
//        // when
//        DiscountResult apply = discount.apply(menus, 10_000);
//
//        org.assertj.core.api.Assertions.assertThat(apply.discountAmount()).isPositive();
//    }
//
//    @Test
//    void canApplyDiscount_false() {
//        // given
//        LocalDate localDate = LocalDate.of(2023, 12, 1);
//        WeekEndDiscount discount = new WeekEndDiscount();
//
//        // when
//        boolean b = discount.canApply(localDate);
//
//        // then
//        Assertions.assertFalse(b);
//    }
//
//    @ParameterizedTest
//    @ValueSource(ints = {8, 9, 15, 16})
//    void canApplyDiscount_true(int day) {
//        // given
//        LocalDate localDate = LocalDate.of(2023, 12, day);
//        WeekEndDiscount discount = new WeekEndDiscount();
//
//        // when
//        boolean b = discount.canApply(localDate);
//
//        // then
//        Assertions.assertTrue(b);
//    }
//
//}
