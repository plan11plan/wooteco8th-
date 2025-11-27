package christmas.model;

import christmas.common.ErrorMessage;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Menus {
    private final List<Menu> menus;
    public Menus(String input) {
        menus = parseAndValidate(input);
    }

    private List<Menu> parseAndValidate(String input) {
        List<Menu> menus = new ArrayList<>();
        String[] split = input.trim().split(",");

        for (String menu : split) {
            String[] menuInfo = menu.trim().split("-");
            String name = menuInfo[0];
            int count = parseToInt(menuInfo);
            menus.add(new Menu(name, count));
        }
        validateDuplicateNames(menus);
        return menus;
    }

    private static void validateDuplicateNames(List<Menu> menus) {
        List<String> names = menus.stream().map(i -> i.name()).toList();
        Set<String> unduplicatedNames = new HashSet<>(names);
        if(names.size() != unduplicatedNames.size()) {
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
       return this.menus;
    }
}
