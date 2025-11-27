package christmas.controller;

import christmas.model.Menus;
import christmas.model.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView inputView;
    private final OutputView outputView;

    public ChristmasController(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void run() {
        VisitDate visitDate = readDate();
        Menus menus = readMenus();
        outputView.printBenefitDetails(null,false);
        outputView.benefitGuideMessage(visitDate.getDay());
        System.out.println("           \"<주문 메뉴>\",\n"
                + "                \"<할인 전 총주문 금액>\",\n"
                + "                \"<증정 메뉴>\",\n"
                + "                \"<혜택 내역>\",\n"
                + "                \"<총혜택 금액>\",\n"
                + "                \"<할인 후 예상 결제 금액>\",\n"
                + "                \"<12월 이벤트 배지>\"");

    }

    private VisitDate readDate() {
        outputView.printInitMessage();
        while (true) {
            try {
                var readDate = inputView.readDate();
                return new VisitDate(readDate);
            } catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
    private Menus readMenus(){
        while (true) {
            try {
                var readMenus = inputView.readMenus();
                Menus menus = new Menus(readMenus);
                outputView.printMyMenus(menus.getMenus());
                return new Menus(readMenus);
            }catch (IllegalArgumentException e){
                System.out.println(e.getMessage());
            }
        }
    }
}
