package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.exception.PointsInputException;
import me.yunbchae.coordinate.calculator.model.Coordinate;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class CoordinateTest {

    @ParameterizedTest(name = "좌표 입력 값이 0에서 24 사이의 값이면 Coordinate 객체가 생성된다.")
    @ValueSource(ints = {0, 24})
    public void createCoordinateSuccessTest(int value) {
        assertThat(Coordinate.of(value)).isNotNull();
    }

    @ParameterizedTest(name = "좌표 입력 값이 0에서 24 사이의 값이 아니라면 예외가 발생한다.")
    @ValueSource(ints = {-1, 25})
    public void createCoordinateFailTest(int value) {
        assertThatThrownBy(() -> Coordinate.of(value)).isExactlyInstanceOf(PointsInputException.class);
    }

    @ParameterizedTest(name = "좌표 값의 차이를 계산 할 수 있다.")
    @CsvSource(value = {"1:1:0", "1:10:9", "10:2:8"}, delimiter = ':')
    public void diffTest(int v1, int v2, int expectedDiff) {
        Coordinate c1 = Coordinate.of(v1);
        Coordinate c2 = Coordinate.of(v2);
        assertThat(c1.diff(c2)).isEqualTo(expectedDiff);
    }

}