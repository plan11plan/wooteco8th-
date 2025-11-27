package christmas.model;

import christmas.common.ErrorMessage;
import java.util.Objects;

public record Menu(String name, int count) {
    public Menu {
        validate(name,count);
    }

    private void validate(String name, int count) {
        validateNameBlank(name);
        validateMenuItem(name);
        validateMinCount(count);

    }


    private void validateNameBlank(String name) {
        if(name == null || name.isBlank()) throw new IllegalArgumentException(ErrorMessage.Menu.INVALID_INPUT);
    }
    private void validateMenuItem(String name) {
        MenuItem menu = MenuItem.findMenu(name);
        if(Objects.isNull(menu)) throw new IllegalArgumentException(ErrorMessage.Menu.INVALID_INPUT);
    }

    private void validateMinCount(int count) {
        if(count < 1 ) throw new IllegalArgumentException(ErrorMessage.Menu.INVALID_INPUT);
    }

}
