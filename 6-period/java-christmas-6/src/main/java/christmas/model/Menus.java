package christmas.model;

import christmas.common.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Objects;
import java.util.Set;

public class Menus {
    private final List<Menu> menus;

    public Menus(String menus) {
        this.menus = parseAndValidate(menus);
    }

    private static void validateDuplicateNames(List<Menu> menus) {
        List<String> names = menus.stream().map(i -> i.menuItem().name()).toList();
        Set<String> unduplicatedNames = new HashSet<>(names);
        if (names.size() != unduplicatedNames.size()) {
            throw new IllegalArgumentException(ErrorMessage.Menu.INVALID_INPUT);
        }
    }

    private List<Menu> parseAndValidate(String input) {
        List<Menu> menus = new ArrayList<>();
        String[] split = input.trim().split(",");

        for (String menu : split) {
            String[] menuInfo = menu.trim().split("-");
            String name = menuInfo[0];
            int count = parseToInt(menuInfo);
            MenuItem menuItem = MenuItem.findMenu(name);
            validateMenuItem(menuItem);
            menus.add(new Menu(menuItem, count));
        }
        validateDuplicateNames(menus);
        return menus;
    }

    private void validateMenuItem(MenuItem menu) {
        if (Objects.isNull(menu)) {
            throw new IllegalArgumentException(ErrorMessage.Menu.INVALID_INPUT);
        }
    }

    private int parseToInt(String[] menuInfo) {
        int count;
        try {
            count = Integer.parseInt(menuInfo[1]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException(ErrorMessage.Menu.INVALID_INPUT);
        }
        return count;
    }

    public List<Menu> getMenus() {
        return menus;
    }
}
