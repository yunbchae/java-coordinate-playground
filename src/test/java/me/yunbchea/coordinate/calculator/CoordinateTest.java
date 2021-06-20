package me.yunbchea.coordinate.calculator;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CoordinateTest {

    @ParameterizedTest(name = "좌표 입력 값이 0에서 24 사이의 값이면 Coordinate 객체가 생성된다.")
    @ValueSource(ints = {0, 24})
    public void createCoordinateSuccessTest(int value) {
        Coordinate coordinate = new Coordinate(value);
        assertThat(coordinate).isNotNull();
    }

    @ParameterizedTest(name = "좌표 입력 값이 0에서 24 사이의 값이 아니라면 예외가 발생한다.")
    @ValueSource(ints = {-1, 25})
    public void createCoordinateFailTest(int value) {
        assertThatIllegalArgumentException().isThrownBy(() -> new Coordinate(value));
    }

}