package me.yunbchae.coordinate.calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.offset;

class PointTest {

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
        assertThat(point1.calculateDistanceFrom(point2)).isCloseTo(distance, offset(0.000001));
    }
}