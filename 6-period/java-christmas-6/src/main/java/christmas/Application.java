package christmas;

import christmas.calculate.ChristmasDayDiscount;
import christmas.calculate.PromotionEvent;
import christmas.calculate.SpecialDiscount;
import christmas.calculate.WeekDaysDiscount;
import christmas.calculate.WeekEndDiscount;
import christmas.view.InputView;
import christmas.view.OutputView;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        ChristmasController christmasController = new ChristmasController(
                new InputView(),
                new OutputView(),
                new ChristmasService(
                        List.of(
                                new WeekDaysDiscount(),
                                new WeekEndDiscount(),
                                new SpecialDiscount(),
                                new ChristmasDayDiscount(),
                                new PromotionEvent()
                        )
                )
        );
        christmasController.run();
    }
}
