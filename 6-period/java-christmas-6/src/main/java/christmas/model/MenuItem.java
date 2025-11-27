package christmas.model;


import java.util.Arrays;

public enum MenuItem {


    양송이수프(6000, MenuCategory.APPETIZER), 타파스(5_500,MenuCategory.APPETIZER), 시저샐러드(8_000,MenuCategory.APPETIZER),
    티본스테이크(55_000, MenuCategory.MAIN), 바비큐립(54_000,MenuCategory.MAIN), 해산물파스타(35_000,MenuCategory.MAIN), 크리스마스파스타(25_000,MenuCategory.MAIN),
    초코케이크(15_000,MenuCategory.DESSERT), 아이스크림(5_000, MenuCategory.DESSERT),
    제로콜라(3_000,MenuCategory.DRINK), 레드와인(60_000,MenuCategory.DRINK), 샴페인(25_000,MenuCategory.DRINK),
    ;
    enum MenuCategory {APPETIZER, MAIN, DESSERT, DRINK}

    private final int price;
    private final MenuCategory category;


    MenuItem(int price, MenuCategory category) {
        this.price = price;
        this.category = category;
    }


    public int getPrice() {
        return price;
    }

    public String getCategory() {
        return category.name();
    }

    public static MenuItem findMenu(String name){
        return Arrays.stream(MenuItem.values())
                .filter(menu -> menu.name().equals(name))
                .findFirst()
                .orElse(null);
    }

}
