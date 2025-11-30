package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

class MenuTest {

    @Test
    void createMenu() {
        // given
        String name = "양송이수프";
        MenuItem menu = MenuItem.findMenu(name);
        int count = 10;

        // expect
        Assertions.assertThatCode(() -> new Menu(menu, count)).doesNotThrowAnyException();
    }

    @Test
    void createMenu_invalidCount_exception() {
        // given
        String name = "양송이수프";
        MenuItem menu = MenuItem.findMenu(name);

        int count = 0;

        // expect
        Assertions.assertThatThrownBy(() -> new Menu(menu, count))
                .isInstanceOf(IllegalArgumentException.class);
    }
    
    @NullAndEmptySource
    @ParameterizedTest
    void createMenu_blankMenu_exception(String input) {
        // given
        String name = input;
        int count = 1;

        // expect
        Assertions.assertThatThrownBy(() -> new Menu(MenuItem.findMenu(name), count))
                .isInstanceOf(IllegalArgumentException.class);
    }


}
