package christmas.model;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class VisitDateTest {

    @ParameterizedTest
    @ValueSource(strings= {"1","31"})
    void create_visitdate(String number){

        // expect
        Assertions.assertThatCode( () -> new VisitDate(number))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(strings= {"0","32"})
    void create_boundary_exception(String number){

        // expect
        Assertions.assertThatCode( () -> new VisitDate(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

}
