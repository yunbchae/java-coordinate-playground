package me.yunbchae.coordinate.calculator;

import java.util.Collections;
import java.util.List;

public abstract class Points {

    private final List<Point> points;

    protected Points(List<Point> points) {
        validate(points);
        this.points = Collections.unmodifiableList(points);
    }

    public List<Point> getPoints() {
        return points;
    }

    protected abstract void validate(List<Point> points);

}
