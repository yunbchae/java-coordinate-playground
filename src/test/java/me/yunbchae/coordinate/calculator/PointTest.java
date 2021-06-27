package me.yunbchae.coordinate.calculator;

import me.yunbchae.coordinate.calculator.exception.PointsInputException;
import me.yunbchae.coordinate.calculator.model.Point;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.*;

class PointTest {

    @ParameterizedTest(name = "좌표 형식이 잘못된 경우 예외가 발생한다.")
    @ValueSource(strings = {"12,14", "{12,14}", "(12:14)"})
    public void createPointTest(String inputString) {
        assertThatThrownBy(() -> Point.of(inputString)).isExactlyInstanceOf(PointsInputException.class);
    }

    @DisplayName("두 좌표 값이 주어졌을 때, 거리를 계산 할 수 있다.")
    @Test
    public void caculateDistanceTest() {
        int x1 = 10;
        int y1 = 10;
        int x2 = 14;
        int y2 = 15;
        double distance = Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
        Point point1 = Point.of(String.format("(%d,%d)", x1, y1));
        Point point2 = Point.of(String.format("(%d,%d)", x2, y2));
        assertThat(point1.measureDistanceFrom(point2)).isCloseTo(distance, offset(0.000001));
    }
}