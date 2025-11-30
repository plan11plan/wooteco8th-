package christmas;

import christmas.model.Menus;
import christmas.model.Receipt;
import christmas.model.VisitDate;
import christmas.view.InputView;
import christmas.view.OutputView;

public class ChristmasController {
    private final InputView inputView;
    private final OutputView outputView;
    private final ChristmasService christmasService;

    public ChristmasController(InputView inputView, OutputView outputView, ChristmasService christmasService) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.christmasService = christmasService;
    }

    public void run() {
        VisitDate visitDate = readDate();
        Menus menus = readMenus();
        outputView.benefitGuideMessage(visitDate.getDay());
        Receipt receipt = christmasService.calculateBefefitOfExpectation(visitDate, menus);
        outputView.printMyEventResults(receipt);
    }

    private VisitDate readDate() {
        outputView.printInitMessage();
        while (true) {
            try {
                var readDate = inputView.readDate();
                return new VisitDate(readDate);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private Menus readMenus() {
        while (true) {
            try {
                var readMenus = inputView.readMenus();
                Menus menus = new Menus(readMenus);
                outputView.printMyMenus(menus.getMenus());
                return new Menus(readMenus);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
