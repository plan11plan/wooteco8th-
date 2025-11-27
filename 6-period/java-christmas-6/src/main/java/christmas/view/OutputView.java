package christmas.view;

import java.util.Map;

public class OutputView {
    public void printInitMessage(){
        System.out.println("안녕하세요! 우테코 식당 12월 이벤트 플래너입니다");
    }

    public void printMyMenus(Map<String, Integer> menus){
        System.out.println("<주문 메뉴>");
        menus.forEach((k,v) -> System.out.println(k + " " + v+"개"));
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
