package christmas.view;

import christmas.model.Menu;
import java.util.List;

public class OutputView {
    public void printInitMessage(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다");
    }

    public void printMyMenus(List<Menu> menus){
        System.out.println("<주문 메뉴>");
        menus.forEach( menu -> System.out.println(menu.name() + " " + menu.count()+"개"));
        System.out.println();
    }

    public void printBenefitDetails(Object benefit, boolean hasBenefit){
        if(hasBenefit == false){
            System.out.println("<혜택 내역>");
            System.out.println("없음");
        }
    }
    public void benefitGuideMessage(int day){
        String format = String.format("%d월 %d일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!", 12, day);
        System.out.println(format + System.lineSeparator());
    }
}
