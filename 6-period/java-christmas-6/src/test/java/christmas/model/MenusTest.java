package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class MenusTest {

    @Test
    void createMenus_duplicateMenus_exception(){
        // given
        String input ="양송이수프-2,양송이수프-2";

        //expect
        Assertions.assertThatCode( () -> new Menus(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
